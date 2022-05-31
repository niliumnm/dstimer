package com.example.dstimer.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data //getter setter方法
@AllArgsConstructor //全参构造
@NoArgsConstructor //无参构造

public class t_user {
    private Integer id;
    private String name;
    private String nickname;
    private String password;
    private String avatar_url;
    private String sex;
    private String email;
    private String created_at;
    private String updated_at;
    private String phone;
    private String address;

}
