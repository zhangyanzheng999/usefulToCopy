package com.boss.bes.system.manage.dao.impl;

import com.boss.bes.system.manage.dao.RoleDao;
import com.boss.bes.system.manage.mapper.RoleMapper;
import com.boss.bes.system.manage.pojo.entity.Role;

/**
 * @description: 角色DAO的抽象类
 * @author:zyz
 * @time:2020/7/11-19:52
 */
public abstract class AbstractRoleDao extends AbstractBaseDao<Role, RoleMapper> implements RoleDao {
}
