package com.example.dstimer.service;


import com.example.dstimer.entity.Messages;
import com.example.dstimer.mapper.MessagesMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MessagesService {

    @Autowired
    private MessagesMapper messagesMapper;

    public int save(Messages messages) {
        if (messages.getId() == null) {  // user没有id，则表示是新增
            return messagesMapper.insert(messages);
        } else { // 否则为更新
            return messagesMapper.update(messages);
        }
    }

}
