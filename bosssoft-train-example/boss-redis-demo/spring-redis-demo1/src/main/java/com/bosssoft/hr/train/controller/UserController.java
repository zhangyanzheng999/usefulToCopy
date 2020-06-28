package com.bosssoft.hr.train.controller;

import com.bosssoft.hr.train.entity.User;
import com.bosssoft.hr.train.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;


/**
 * @description:
 * @author:zyz
 * @time:2020/6/13-17:57
 */
@RestController
public class UserController {
    @Autowired
    UserService userService;

    @GetMapping("/get/{id}")
    public User getUserById(@PathVariable("id") Integer id) {
        User user = userService.getUserById(id);
        if (user != null) {
            return user;
        }
        return new User();
    }

    @GetMapping("/allUser")
    public Object queryUsers() {
        return userService.findAll();
    }

}
