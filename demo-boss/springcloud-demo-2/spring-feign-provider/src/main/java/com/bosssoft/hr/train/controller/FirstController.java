package com.bosssoft.hr.train.controller;

import com.bosssoft.hr.train.bean.Person;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * @description:
 * @author:zyz
 * @time:2020/6/16-15:52
 */
@RestController
public class FirstController {

    @GetMapping("/person/{personId}")
    public Person findPerson(@PathVariable("personId") Integer personId,
                             HttpServletRequest request) {
        Person person = new Person(personId, "zhangsan", 30, request.getRequestURL().toString());


        return person;
    }

    @GetMapping("/hello")
    public String hello() {
        return "Hello World !";
    }
}
