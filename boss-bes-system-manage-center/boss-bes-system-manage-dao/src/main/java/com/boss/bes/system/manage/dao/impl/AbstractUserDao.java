package com.boss.bes.system.manage.dao.impl;

import com.boss.bes.system.manage.dao.UserDao;
import com.boss.bes.system.manage.mapper.UserMapper;
import com.boss.bes.system.manage.pojo.entity.User;

/**
 * @description:
 * @author:zyz
 * @time:2020/7/12-16:00
 */
public abstract class AbstractUserDao extends AbstractBaseDao<User, UserMapper> implements UserDao {
}
