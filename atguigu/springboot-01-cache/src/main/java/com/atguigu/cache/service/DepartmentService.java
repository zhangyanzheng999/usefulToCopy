package com.atguigu.cache.service;

import com.atguigu.cache.bean.Department;
import com.atguigu.cache.mapper.DepartmentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

/**
 * @description:
 * @author:zyz
 * @time:2021/3/22-22:46
 */
@Service
public class DepartmentService {
    @Autowired
    DepartmentMapper departmentMapper;

    @Cacheable(cacheNames = "dept")
    public Department getDeptById(Integer id) {
        System.out.println("查询部门:" + id);
        Department dept = departmentMapper.getDeptById(id);
        return dept;
    }
}
