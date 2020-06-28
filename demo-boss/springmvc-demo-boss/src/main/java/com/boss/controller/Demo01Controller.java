package com.boss.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @description:
 * @author:zyz
 * @time:2020/6/5--15:25
 */
@Controller
@RequestMapping("/demo01")
public class Demo01Controller {

    @RequestMapping("/hello")
    public String hello(Model model){
        model.addAttribute("message","this is demo01 here");

        return "helloWorld";
    }
    @RequestMapping("/hello2")
    @ResponseBody
    public String hello2(Model model){
        model.addAttribute("message","this is demo01 here");

        return "helloWorld";
    }
}
