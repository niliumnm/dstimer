package com.example.dstimer.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.dstimer.entity.User;
import com.example.dstimer.entity.dto.UserDTO;
import com.example.dstimer.mapper.UserMapper;
import com.example.dstimer.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author sunbo
 * @since 2022-06-02
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

    @Override
    public boolean login(UserDTO userDTO) {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("name", userDTO.getName());
        queryWrapper.eq("password", userDTO.getPassword());
        List<User>list=list(queryWrapper);
        return list.size() != 0;
    }
}
