package com.example.dstimer.mapper;


import com.example.dstimer.entity.Upcoming;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface UpcomingMapper {



    @Insert("INSERT into upcoming(event_name,content,remark,nickname,avatar,starting_time,deadline) " +
            "VALUES (#{event_name}, #{content}, #{remark},  #{nickname}, #{avatar}, #{starting_time},#{deadline})")
    int insert(Upcoming upcoming);

    int update(Upcoming upcoming);

    @Delete("delete from upcoming where id = #{id}")
    Integer deleteById(@Param("id") Integer id);

    @Select("select * from upcoming limit #{pageNum}, #{pageSize}")
    List<Upcoming> selectPage(Integer pageNum, Integer pageSize);
}
