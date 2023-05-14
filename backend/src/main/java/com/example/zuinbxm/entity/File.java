package com.example.zuinbxm.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

@Data
public class File {
    @TableId
    private Integer id;
    private String type;
    private String fsline;
    private String sceneryid;
}
