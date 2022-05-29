package com.fonix.colab.controller;


import com.fonix.colab.entity.User;
import com.fonix.colab.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author Fonix
 * @since 2022-05-15
 */
@Controller
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    UserService userService;
    //注册用户页面返回
    @GetMapping("/register")
    public String ToUserRegister() {
        return "/user/register";
    }

    //添加新用户
    @PostMapping(value = "/addUser")
    @ResponseBody
    public String addUser(User user) {
        userService.create(user);
        return user.toString();
    }
}
