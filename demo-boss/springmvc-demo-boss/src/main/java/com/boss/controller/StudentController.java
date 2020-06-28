package com.boss.controller;

import com.boss.bean.Student;
import com.boss.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * @description:
 * @author:zyz
 * @time:2020/6/5--17:06
 */
@Controller
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @RequestMapping("/list")
    public ModelAndView list(ModelAndView mv) {
        List<Student> students = studentService.findAll();
        mv.addObject("students", students);
        mv.setViewName("student/list");

        return mv;
    }

    @RequestMapping("/preSave")
    public ModelAndView preSave(@RequestParam(value = "id", required = false) Integer id, ModelAndView mv) {
        if (id == null) {
            mv.setViewName("student/add");
        } else {
            Student student = studentService.findById(id);
            mv.addObject("student", student);
            mv.setViewName("student/update");
        }
        return mv;
    }

    @RequestMapping("/save")
    public String save(Student student) {
        Student student1 = studentService.findById(student.getId());
        if (student1 == null) {
            studentService.add(student);
        } else {
            studentService.update(student);
        }

        return "redirect:/student/list";
    }

    @RequestMapping("/delete")
    public String delete(@RequestParam("id") Integer id) {
        studentService.delete(id);
        return "redirect:/student/list";
    }
}
