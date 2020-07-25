package com.boss.bes.system.manage.dao.impl;

import boss.bes.log.exception.code.enums.BaseCodeEnum;
import boss.bes.log.exception.type.DaoException;
import com.boss.bes.system.manage.mapper.ResourceMapper;
import com.boss.bes.system.manage.pojo.entity.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @description:资源dao的实现类
 * @author:zyz
 * @time:2020/7/10-14:38
 */
@Repository
public class ResourceDaoImpl extends AbstractResourceDao {
    @Autowired
    ResourceMapper resourceMapper;

    @Override
    public Resource query(Long id, Long version) {
        try {
            return resourceMapper.getResource(id, version);
        } catch (Exception e) {
            throw new DaoException(BaseCodeEnum.BASE_DATA_SELECT_EXCEPTION, e);
        }
    }

    @Override
    public List<Resource> queryAllWithPageAndParent(String name, Long parentId) {
        try {
            return resourceMapper.getResourceWithPage(name, parentId);
        } catch (Exception e) {
            throw new DaoException(BaseCodeEnum.BASE_DATA_SELECT_EXCEPTION, e);
        }
    }
}
