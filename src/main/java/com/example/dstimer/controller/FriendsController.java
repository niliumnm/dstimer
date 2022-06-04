package com.example.dstimer.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.dstimer.common.Result;
import com.example.dstimer.entity.Friends;
import com.example.dstimer.entity.User;
import com.example.dstimer.service.IFriendsService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/Friends")
public class FriendsController {
    @Resource
    private IFriendsService iFriendsService;

    @GetMapping("/{id}")
    public Result findOne(@PathVariable Integer id) {
        QueryWrapper<Friends> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("id", id);
        return Result.success(iFriendsService.getOne(queryWrapper));
    }
}
