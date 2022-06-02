package com.example.dstimer.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.dstimer.entity.t_user;
import org.apache.ibatis.annotations.*;

import java.util.List;

//Dao层 进行实际的操作 由service来调用 没有逻辑判断时可以绕过service直接由controller调用
//@Mapper
public interface UserMapper extends BaseMapper<t_user>{

    //查询所有的用户
    @Select("SELECT * FROM t_user")
    List<t_user> findAll();
//
//    //插入一个新用户
//    @Insert("INSERT INTO t_user(name,nickname,password,avatar_url,sex,email,phone,address)VALUES(#{name},#{nickname},#{password},#{avatar_url},#{sex},#{email},#{phone},#{address});")
//    int insert(t_user user);
//
//    //更新一条用户记录
//    int updateUser(t_user user);


    //通过用户名查询用户
    @Select("SELECT * FROM t_user WHERE name=#{name}")
    t_user getUserByName(String name);


    @Delete("DELETE FROM t_user WHERE id=#{id}")
    int deleteUserByID(int id);

//    @Select("SELECT * FROM t_user WHERE name like #{name} LIMIT #{pageNum},#{pageSize}")
//    List<t_user> selectPage(Integer pageNum, Integer pageSize, String name);
//
//    @Select("SELECT COUNT(*) from t_user WHERE name like #{name} LIMIT #{pageNum},#{pageSize}" )
//    Integer selectTotal(Integer pageNum, Integer pageSize, String name);
}
