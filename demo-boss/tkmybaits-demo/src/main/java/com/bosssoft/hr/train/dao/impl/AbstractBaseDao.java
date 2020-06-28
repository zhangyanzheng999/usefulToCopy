package com.bosssoft.hr.train.dao.impl;


import com.bosssoft.hr.train.dao.IBaseDao;
import org.springframework.beans.factory.annotation.Autowired;
import tk.mybatis.mapper.common.Mapper;

/**
 * @description:
 * @author:zyz
 * @time:2020/6/22-12:27
 */
public abstract class AbstractBaseDao<T, M extends Mapper<T>> implements IBaseDao<T> {
    @Autowired
    protected M myMapper;

    @Override
    public int save(T entity) {
        return myMapper.insert(entity);
    }

    @Override
    public int delete(T entity) {
        return myMapper.delete(entity);
    }

    @Override
    public int update(T entity) {
        return myMapper.updateByPrimaryKey(entity);
    }
}
