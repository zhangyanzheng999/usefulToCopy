package com.boss.bes.system.manage.dao;

import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * @description: 基础的接口Dao实现基础的CRUD以及分页
 * @author:zyz
 * @time:2020/7/6-20:14
 */
public interface IBaseDao<T>{
    /**
     * 单个查询
     * @return
     */
    T getOneById(Long id);

    /**
     * 用example查询
     * @param example
     * @return
     */
    T getOneByExample(Example example);

    /**
     * 返回集合
     * @param example
     * @return
     */
    List<T> getListByExample(Example example);

    /**
     * 查询全部
     * @return
     */
    List<T> queryAll();

    /**
     * 保存
     * @param entity
     * @return
     */
    int save(T entity);

    /**
     * 删除
     * @param id
     * @return
     */
    int delete(Long id);

    /**
     * 通过example删除
     * @param example
     * @return
     */
    int delete(Example example);
    /**
     * 更新
     * @param entity
     * @return
     */
    int update(T entity);

    /**
     * 使用example更新
     * @param entity
     * @param example
     * @return
     */
    int update(T entity, Example example);

    /**
     * 进行条件查询
     * @param example
     * @return
     */
    List<T> queryWithPage(Example example);
    /**
     * 进行条件查询
     * @param name
     * @return
     */
    List<T> queryWithPage(String name);

    /**
     * 保存之后返回用户Id，因为需要去保存到中间表
     * @param entity
     * @return
     */
    Long saveReturnId(T entity);
}
