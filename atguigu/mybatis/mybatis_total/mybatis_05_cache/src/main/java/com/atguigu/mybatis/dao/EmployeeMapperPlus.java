package com.atguigu.mybatis.dao;

import com.atguigu.mybatis.bean.Employee;

import java.util.List;

public interface EmployeeMapperPlus {
    Employee getEmpById(Integer id);
    Employee getEmpAndDeptById(Integer id);
    Employee getEmpByIdStep(Integer id);
    List<Employee> getEmpsByDeptId(Integer deptId);
}
