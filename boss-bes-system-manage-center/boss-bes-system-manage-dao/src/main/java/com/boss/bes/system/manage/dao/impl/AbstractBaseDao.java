
package com.boss.bes.system.manage.dao.impl;


import boss.bes.log.exception.code.enums.BaseCodeEnum;
import boss.bes.log.exception.code.enums.SystemManageCodeEnum;
import boss.bes.log.exception.type.DaoException;
import cn.hutool.core.lang.Snowflake;
import cn.hutool.core.util.IdUtil;
import com.boss.bes.system.manage.constant.SystemManagerConstraint;
import com.boss.bes.system.manage.dao.IBaseDao;
import com.boss.bes.system.manage.mapper.CommonMapper;
import com.boss.bes.system.manage.pojo.entity.common.BaseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import tk.mybatis.mapper.entity.Example;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @description:该类适配底层tk.mybatis的mapper的基本的增删除该查方法
 * @author:zyz
 * @time:2020/7/6-20:29
 */
public abstract class AbstractBaseDao<T, M extends CommonMapper<T>> implements IBaseDao<T> {

    /**
     * 注入框架隔离的Mappper,后面的数据操作依赖此mapper
     */
    @Autowired
    protected M myMapper;

    /**
     * 进行保存，只要继承了BaseEntity都可以直接使用这个方法，而不用去重写
     *
     * @param entity
     * @return
     */
    @Override
    public int save(T entity) {
        try {
            //如果是继承了BaseEntity 生成id和Version以及创建的时间戳
            if (entity instanceof BaseEntity) {
                Snowflake snowflake = IdUtil.getSnowflake(SystemManagerConstraint.WORKER_ID, SystemManagerConstraint.DATA_CENTER_ID);
                ((BaseEntity) entity).setId(snowflake.nextId());
                ((BaseEntity) entity).setVersion(1L);
                ((BaseEntity) entity).setCreatedTime(new Date());
            }
            return myMapper.insertSelective(entity);
        } catch (Exception e) {
            throw new DaoException(BaseCodeEnum.BASE_DATA_INSERT_EXCEPTION, e);
        }
    }

    /**
     * 通过id进行删除，但是少用
     *
     * @param id
     * @return
     */
    @Override
    public int delete(Long id) {
        try {
            return myMapper.deleteByPrimaryKey(id);
        } catch (Exception e) {
            throw new DaoException(BaseCodeEnum.BASE_DATA_DELETE_EXCEPTION, e);
        }
    }

    /**
     * 通过条件删除，任何删除都可以直接调用这个方法
     *
     * @param example
     * @return
     */
    @Override
    public int delete(Example example) {
        try {
            return myMapper.deleteByExample(example);
        } catch (Exception e) {
            //这里判断是为了如果数据已经使用，抛出数据已经使用异常
            if (e.toString().indexOf("MySQLIntegrityConstraintViolationException") != -1) {
                throw new DaoException(SystemManageCodeEnum.SYSTEM_MANAGE_DATA_USED);
            }
            throw new DaoException(BaseCodeEnum.BASE_DATA_DELETE_EXCEPTION, e);
        }
    }

    /**
     * 通过主键进行更新
     *
     * @param entity
     * @return
     */
    @Override
    public int update(T entity) {
        try {
            return myMapper.updateByPrimaryKey(entity);
        } catch (Exception e) {
            throw new DaoException(BaseCodeEnum.BASE_DATA_UPDATE_EXCEPTION, e);
        }
    }

    /**
     * 这个是为了通过基类的子类，去自动更新而不需要自己重写
     *
     * @param entity
     * @param example
     * @return
     */
    @Override
    public int update(T entity, Example example) {
        try {
            if (entity instanceof BaseEntity) {
                //自动更新版本和时间戳
                ((BaseEntity) entity).setVersion(((BaseEntity) entity).getVersion() + 1);
                ((BaseEntity) entity).setUpdatedTime(new Date());
            }
            return myMapper.updateByExample(entity, example);
        } catch (Exception e) {
            throw new DaoException(BaseCodeEnum.BASE_DATA_UPDATE_EXCEPTION, e);
        }
    }

    /**
     * 根据id查询
     *
     * @param id
     * @return
     */
    @Override
    public T getOneById(Long id) {
        try {
            return myMapper.selectByPrimaryKey(id);
        } catch (Exception e) {
            throw new DaoException(BaseCodeEnum.BASE_DATA_SELECT_EXCEPTION, e);
        }
    }

    /**
     * 根据条件查询一个
     *
     * @param example
     * @return
     */
    @Override
    public T getOneByExample(Example example) {
        try {
            return myMapper.selectOneByExample(example);
        } catch (Exception e) {
            throw new DaoException(BaseCodeEnum.BASE_DATA_SELECT_EXCEPTION, e);
        }
    }

    /**
     * 根据条件查询集合
     *
     * @param example
     * @return
     */
    @Override
    public List<T> getListByExample(Example example) {
        try {
            return myMapper.selectByExample(example);
        } catch (Exception e) {
            throw new DaoException(BaseCodeEnum.BASE_DATA_SELECT_EXCEPTION, e);
        }
    }

    /**
     * 这个是为了进行分页查询，子类可以选择进行重写
     *
     * @param example
     * @return
     */
    @Override
    public List<T> queryWithPage(Example example) {
        try {
            return myMapper.selectByExample(example);
        } catch (Exception e) {
            throw new DaoException(BaseCodeEnum.BASE_DATA_SELECT_EXCEPTION, e);
        }
    }

    /**
     * 需要底层方法自己去实现
     *
     * @param name 名字
     * @return
     */
    @Override
    public List<T> queryWithPage(String name) {
        return new ArrayList<>();
    }

    /**
     * 查询全部
     *
     * @return
     */
    @Override
    public List<T> queryAll() {
        return myMapper.selectAll();
    }

    /**
     * 保存并返回Id
     * 这个是为了当新建记录并且有中间表操作时，需要返回雪花算法的id
     *
     * @param entity
     * @return
     */
    @Override
    public Long saveReturnId(T entity) {
        // 只有继承了BaseEntity才可以使用这个方法，否则抛出异常
        if (entity instanceof BaseEntity) {
            try {
                //生成雪花算法Id
                Snowflake snowflake = IdUtil.getSnowflake(SystemManagerConstraint.WORKER_ID, SystemManagerConstraint.DATA_CENTER_ID);
                long id = snowflake.nextId();
                //下面这些是为了生成id，版本，以及创建时间
                ((BaseEntity) entity).setId(id);
                ((BaseEntity) entity).setVersion(1L);
                ((BaseEntity) entity).setCreatedTime(new Date());
                //如果保存失败直接抛出异常
                if (myMapper.insertSelective(entity) != 0) {
                    return id;
                } else {
                    throw new DaoException(BaseCodeEnum.BASE_DATA_INSERT_EXCEPTION);
                }
            } catch (Exception e) {
                throw new DaoException(BaseCodeEnum.BASE_DATA_INSERT_EXCEPTION, e);
            }
        } else {
            throw new DaoException(BaseCodeEnum.NOT_BASE_CLASS_EXCEPTION);
        }
    }
}
