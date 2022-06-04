package com.example.dstimer.mapper;

import com.example.dstimer.entity.Messages;
import org.apache.ibatis.annotations.*;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@ResponseBody
@Mapper
public interface MessagesMapper {
    @Select("SELECT * from messages")
    List<Messages> findAll();

    @Insert("INSERT into messages(group_name, unread_messages_number,event_name,content,remark,nickname,avatar,starting_time,deadline) " +
            "VALUES (#{group_name}, #{unread_messages_number}, #{event_name}, #{content}, #{remark},  #{nickname}, #{avatar}, #{starting_time},#{deadline})")


    int insert(Messages messages);

    int update(Messages messages);

    @Delete("delete from messages where id = #{id}")
    Integer deleteById(@Param("id") Integer id);

    @Select("select * from messages limit #{pageNum}, #{pageSize}")
    List<Messages> selectPage(Integer pageNum, Integer pageSize);

    @Select("select a.* from messages as a \n" +
            "where id= (select max(id) from messages where a.group_name=group_name)limit #{pageNum}, #{pageSize}")
    List<Messages> selectPages(Integer pageNum, Integer pageSize);

}
