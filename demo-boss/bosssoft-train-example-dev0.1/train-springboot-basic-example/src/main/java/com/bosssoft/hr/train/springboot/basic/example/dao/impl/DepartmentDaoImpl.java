/**
 * @file:  UserDaoImpl.java
 * @author: Administrator    
 * @date:   2020-6-19 11:19
 * @copyright: 2020-2023 www.bosssoft.com.cn Inc. All rights reserved. 
 */  
package com.bosssoft.hr.train.springboot.basic.example.dao.impl;
/**
 * @file:  UserDaoImpl.java    
 * @author: Administrator    
 * @date:   2020-6-19 10:24
 * @copyright: 2020-2023 www.bosssoft.com.cn Inc. All rights reserved. 
 */  
import com.bosssoft.hr.train.springboot.basic.example.dao.mapper.DepartmentMapper;
import com.bosssoft.hr.train.springboot.basic.example.dao.mapper.RoleMapper;
import com.bosssoft.hr.train.springboot.basic.example.pojo.entity.Department;
import com.bosssoft.hr.train.springboot.basic.example.pojo.entity.Role;
import com.bosssoft.hr.train.springboot.basic.example.pojo.query.DepartmentQuery;
import com.bosssoft.hr.train.springboot.basic.example.pojo.query.RoleQuery;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @class UserDaoImpl
 * @classdesc
 * @author Administrator
 * @date 2020-6-19  10:24
 * @version 1.0.0
 * @since 
 */
@Repository(value = "departmentDaoImpl")
public class DepartmentDaoImpl extends AbstractDepartmentDao<Department, DepartmentMapper, DepartmentQuery> {

    @Override
    public List<Department> queryByCondition(DepartmentQuery query) {
        return super.queryByCondition(query);
    }
}
