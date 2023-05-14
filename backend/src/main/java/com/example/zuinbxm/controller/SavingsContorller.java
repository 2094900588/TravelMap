package com.example.zuinbxm.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.zuinbxm.common.Result;
import com.example.zuinbxm.entity.Savings;
import com.example.zuinbxm.service.SavingsService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/api/savings")
public class SavingsContorller {
    @Resource
    private SavingsService savingsService;
    //增加修改同一个方法
    @PostMapping
    public Result save(@RequestBody Savings savings) {
        return Result.success(savingsService.saveOrUpdate(savings));
    }
    //根据id查找单独一条记录
    @GetMapping("/{id}")
    public Result findOne(@PathVariable Integer id) {
        return Result.success(savingsService.getById(id));
    }
    //模糊查询的时候进行添加条件既可
    @GetMapping("/page")
    public Result findPage(@RequestParam Integer pageNum,
                           @RequestParam Integer pageSize,
                           @RequestParam(defaultValue = "") String name) {

        QueryWrapper<Savings> queryWrapper=new QueryWrapper<>();


        if(!"".equals(name)) {
            queryWrapper.like("name", name);
        }

        //让新添加的排在页面前面，进行一个排序工作
        queryWrapper.orderByDesc("id");
        //获取当前用户信息
//            User currentUser = TokenUtils.getCurrentUser();
//            System.out.println("获取当前用户信息==================" + currentUser.getNickname());
        return Result.success(savingsService.page(new Page<>(pageNum, pageSize),queryWrapper));
    }
}
