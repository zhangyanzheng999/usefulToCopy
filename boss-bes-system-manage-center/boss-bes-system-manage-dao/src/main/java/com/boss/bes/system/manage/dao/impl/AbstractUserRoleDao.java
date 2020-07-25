package com.boss.bes.system.manage.dao.impl;

import com.boss.bes.system.manage.dao.UserRoleDao;
import com.boss.bes.system.manage.mapper.UserRoleMapper;
import com.boss.bes.system.manage.pojo.entity.UserRole;

/**
 * @description:用户角色中间表dao层抽象类
 * @author:zyz
 * @time:2020/7/15-16:14
 */
public abstract class AbstractUserRoleDao extends AbstractBaseDao<UserRole, UserRoleMapper> implements UserRoleDao {
}
