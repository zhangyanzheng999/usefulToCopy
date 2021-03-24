package com.atguigu.cache.service;

import com.atguigu.cache.bean.Employee;
import com.atguigu.cache.mapper.EmployeeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.*;
import org.springframework.stereotype.Service;

/**
 * @description:
 * @author:zyz
 * @time:2021/3/22-15:53
 */
@CacheConfig(cacheNames = "emp") //抽取缓存的公共配置
@Service
public class EmployeeService {
    @Autowired
    EmployeeMapper employeeMapper;

    /**
     * 几个属性：
     * cacheNames/value 指定缓存的名字 数组的方式，可以指定多个缓存
     * key 缓存数据时使用的key。默认是方法参数的值 值默认为返回值
     * #id #a0 #p0 #root.args[0]
     * keyGenerator key的生成器 与key二选一
     * cacheManager 缓存管理器 或者指定cacheResolver 缓存解析器 也是二选一
     * condition 指定符合条件的情况下才缓存
     * unless:否定缓存，当unless为False时才会缓存；可以获取到结果来判断
     * sync:是否异步
     *
     * @param id
     * @return
     */
    @Cacheable(cacheNames = "emp"/*, keyGenerator = "myKeyGenerator", condition = "#id==1", unless = "#result==null"*/, key = "#id")
    public Employee getEmp(Integer id) {
        System.out.println("查询" + id + "号员工");
        Employee emp = employeeMapper.getEmpById(id);
        return emp;

    }

    @CachePut(value = "emp", key = "#result.id")
    public Employee updateEmp(Employee employee) {
        System.out.println("update 员工:" + employee);
        employeeMapper.updateEmp(employee);
        return employee;
    }

    /**
     * allEntries = true指定当前缓存中清除所有数据
     * beforeInvocation 缓存清除是否在方法之前执行，默认为False
     * 如果方法出错，方法执行前True会删除缓存，但是之后False不删除缓存
     *
     * @param id
     */
    @CacheEvict(value = "emp", key = "#id")
    public void deleteEmp(Integer id) {
        System.out.println("delete emp:" + id);
        //employeeMapper.deleteEmp(id);
    }

    @Caching(
            cacheable = {
                    @Cacheable(value = "emp", key = "#lastName")
            },
            put = {
                    @CachePut(value = "emp", key = "#result.id"),
                    @CachePut(value = "emp", key = "#result.email")
            }
    )
    public Employee getEmpByLastName(String lastName) {
        Employee employee = employeeMapper.getEmpByLastName(lastName);

        return employee;
    }
}
