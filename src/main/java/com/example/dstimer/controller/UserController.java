package com.example.dstimer.controller;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.dstimer.entity.t_user;
import com.example.dstimer.mapper.UserMapper;
import com.example.dstimer.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    public t_user login(@RequestBody t_user user, Model model, HttpSession session) {
        t_user usr = userService.getUserByName(user.getName());
        //用户存在时
        if (usr != null) {
            //用户名密码都正确时
            if (usr.getPassword().equals(user.getPassword())) {
                List<t_user> allUsr = userMapper.findAll();
                session.setAttribute("userInfo", usr.getName());
                return usr;
            } else {
                //密码不正确时
                model.addAttribute("msg", "用户名或者密码错误");
                return null;
            }
        } else {
            model.addAttribute("msg", "用户名不存在");
            return null;
        }
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
