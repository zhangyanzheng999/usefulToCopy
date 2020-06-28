package com.atguigu.mybatis.dao;

import com.atguigu.mybatis.bean.Employee;
import org.apache.ibatis.annotations.Select;

/**
 * @description:
 * @author:zyz
 * @time:2020/5/21--15:21
 */
public interface EmployeeMapperAnnotation {
    @Select("select * from tbl_employee where id=#{id}")
    Employee getEmpById(Integer id);
}
