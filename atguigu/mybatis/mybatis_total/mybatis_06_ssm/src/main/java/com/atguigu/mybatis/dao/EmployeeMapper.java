package com.atguigu.mybatis.dao;

import com.atguigu.mybatis.bean.Employee;
import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @description:
 * @author:zyz
 * @time:2020/5/20--16:05
 */
public interface EmployeeMapper {
     Employee getEmpById(Integer id);
     List<Employee> getEmps();
}
