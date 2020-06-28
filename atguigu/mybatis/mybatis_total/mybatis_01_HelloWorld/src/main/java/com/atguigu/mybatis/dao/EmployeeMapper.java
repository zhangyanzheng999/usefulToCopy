package com.atguigu.mybatis.dao;
import org.apache.ibatis.annotations.Param;

import com.atguigu.mybatis.bean.Employee;


/**
 * @description:
 * @author:zyz
 * @time:2020/5/20--16:05
 */
public interface EmployeeMapper {
     Employee getEmpById(Integer id);




}
