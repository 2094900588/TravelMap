package com.example.zuinbxm.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.models.auth.In;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Scenery {
    @TableId
    private Integer id;
    private Integer cityid;
    private String name;
    private Integer type;
    private Float lon;
    private Float lat;
    private Float createtime;
}
