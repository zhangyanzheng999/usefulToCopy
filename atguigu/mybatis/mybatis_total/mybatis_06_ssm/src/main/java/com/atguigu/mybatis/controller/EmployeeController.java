package com.atguigu.mybatis.controller;

import com.atguigu.mybatis.bean.Employee;
import com.atguigu.mybatis.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


import java.util.List;
import java.util.Map;

/**
 * @description:
 * @author:zyz
 * @time:2020/5/24--14:00
 */
@Controller
public class EmployeeController {
    @Autowired
    EmployeeService employeeService;


    @RequestMapping("/emps")
    public String emps(Map<String, Object> map) {
        List<Employee> emps = employeeService.emps();
        map.put("allEmps", emps);
        return "list";
    }
}
