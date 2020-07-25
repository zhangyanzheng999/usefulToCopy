package com.boss.bes.system.manage.dao.impl;

import com.boss.bes.system.manage.dao.PositionDao;
import com.boss.bes.system.manage.mapper.PositionMapper;
import com.boss.bes.system.manage.pojo.entity.Position;

/**
 * @description:职位dao的抽象类
 * @author:zyz
 * @time:2020/7/12-10:21
 */
public abstract class AbstractPositionDao extends AbstractBaseDao<Position, PositionMapper> implements PositionDao {
}
