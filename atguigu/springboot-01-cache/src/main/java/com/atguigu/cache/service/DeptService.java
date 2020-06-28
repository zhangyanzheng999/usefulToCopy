package com.atguigu.cache.service;

import com.atguigu.cache.bean.Department;
import com.atguigu.cache.mapper.DepartmentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.Cache;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.stereotype.Service;

/**
 * @description:
 * @author:zyz
 * @time:2020/6/13-16:11
 */
@Service
public class DeptService {
    @Autowired
    DepartmentMapper departmentMapper;

    @Autowired
    RedisCacheManager redisCacheManager;

    /*  @Cacheable(cacheNames = "dept")
      public Department getDeptById(Integer id){
          System.out.println("DeptService.getDeptById:"+id);
          return departmentMapper.getDeptById(id);

      }*/
    // 编码方式
    public Department getDeptById(Integer id) {
        System.out.println("DeptService.getDeptById:" + id);

        Department dept = departmentMapper.getDeptById(id);
        //获取缓存
        Cache cache = redisCacheManager.getCache("dept");
        cache.put("Dept:1", dept);
        return dept;

    }

}
