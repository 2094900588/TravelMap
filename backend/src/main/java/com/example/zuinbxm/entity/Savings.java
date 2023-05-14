package com.example.zuinbxm.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

@Data
public class Savings {
    @TableId
    private Integer id;
    private String name;
    private Float createtime;

}
