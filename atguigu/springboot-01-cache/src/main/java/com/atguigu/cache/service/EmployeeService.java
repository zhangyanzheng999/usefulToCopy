package com.atguigu.cache.service;

import com.atguigu.cache.bean.Employee;
import com.atguigu.cache.mapper.EmployeeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.*;
import org.springframework.stereotype.Service;

/**
 * @description:
 * @author:zyz
 * @time:2020/6/13-11:45
 */
@CacheConfig(cacheNames="emp") //抽取缓存的公共配置
//默认使用ConcurrentMapCache;将数据保存在一个ConcurrentMap，开发中经常使用redis\memcached等
@Service
public class EmployeeService {
    @Autowired
    EmployeeMapper employeeMapper;


    @Cacheable
    public Employee getEmp(Integer id) {
        System.out.println("查询" + id + "号员工");
        return employeeMapper.getEmpById(id);
    }

    /**
     * 运行时机：
     * 先调用目标方法
     * 将目标方法结果缓存起来
     *
     * @param employee
     * @return
     */

    @CachePut( key = "#result.id")
    public Employee updateEmp(Employee employee) {
        System.out.println("EmployeeService.updateEmp" + employee);
        employeeMapper.updateEmp(employee);
        return employee;
    }

    @CacheEvict( key = "#id")
    public void deleteEmp(Integer id) {
        System.out.println("EmployeeService.deleteEmp" + id);


    }


    @Caching(
            cacheable = {
                    @Cacheable( key = "#lastName")
            },
            put = {
                    @CachePut( key = "#result.id"),
                    @CachePut( key = "#result.email")
            }
    )
    public Employee getEmpByLastName(String lastName) {
        return employeeMapper.getEmpByLastName(lastName);
    }
}
