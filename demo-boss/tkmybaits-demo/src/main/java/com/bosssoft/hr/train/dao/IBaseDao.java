package com.bosssoft.hr.train.dao;
/**
 * @class IBaseDao
 * @classdesc 包含最基本的增删改查方法的定义，其他扩展的方法由具体的Dao实现
 * @author Administrator
 * @date 2020-6-19  10:35
 * @version 1.0.0
 * @see
 * @since
 */
public interface IBaseDao<T> {

    /**
     * @param:
     * @return:
     * @see
     * @since
     */
    int save(T entity);
    /**
     * @param:
     * @return:
     * @see
     * @since
     */
    int delete(T entity);
    /**
     * @param:
     * @return:
     * @see
     * @since
     */
    int update(T entity);
}
