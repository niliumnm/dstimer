package com.example.dstimer.service.impl;

import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.dstimer.common.Constants;
import com.example.dstimer.entity.User;
import com.example.dstimer.entity.dto.UserDTO;
import com.example.dstimer.exception.ServiceException;
import com.example.dstimer.mapper.UserMapper;
import com.example.dstimer.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import com.example.dstimer.utils.TokenUtils;
import org.springframework.beans.BeanUtils;
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

    @Override
    public UserDTO login(UserDTO userDTO) {
        User one = getUserInfo(userDTO);
        if (one != null) {
            //Bean自带的拷贝 好像是反射实现的
            BeanUtil.copyProperties(one, userDTO,true);
            //设置Token
            String token = TokenUtils.genToken(one.getId().toString(), one.getPassword());
            userDTO.setToken(token);
            return userDTO;
        } else {
            throw new ServiceException(Constants.CODE_600, "用户名或密码错误");
        }
    }

    @Override
    public User register(UserDTO userDTO) {
        User one = getUserInfo(userDTO);
        if (one == null) {
            one = new User();
            BeanUtils.copyProperties(userDTO, one);
            save(one);//存储
        }else {
            throw new ServiceException(Constants.CODE_600,"用户已存在");
        }
        return one;
    }

    private User getUserInfo(UserDTO userDTO) {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("name", userDTO.getName());
        queryWrapper.eq("password", userDTO.getPassword());
        User one;
        try {
            one = getOne(queryWrapper);
        } catch (Exception e) {
            log.error(String.valueOf(e));
            throw new ServiceException(Constants.CODE_400, "系统错误");
        }
        return one;
    }
}
