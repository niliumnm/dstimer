package com.example.dstimer.service;

import com.example.dstimer.entity.Upcoming;
import com.example.dstimer.mapper.UpcomingMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UpcomingService {

    @Autowired
    private UpcomingMapper upcomingMapper;

    public int save(Upcoming upcoming) {
        if (upcoming.getId() == null) {  // upcoming没有id，则表示是新增
            return upcomingMapper.insert(upcoming);
        } else { // 否则为更新
            return upcomingMapper.update(upcoming);
        }
    }

}
