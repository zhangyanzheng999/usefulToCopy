package com.bosssoft.hr.train.springmvc.controller;

import com.bosssoft.hr.train.springmvc.bean.User;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * @description:测试@RestController注解
 * @author:zyz
 * @time:2020/6/5--22:56
 */
@RestController
@RequestMapping("/user")
public class UserController {
    /**
     * 测试@RequestParam、@GetMapping注解
     *
     * @param id
     * @param lastName
     * @param gender
     * @return
     */
    @GetMapping("/get")
    public String getUser(@RequestParam("id") Integer id,
                          @RequestParam("lastName") String lastName,
                          @RequestParam("gender") Integer gender) {
        return "id:" + id + ",lastName:" + lastName + ",gender:" + gender;
    }

    /**
     * 测试@PostMapping注解，以及@RequestBody @Valid的结合使用
     * 使用postMan发送post请求
     * @param user
     * @return
     */
    @PostMapping("/post")
    public User postUser(@RequestBody @Valid User user) {

        return user;
    }


}
