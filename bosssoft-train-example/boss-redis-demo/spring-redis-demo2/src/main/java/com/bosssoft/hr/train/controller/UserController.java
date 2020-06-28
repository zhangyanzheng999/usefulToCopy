package com.bosssoft.hr.train.controller;

import com.bosssoft.hr.train.entity.User;
import com.bosssoft.hr.train.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description:
 * @author:zyz
 * @time:2020/6/13-21:24
 */
@RestController
public class UserController {
    @Autowired
    UserService userService;

    @GetMapping("/get")
    public User getUserById(Integer id) {
        return userService.getUserById(id);
    }
}
