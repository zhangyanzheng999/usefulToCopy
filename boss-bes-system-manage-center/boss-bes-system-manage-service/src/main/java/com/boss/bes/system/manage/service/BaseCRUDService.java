package com.boss.bes.system.manage.service;

import boss.bes.log.exception.code.enums.SystemManageCodeEnum;
import boss.bes.log.exception.type.BusinessException;
import com.boss.bes.system.manage.dao.impl.AbstractBaseDao;
import com.boss.bes.system.manage.mapper.CommonMapper;
import com.boss.bes.system.manage.pojo.dto.common.BaseDTO;
import com.boss.bes.system.manage.pojo.dto.common.BaseDeleteDTO;
import com.boss.bes.system.manage.pojo.query.common.BasePageQuery;
import com.boss.bes.system.manage.pojo.query.common.BaseQuery;
import com.boss.bes.system.manage.util.BeanUtil;
import com.github.pagehelper.PageInfo;
import com.github.pagehelper.page.PageMethod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import java.util.List;


/**
 * @description:进行基本的实现
 * @author:zyz
 * @time:2020/7/6-20:03
 */
public abstract class BaseCRUDService<T, D, V, Q extends BasePageQuery, M extends CommonMapper<T>> {
    @Autowired
    protected AbstractBaseDao<T, M> myDao;
    /**
     * 通用的字段 version
     */
    private static final String VERSION = "version";

    /**
     * 可以自己去实现这个方法
     *
     * @param dto
     * @return
     */
    public Integer save(D dto) {
        return dto == null ? 0 : 1;
    }

    /**
     * 默认保存
     *
     * @param dto
     * @param clz
     * @return
     */
    public Integer save(D dto, Class<T> clz) {
        return myDao.save(BeanUtil.copyData(dto, clz));
    }


    /**
     * 只按照id
     *
     * @param id
     * @return
     */
    public Integer delete(Long id) {
        return myDao.delete(id);
    }

    /**
     * 切记只有BaseDeleteDTO可以使用这个方法
     *
     * @param baseDeleteDTO
     * @param clz
     * @return
     */
    public Integer delete(BaseDeleteDTO baseDeleteDTO, Class<T> clz) {
        Example example = new Example(clz);
        example.createCriteria().
                andEqualTo("id", baseDeleteDTO.getId()).
                andEqualTo(VERSION, baseDeleteDTO.getVersion());
        return this.myDao.delete(example);
    }

    /**
     * 可以自己实现更新方法，但是提供了默认
     *
     * @param dto
     * @return
     */
    public Integer update(D dto) {
        return dto == null ? 0 : 1;
    }

    /**
     * 这里注意不能 T target = null;
     *
     * @param dto
     * @return
     */
    public Integer update(D dto, Class<T> clz) {
        return myDao.update(BeanUtil.copyData(dto, clz));
    }

    /**
     * 通用的分页查询
     *
     * @param pageQuery 分页条件
     * @param entity    实体类类型
     * @param vo        VO类型
     * @return
     */
    public PageInfo<V> queryWithPage(Q pageQuery, Class<T> entity, Class<V> vo) {
        //创建Example,并且按照更新时间进行降序排序
        Example example = new Example(entity);
        example.orderBy("updatedTime").desc();
        //默认按照名字模糊查找
        example.createCriteria().andLike("name", "%" + pageQuery.getName() + "%");
        //开始分页，传入页码，页面大小
        PageMethod.startPage(pageQuery.getPageNum(), pageQuery.getPageSize());
        List<T> pages = this.myDao.queryWithPage(example);
        PageInfo<T> pageInfo = new PageInfo<>(pages, 5);
        //返回VO的分页对象
        return BeanUtil.convertPageInfo(pageInfo, vo);
    }

    public PageInfo<V> queryWithPage(Q pageQuery) {

        return pageQuery == null ? null : new PageInfo<>();
    }

    public V query(BaseQuery query) {
        // query
        return null;
    }

    /**
     * 传入类型即可查询，但是仅限于通用
     *
     * @param query
     * @param entity
     * @param vo
     * @return
     */
    public V query(BaseQuery query, Class<T> entity, Class<V> vo) {
        Example example = new Example(entity);
        example.createCriteria().andEqualTo("id", query.getId()).andEqualTo(VERSION, query.getVersion());
        return BeanUtil.copyData(this.myDao.getOneByExample(example), vo);
    }

    /**
     * 批量删除
     *
     * @param dtos
     * @return
     */
    public Integer multiDelete(List<D> dtos) {
        return dtos == null ? 0 : 1;
    }

    /**
     * 批量删除的实现
     * 但是仅限于通用
     *
     * @param dtos
     * @param clz
     * @return
     */
    @Transactional(propagation = Propagation.REQUIRED)
    public Integer multiDelete(List<D> dtos, Class<T> clz) {
        Example example = new Example(clz);
        // for循环进行删除
        // 进行拼接example然后进行统一删除
        for (D dto : dtos) {
            Example.Criteria criteria = example.createCriteria();
            criteria.
                    andEqualTo("id", ((BaseDTO) dto).getId()).
                    andEqualTo(VERSION, ((BaseDTO) dto).getVersion());
            example.or(criteria);
        }
        int result = this.myDao.delete(example);
        //如果删除个数不同，那么抛出异常进行回滚
        if (result != dtos.size()) {
            throw new BusinessException(SystemManageCodeEnum.SYSTEM_MANAGE_DATA_MULTI_DELETE_EXCEPTION);
        }
        return result;
    }


    /**
     * 用来验证Code有没有用过
     *
     * @param code
     * @return
     */
    public Boolean validateCode(String code) {
        return code == null;
    }

    /**
     * 用来验证name有没有用过
     *
     * @param name
     * @return
     */
    public Boolean validateName(String name) {
        return name == null;
    }

}
