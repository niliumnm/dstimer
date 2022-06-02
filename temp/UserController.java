package com.example.dstimer.controller;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.dstimer.entity.dto.UserDTO;
import com.example.dstimer.entity.t_user;
import com.example.dstimer.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpSession;
import java.util.List;

@RestController //表示是可以返回JSON的Controller
@RequestMapping("/user")  //地址映射

class UserController {
    //Mapper相当于Dao层 实际的操作
    @Autowired //自动装配
    private UserMapper userMapper;

    //service是逻辑层 需要判断的时候用
    @Autowired //自动装配
    private UserService userService;

    @GetMapping
    public List<t_user> index() {
        return userService.list();
    }

    @PostMapping("/save")
    public boolean save(@RequestBody t_user user) {
        return userService.saveUser(user);
    }

    //登录
    @PostMapping("/login")
    public t_user login(@RequestBody UserDTO userDTO) {
        t_user usr = userService.getUserByName(userDTO.getName());
        return userService.login(userDTO);
    }

    @RequestMapping("/logout")
    public String logout(HttpSession session) {
        //注销用户
        session.invalidate();
        return "index";
    }

    @DeleteMapping("/delete/{id}")
    public boolean deleteUserById(@PathVariable(name = "id") int id){
        return userService.removeById(id);
        //return userService.deleteUserByID(id);
    }

    //分页
//    @GetMapping("/page")
//    public Map<String, Object> findPage(@RequestParam Integer pageNum,
//                                        @RequestParam Integer pageSize,
//                                        @RequestParam String name) {
//        String Name="%"+name+"%";
//        pageNum = (pageNum - 1) * pageSize;
//        List<t_user> data = userMapper.selectPage(pageNum, pageSize,Name);
//        Integer total= userMapper.selectTotal(pageNum,pageSize,Name);
//        Map<String, Object> res = new HashMap<>();
//        res.put("data", data);
//        res.put("total", total);
//        return res;
//    }
    //mybatisPlus分页
    @GetMapping("/page")
    public IPage<t_user>  findPage(@RequestParam  Integer pageNum,
                                        @RequestParam  Integer pageSize,
                                        @RequestParam(defaultValue = "") String name) {
        IPage<t_user> page = new Page<>(pageNum, pageSize);
        QueryWrapper<t_user> queryWrapper = new QueryWrapper<>();
        if (!"".equals(name)) {
            queryWrapper.like("name", name);
        }
        return userService.page(page,queryWrapper);
    }
}
