package com.example.dstimer.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.dstimer.common.Constants;
import com.example.dstimer.common.Result;
import com.example.dstimer.entity.dto.UserDTO;
import org.apache.commons.lang.StringUtils;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;
import java.util.List;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;


import com.example.dstimer.service.IUserService;
import com.example.dstimer.entity.User;


import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author sunbo
 * @since 2022-06-02
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Resource
    private IUserService userService;

    @PostMapping("/login")
    public Result login(@RequestBody UserDTO userDTO) {
        String name = userDTO.getName();
        String password = userDTO.getPassword();
        if (StringUtils.isBlank(name) || StringUtils.isBlank(password)) {
            return Result.error(Constants.CODE_400,"参数错误");
        }
        UserDTO dto = userService.login(userDTO);
        return Result.success(dto);
    }

    @PostMapping("/register")
    public Result register(@RequestBody UserDTO userDTO) {
        String name = userDTO.getName();
        String password = userDTO.getPassword();
        if (StringUtils.isBlank(name) || StringUtils.isBlank(password)) {
            return Result.error(Constants.CODE_400,"参数错误");
        }
        return Result.success(userService.register(userDTO));
    }

    @PostMapping("/save")
    public Result save(@RequestBody User user) {
        return Result.success(userService.saveOrUpdate(user));
        //return userService.saveOrUpdate(user); 已被包装类代替
    }

    @DeleteMapping("/{id}")
    public Boolean delete(@PathVariable Integer id) {
        return userService.removeById(id);
    }

    @PostMapping("/del/batch")
    public boolean deleteBatch(@RequestBody List<Integer>ids) {
        return userService.removeByIds(ids);
    }

    @GetMapping
    public Result findAll() {
        return Result.success(userService.list());
    }

    @GetMapping("/username/{name}")
    public Result findOne(@PathVariable String name) {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("name", name);
        return Result.success(userService.getOne(queryWrapper));
    }

    @GetMapping("/{id}")
    public Result findOne(@PathVariable Integer id) {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("id", id);
        return Result.success(userService.getOne(queryWrapper));
    }

    @GetMapping("/page")
    public Result findPage(@RequestParam Integer pageNum,
                               @RequestParam Integer pageSize,
                               @RequestParam(defaultValue = "") String name
    ) {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.orderByDesc("id");
        if (!"".equals(name)) {
            queryWrapper.like("name", name);
        }
        return Result.success(userService.page(new Page<>(pageNum, pageSize), queryWrapper));
    }
}

