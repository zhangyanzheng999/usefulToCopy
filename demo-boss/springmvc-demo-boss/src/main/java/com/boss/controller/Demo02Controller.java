package com.boss.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description:
 * @author:zyz
 * @time:2020/6/5--15:29
 */
@RestController
@RequestMapping("/demo02")
public class Demo02Controller {

    @RequestMapping("/hello")
    public String hello(Model model){
        model.addAttribute("message", "this is demo02 here ");

        return "helloWorld";
    }
}
