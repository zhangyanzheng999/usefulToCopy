package com.bosssoft.hr.train.springboot.basic.example.service;
import com.bosssoft.hr.train.springboot.basic.example.dao.impl.AbstractBaseDao;
import com.bosssoft.hr.train.springboot.basic.example.exception.BusinessErrorCode;
import com.bosssoft.hr.train.springboot.basic.example.exception.BusinessException;
import org.springframework.beans.factory.annotation.Autowired;
import tk.mybatis.mapper.common.Mapper;
import java.util.List;
/**
 * @class BaseCURDService
 * @classdesc  如果之类需要继承父service基本的增删改差方法则可以继承该类，子类需要重写查询 query方法和
 *  dto到entity转化的方法 doObjectTransf
 * @author Administrator
 * @date 2020-6-25  23:42
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
            throw new BusinessException(BusinessErrorCode.BASE_CRUD_SERVICE_ERROR_CODE_CREATE,ex);
        }
    }

    public Integer remove(D dto){
        try {
            T entity=doObjectTransf(dto);
            return  myDao.delete(entity);
        }catch (Exception ex){
            throw new BusinessException(BusinessErrorCode.BASE_CRUD_SERVICE_ERROR_CODE_CREATE,ex);
        }
    }

    public Integer update(D dto){
        try {
            T entity=doObjectTransf(dto);
            return  myDao.update(entity);
        }catch (Exception ex){
            throw new BusinessException(BusinessErrorCode.BASE_CRUD_SERVICE_ERROR_CODE_CREATE,ex);
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
