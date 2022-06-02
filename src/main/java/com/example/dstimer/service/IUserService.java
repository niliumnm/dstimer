package com.example.dstimer.service;

import com.example.dstimer.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.dstimer.entity.dto.UserDTO;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author sunbo
 * @since 2022-06-02
 */
public interface IUserService extends IService<User> {

    UserDTO login(UserDTO userDTO);

    User register(UserDTO userDTO);
}
