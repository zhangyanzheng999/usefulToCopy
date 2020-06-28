package com.bosssoft.hr.train.springmvc.controller;

import com.bosssoft.hr.train.springmvc.bean.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;


/**
 * @description:
 * @author:zyz
 * @time:2020/6/6--10:42
 */
@Controller
public class UserController {


    @GetMapping("/login")
    public String login(User user, Model model, HttpServletRequest request) {
        //没有登录
        if (user == null || user.getUserName() == null) {
            model.addAttribute("err", "请登录");
            return "login";
        }
        if (user.getUserName().trim().length() > 0 && user.getUserName().equals(user.getPassword())) {
            //为了拦截登陆生效
            model.addAttribute("user", user);
            request.getSession().setAttribute("user", user.toString());
            return "hello";
        } else {
            //登陆失败 返回登录
            model.addAttribute("err", "用户名或密码错误");
            return "login";
        }

    }

    @GetMapping("/get")
    @ResponseBody
    public String get() {
        return "You're logged in ";
    }
}
