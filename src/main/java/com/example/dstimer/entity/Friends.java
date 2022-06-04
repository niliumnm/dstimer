package com.example.dstimer.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@TableName("friendslist")
@ApiModel(value = "User对象", description = "")
public class Friends {
    private Integer id;
    private String friends;
}
