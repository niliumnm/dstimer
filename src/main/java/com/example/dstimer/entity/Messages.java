package com.example.dstimer.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;


@Data  // 直接生成Get 和 Set
@NoArgsConstructor// 构造无参构造方法
@AllArgsConstructor// 构造有参构造方法

public class Messages {
    private Integer id;
    private String group_name; // 群名
    private Integer unread_messages_number; // 未读消息数量
    private String event_name;// 事件名
    private String content;// 内容
    private String remark;//  备注
    private String nickname; // 发起人昵称
    private String avatar; // 头像
    private Date starting_time;// 发起时间
    private Date deadline; // 截止时间
}