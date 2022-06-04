package com.example.dstimer.mapper;

import com.example.dstimer.entity.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;


@Mapper
/**
 * @Mapper注解的的作用
 * 1:为了把mapper这个DAO交給Spring管理
 * 2:为了不再写mapper映射文件
 * 3:为了给mapper接口 自动根据一个添加@Mapper注解的接口生成一个实现类
 */
public interface UserMapper extends BaseMapper<User> {

}
