package com.example.dstimer.controller;

import com.example.dstimer.common.Result;
import com.example.dstimer.entity.Upcoming;
import com.example.dstimer.mapper.UpcomingMapper;
import com.example.dstimer.service.UpcomingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/u")
public class UpcomingController {

    @Autowired
    private UpcomingMapper upcomingMapper;

    @Autowired
    private UpcomingService upcomingService;

    @PostMapping
    public Result resultP(@RequestBody Upcoming upcoming) {
        Integer data = save(upcoming);
        return Result.success(data);
    }
    public Integer save(@RequestBody Upcoming upcoming) {
        // 新增或者更新
        return upcomingService.save(upcoming);
    }


    @DeleteMapping("/{id}")
    public Result resultD(@PathVariable Integer id) {
        Integer data = delete(id);
        return Result.success(data);
    }
    public Integer delete(@PathVariable Integer id) {
        return upcomingMapper.deleteById(id);
    }

    // 分页查询
    //  接口路径：/user/page?pageNum=1&pageSize=10
    // @RequestParam接受
//    limit第一个参数 = (pageNum - 1) * pageSize
    // pageSize


    @GetMapping("/page")
    public Result resultG(@RequestParam Integer pageNum,
                         @RequestParam Integer pageSize) {
        List<Upcoming> data = findPage(pageNum,pageSize);
        return Result.success(data);
    }
    public List<Upcoming> findPage(@RequestParam Integer pageNum,
                                   @RequestParam Integer pageSize) {
        pageNum = (pageNum - 1) * pageSize;
        List<Upcoming> data = upcomingMapper.selectPage(pageNum, pageSize);

        return data;
    }
}
