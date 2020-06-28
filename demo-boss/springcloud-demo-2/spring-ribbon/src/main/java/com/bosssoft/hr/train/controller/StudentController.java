package com.bosssoft.hr.train.controller;

import com.bosssoft.hr.train.bean.Student;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * @description:
 * @author:zyz
 * @time:2020/6/16-11:13
 */
@RestController
public class StudentController {

    @GetMapping(value = "/stu",produces = MediaType.APPLICATION_JSON_VALUE)
    public Student getStudent(HttpServletRequest request) {
        Student s = new Student();
        s.setId(1);
        s.setName("ruhua");
        s.setMessage(request.getRequestURL().toString());
        return s;
    }
}
