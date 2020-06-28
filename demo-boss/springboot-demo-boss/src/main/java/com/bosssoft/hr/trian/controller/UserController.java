package com.bosssoft.hr.trian.controller;

import com.bosssoft.hr.trian.db.bean.User;
import com.bosssoft.hr.trian.db.dao.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description:
 * @author:zyz
 * @time:2020/6/8--16:31
 */
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserMapper userMapper;

    @GetMapping("/{id}")
    public User getUser(@PathVariable("id") Integer id) {
        User user = userMapper.selectByPrimaryKey(id);
        return user;
    }
}
