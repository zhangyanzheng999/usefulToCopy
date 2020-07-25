package com.boss.bes.system.manage.dao.impl;


import com.boss.bes.system.manage.dao.DepartmentDao;
import com.boss.bes.system.manage.mapper.DepartmentMapper;
import com.boss.bes.system.manage.pojo.entity.Department;

/**
 * @description:部门dao的抽象类
 * @author:zyz
 * @time:2020/7/9-14:44
 */
public abstract class AbstractDepartmentDao extends AbstractBaseDao<Department, DepartmentMapper> implements DepartmentDao {
}
