package com.bosssoft.hr.train.springmvc.controller;

import com.bosssoft.hr.train.springmvc.bean.Student;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

/**
 * @description:测试@Controller请求
 * @author:zyz
 * @time:2020/6/5--22:52
 */
@Controller
@RequestMapping("/student")
public class StudentController {
    /**
     * 测试 @GetMapping请求
     *
     * @param model
     * @return
     */
    @GetMapping("/get")
    public String getStudent(Model model) {
        Student student = new Student(1, "张三", 20);

        model.addAttribute("student", student);

        return "student";
    }

    /**
     * 测试@PathVariable、@RequestHeader、@CookieValue注解的使用
     *
     * @param name
     * @param header
     * @param cookie
     * @return
     */

    @GetMapping("/params/{name}")
    @ResponseBody
    public String getParams(@PathVariable("name") String name,
                            @RequestHeader("Accept-Language") String header,
                            @CookieValue("JSESSIONID") String cookie) {

        return "name:" + name + ",cookie:" + cookie + ",header:" + header;
    }

}
