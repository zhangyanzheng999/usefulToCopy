/**
 * @file:  UserDao.java
 * @author: Administrator    
 * @date:   2020-6-19 11:47
 * @copyright: 2020-2023 www.bosssoft.com.cn Inc. All rights reserved. 
 */  
package com.bosssoft.hr.train.springboot.basic.example.dao.impl;

import com.bosssoft.hr.train.springboot.basic.example.pojo.entity.Organization;
import com.bosssoft.hr.train.springboot.basic.example.pojo.entity.User;
import com.bosssoft.hr.train.springboot.basic.example.pojo.query.BaseQuery;

import java.util.List;

/**
 * @class UserDao
 * @classdesc 定义非通用的Mapper的方法，通用方法从<tt>AbstractBaseDao</tt>AbstractBaseDao继承
 * @author Administrator
 * @date 2020-6-19  10:38
 * @version 1.0.0
 * @see 
 * @since 
 */
public interface OrganizationDao<T extends Organization,Q extends BaseQuery>{
}
