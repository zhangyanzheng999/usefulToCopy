package com.boss.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @description:
 * @author:zyz
 * @time:2020/6/5--14:42
 */
@Controller
public class HelloWorldController {

    @RequestMapping("/hello")
    public String helloWorld(Model model) {
        model.addAttribute("message", "HelloWorld");

        return "helloWorld";
    }

}
