package com.example.dstimer.mapper;

import com.example.dstimer.entity.t_user;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import java.util.List;

//Dao层 进行实际的操作 由service来调用 没有逻辑判断时可以绕过service直接由controller调用
@Mapper
public interface UserMapper {

    //查询所有的用户
    @Select("SELECT * FROM t_user")
    List<t_user> findAll();

    //插入一个新用户
    @Insert("INSERT INTO t_user(name,nickname,password,avatar_url,sex,email,phone,address)VALUES(#{name},#{nickname},#{password},#{avatar_url},#{sex},#{email},#{phone},#{address});")
    int insert(t_user user);

    //更新一条用户记录
    @Update("UPDATE t_user SET name=#{name},nickname=#{nickname},password=#{password},avatar_url=#{avatar_url},sex=#{sex},email=#{email},phone=#{phone},address=#{address} WHERE id=#{id}")
    int updateUser(t_user user);


    //通过用户名查询用户
    @Select("SELECT * FROM t_user WHERE name=#{name}")
    t_user getUserByName(String name);


}
