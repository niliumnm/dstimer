package com.example.dstimer.service.impl;

import com.example.dstimer.entity.User;
import com.example.dstimer.mapper.UserMapper;
import com.example.dstimer.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

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

}
