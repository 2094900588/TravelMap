package com.example.zuinbxm.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.models.auth.In;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class City {
    @TableId
    private Integer id;
    private String name;
    private Integer savingsid;
    private Float lon;
    private Float lat;
}
