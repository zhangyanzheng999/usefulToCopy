package com.boss.controller;

import com.boss.bean.Student;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @description:
 * @author:zyz
 * @time:2020/6/5--16:14
 */
@Controller
@RequestMapping("/mv")
public class MVController {
    @RequestMapping("/student1")
    public String student1(Model model) {
        Student student = new Student();
        student.setId(1);
        student.setName("zhangsan");
        student.setAge(18);
        model.addAttribute("STUDENT", student);

        return "student/student";
    }

    @RequestMapping("/student2")
    public ModelAndView student2(ModelAndView model) {
        Student student = new Student();
        student.setId(2);
        student.setName("lisi");
        student.setAge(20);
        model.addObject("STUDENT", student);
        model.setViewName("student/student");
        return model;
    }

    @RequestMapping("/student3")
    public void student3(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String id = request.getParameter("id");
        String name = request.getParameter("name");
        String age = request.getParameter("age");
        response.getWriter().print("id:" + id + ",name:" + name + ",age:" + age);

    }

    @RequestMapping("/student4")
    public String student4() {

        return "forward:/mv/student3";
    }

    //转发的地址栏不会改变 重定向地址栏会改变
    //转发可以携带参数     重定向默认不可以携带参数
    @RequestMapping("/student5")
    public String student5() {

        return "redirect:student3";
    }

    // 重定向传参，可以通过Model对象
    @RequestMapping("/student6")
    public String student6(HttpServletRequest request, Model model) {
        String id = request.getParameter("id");
        String name = request.getParameter("name");
        String age = request.getParameter("age");
        model.addAttribute("id", id);
        model.addAttribute("name", name);
        model.addAttribute("age", age);

        return "redirect:student3";
    }
}
