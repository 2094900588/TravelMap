package com.example.zuinbxm.service.Impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.zuinbxm.entity.Savings;
import com.example.zuinbxm.mapper.SavingsMapper;
import com.example.zuinbxm.service.SavingsService;
import org.springframework.stereotype.Service;

@Service
public class SavingsServiceImpl extends ServiceImpl<SavingsMapper, Savings> implements SavingsService {
}
