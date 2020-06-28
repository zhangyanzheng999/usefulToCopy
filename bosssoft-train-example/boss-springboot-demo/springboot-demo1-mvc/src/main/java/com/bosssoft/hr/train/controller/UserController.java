package com.bosssoft.hr.train.controller;

import com.bosssoft.hr.train.bean.User;
import com.bosssoft.hr.train.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

/**
 * @description:
 * @author:zyz
 * @time:2020/6/8--21:13
 */
@RestController
@RequestMapping("/user")
@Validated
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/get")
    public Object getUsers(@NotNull(message = "名字不能为空") @RequestParam(value = "name", required = false) String name) {

        User user = new User();
        user.setName(name);
        return userService.queryUsers(user);
    }

    @GetMapping("/update")
    public String updateUser(@NotNull @RequestParam(value = "id", required = false) Integer id,
                             @RequestParam(value = "name", required = false) String name,
                             @Valid @RequestParam(value = "age", required = false) Integer age) {
        User user = new User(id, name, age);
        return userService.updateUser(user) > 0 ? "successUpdate" : "failedUpdate";
    }

    @GetMapping("/delete")
    public String deleteUser(@NotNull @RequestParam(value = "id") Integer id) {
        return userService.deleteUserById(id) > 0 ? "successDelete" : "failedDelete";
    }


    @GetMapping("/insert")
    public String insertUser(@RequestParam(value = "id", required = false) Integer id,
                             @NotNull @RequestParam(value = "name", required = false) String name,
                             @Valid @RequestParam(value = "age", required = false) Integer age) {
        User user = new User(id, name, age);
        return userService.insetUser(user) > 0 ? "successInsert" : "failedInsert";
    }

}
