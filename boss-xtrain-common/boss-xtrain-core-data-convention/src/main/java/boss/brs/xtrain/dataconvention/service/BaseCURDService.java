package boss.brs.xtrain.dataconvention.service;


import boss.brs.xtrain.dataconvention.dao.impl.AbstractBaseDao;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
 * @class BaseCURDService
 * @classdesc  如果之类需要继承父service基本的增删改差方法则可以继承该类，子类需要重写查询 query方法和
 *  dto到entity转化的方法 doObjectTransf
 * @author Administrator
 * @version 1.0.0
 * @see
 * @since
 */
public abstract class BaseCURDService<D,T,Q,M> {
    protected AbstractBaseDao<T,? extends Mapper<T>,Q> myDao;
    public Integer save(D dto){
        try {
            T entity=doObjectTransf(dto);
            return  myDao.save(entity);
        }catch (Exception ex){
            throw ex;
        }
    }

    public Integer remove(D dto){
        try {
            T entity=doObjectTransf(dto);
            return  myDao.delete(entity);
        }catch (Exception ex){
            throw ex;
        }
    }

    public Integer update(D dto){
        try {
            T entity=doObjectTransf(dto);
            return  myDao.update(entity);
        }catch (Exception ex){
            throw ex;
        }
    }

    /**
     *  子类决定如何查询以及返回查询对象
     * @param query
     * @return
     */
    public abstract List<?> query(Q query);

    /**
     * 子类决定如何做增删改过程中 dto到entity对象转化
     * @param dto
     * @return
     */
    protected abstract T doObjectTransf(D dto);
}
