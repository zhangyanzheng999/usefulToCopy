package com.boss.bes.system.manage.dao.impl;


import com.boss.bes.system.manage.dao.ResourceDao;
import com.boss.bes.system.manage.mapper.ResourceMapper;
import com.boss.bes.system.manage.pojo.entity.Resource;

/**
 * @description:资源dao的抽象类
 * @author:zyz
 * @time:2020/7/10-14:37
 */
public abstract class AbstractResourceDao extends AbstractBaseDao<Resource, ResourceMapper> implements ResourceDao {

}
