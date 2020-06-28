package com.atguigu.mybatis.dao;

import com.atguigu.mybatis.bean.Employee;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface EmployeeMapperDynamicSQL {
    List<Employee> getEmpsByConditionIF(Employee employee);
    List<Employee> getEmpsByConditionTrim(Employee employee);
    List<Employee> getEmpsByConditionChoose(Employee employee);
    void updateEmp(Employee employee);
    //查询员工id'在给定集合中的
    List<Employee> getEmpsByConditionForeach(@Param("ids") List<Integer> ids);

    void addEmps(@Param("emps") List<Employee> emps);

    List<Employee> getEmpsTestInnerParameter(Employee employee);
}
