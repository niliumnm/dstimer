package com.example.dstimer.service;

import com.example.dstimer.entity.t_user;
import com.example.dstimer.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

//逻辑层 通过这一层判断操作
@Component
public class UserService {
    @Autowired
    private UserMapper userMapper;

    //注册或者更新用户信息
    public int save(t_user user){
        if(user.getId()==null){//没有ID
            return userMapper.insert(user);
        }else {
            return userMapper.updateUser(user);
        }
    }

    //通过用户名查找用户信息
    public t_user getUserByName(String username) {
        return userMapper.getUserByName(username);
    }

    public int deleteUserByID(int id) {
        //id是否合法
        if(id<0||id>65532)return -1;
        return userMapper.deleteUserByID(id);
    }
}
