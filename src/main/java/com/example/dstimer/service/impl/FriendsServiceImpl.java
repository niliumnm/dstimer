package com.example.dstimer.service.impl;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.dstimer.common.Constants;
import com.example.dstimer.entity.Friends;
import com.example.dstimer.exception.ServiceException;
import com.example.dstimer.mapper.FriendsMapper;
import com.example.dstimer.service.IFriendsService;
import org.springframework.stereotype.Service;

@Service
public class FriendsServiceImpl extends ServiceImpl<FriendsMapper, Friends> implements IFriendsService {

    @Override
    public Friends getOne(QueryWrapper<Friends> queryWrapper) {
        Friends one;
        try {
            one = getOne(queryWrapper);
        } catch (Exception e) {
            log.error(String.valueOf(e));
            throw new ServiceException(Constants.CODE_400, "系统错误");
        }
        return one;
    }

}
