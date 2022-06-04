package com.example.dstimer.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.dstimer.common.Result;
import com.example.dstimer.entity.Friends;
import com.example.dstimer.entity.User;
import com.example.dstimer.entity.dto.UserDTO;

public interface IFriendsService extends IService<Friends> {

    Friends getOne(QueryWrapper<Friends> queryWrapper);
}

