package com.boss.controller;

import com.boss.bean.Student;
import org.springframework.web.bind.annotation.*;

/**
 * @description:
 * @author:zyz
 * @time:2020/6/5--15:35
 */
@RestController
@RequestMapping("/params")
public class ParamsController {
    @RequestMapping("/params1")
    public String params1(Integer id, String name, Boolean status) {

        return "id:" + id + ",name:" + name + ",status:" + status;
    }


    @RequestMapping("/params3")
    public String params3(@RequestParam(value = "number", required = true) Integer id) {
        return "id:" + id;
    }

    @RequestMapping("/params4/{name}")
    public String params4(@PathVariable("name") String str,
                          @CookieValue("JSESSIONID") String cookie,
                          @RequestHeader("Accept-Language") String header) {


        return "str:" + str + ",cookie:" + cookie + ",header:" + header;
    }

    @RequestMapping("/params5")
    public String params(Student student) {


        return student.toString();
    }

    @RequestMapping("/params6")
    public Student param6(Student student) {


        return student;
    }
}
