package com.example.dstimer.controller;
import com.example.dstimer.entity.t_user;
import com.example.dstimer.mapper.UserMapper;
import com.example.dstimer.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController //表示是可以返回JSON的Controller
@RequestMapping("/user")  //地址映射

class UserController {
    //Mapper相当于Dao层 实际的操作
    @Autowired //自动装配
    private UserMapper userMapper;

    //service是逻辑层 需要判断的时候用
    @Autowired //自动装配

    private UserService userService;
    @GetMapping
    public List<t_user> index() {
        return userMapper.findAll();
    }

    @PostMapping
    public Integer save(@RequestBody t_user user){
        return userService.save(user);
    }
}
