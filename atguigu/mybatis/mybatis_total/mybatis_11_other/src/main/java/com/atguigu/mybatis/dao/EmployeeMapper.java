package com.atguigu.mybatis.dao;

import com.atguigu.mybatis.bean.Employee;
import com.atguigu.mybatis.bean.Page;

import java.util.List;

/**
 * @description:
 * @author:zyz
 * @time:2020/5/20--16:05
 */
public interface EmployeeMapper {
     Employee getEmpById(Integer id);
     List<Employee> getEmps();
     Long addEmp(Employee employee);
     void getPageByProcedure(Page page);
}
