package com.atguigu.mybatis.dao;

import com.atguigu.mybatis.bean.Department;



public interface DepartmentMapper {
    Department getDeptById(Integer id);
    Department getDeptWithEmpsById(Integer id);
    Department getDeptByIdStep(Integer id);

}
