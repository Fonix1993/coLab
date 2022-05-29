package com.fonix.colab.controller;


import com.fonix.colab.entity.InfoUserandlab;
import com.fonix.colab.entity.Result;
import com.fonix.colab.entity.User;
import com.fonix.colab.service.InfoUserandlabService;
import com.fonix.colab.service.UserService;
import com.fonix.colab.utils.JwtUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
public class LoginController {
    @Autowired
    InfoUserandlabService infoUserandlabService;
    @Autowired
    UserService userService;

    @GetMapping("/toLogin")
    public String login(Model model) {
        return "login";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login_action(
            @RequestParam(value = "username", required = true) String userName,
            @RequestParam(value = "password", required = true) String password,
            Model model, HttpServletResponse response) {

        User user = userService.queryUserByName(userName);
        if (user == null) {
            model.addAttribute("msg", "用户名错误");
            return "login";
        }
        if (!user.getPassword().equals(password)) {
            model.addAttribute("msg", "密码错误");
            return "login";
        }
        JwtUtils jwtUtils = new JwtUtils();
        String jwt = jwtUtils.generateToken(user.getId());
        response.setHeader("Authorization", jwt);
        response.setHeader("Access-Control-Expose-Headers", "Authorization");
        List<InfoUserandlab> labsList = infoUserandlabService.selectLabsByUserName(user.getUsername());
        model.addAttribute("userName", user.getUsername());
        model.addAttribute("userId", user.getId());
        model.addAttribute("labsList",labsList);
        return "index";
    }

    @RequiresAuthentication
    @GetMapping("logout")
    public Result logout() {
        SecurityUtils.getSubject().logout();
        return Result.succ(null);
    }
}
