package com.example.dstimer.controller;

import com.example.dstimer.common.Result;
import com.example.dstimer.entity.Messages;
import com.example.dstimer.mapper.MessagesMapper;
import com.example.dstimer.service.MessagesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/M")
public class MessagesController {
    @Autowired
    private MessagesMapper messagesMapper;

    @Autowired
    private MessagesService messagesService;

    // 新增和修改
    @PostMapping
    public Result resultP(@RequestBody Messages messages) {
        Integer data = save(messages);
        return Result.success(data);
    }
    public Integer save(@RequestBody Messages messages) {
        // 新增或者更新
        return messagesService.save(messages);
    }


    @DeleteMapping("/{id}")
    public Result resultD(@PathVariable Integer id) {
        Integer data = delete(id);
        return Result.success(data);
    }
    public Integer delete(@PathVariable Integer id) {
        return messagesMapper.deleteById(id);
    }

    @GetMapping("/page")
    public Result resultG0(@RequestParam Integer pageNum,
                           @RequestParam Integer pageSize) {
        List<Messages> data = findPage(pageNum,pageSize);
        return Result.success(data);
    }
    public List<Messages> findPage(@RequestParam Integer pageNum,
                                   @RequestParam Integer pageSize) {
        pageNum = (pageNum - 1) * pageSize;
        List<Messages> data = messagesMapper.selectPage(pageNum, pageSize);
        return data;
    }


    @GetMapping("/page/s")
    public Result resultG1(@RequestParam Integer pageNum,
                          @RequestParam Integer pageSize) {
        List<Messages> data = findPages(pageNum,pageSize);
        return Result.success(data);
    }
    public List<Messages> findPages(@RequestParam Integer pageNum,
                                   @RequestParam Integer pageSize) {
        pageNum = (pageNum - 1) * pageSize;
        List<Messages> data = messagesMapper.selectPages(pageNum, pageSize);
        return data;
    }

}
