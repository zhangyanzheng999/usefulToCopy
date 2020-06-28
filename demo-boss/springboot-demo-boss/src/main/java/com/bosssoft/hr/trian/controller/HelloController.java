package com.bosssoft.hr.trian.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description:
 * @author:zyz
 * @time:2020/6/8--15:36
 */
@RestController
public class HelloController {

    @GetMapping("/hello")
    public String hello() {
        return "HelloWorld";
    }
}
