package com.fonix.colab.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * <p>
 *  个人中心表 前端控制器
 * </p>
 *
 * @author Fonix
 * @since 2022-05-23
 */
@Controller
@RequestMapping("/user-center")
public class UserCenterController {

    @GetMapping("/toUserCenter")
    public String toUserCenter(@RequestParam String userName, Model model) {
        model.addAttribute("userName", userName);
        return "/user/userCenter";
    }
}
