package com.bosssoft.hr.train.springmvc.controller;

import com.bosssoft.hr.train.springmvc.bean.User;
import com.bosssoft.hr.train.springmvc.common.MyLogApi;
import com.bosssoft.hr.train.springmvc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;


/**
 * @description:
 * @author:zyz
 * @time:2020/6/5--20:04
 */
@Controller
public class UserController {

    @Autowired
    private UserService userService;


    @MyLogApi()
    @GetMapping("/getUser")
    @ResponseBody
    public String getUser() {
        User user = userService.getUser();
        return user.toString();
    }
}
