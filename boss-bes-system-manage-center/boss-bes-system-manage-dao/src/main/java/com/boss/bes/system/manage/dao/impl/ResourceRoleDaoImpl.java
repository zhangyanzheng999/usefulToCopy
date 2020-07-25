package com.boss.bes.system.manage.dao.impl;

import boss.bes.log.exception.code.enums.BaseCodeEnum;
import boss.bes.log.exception.type.DaoException;
import com.boss.bes.system.manage.mapper.ResourceRoleMapper;
import com.boss.bes.system.manage.pojo.vo.ResourceRoleVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * @description:资源角色的dao层实现类
 * @author:zyz
 * @time:2020/7/16-16:35
 */
@Repository
public class ResourceRoleDaoImpl extends AbstractResourceRoleDao {
    @Autowired
    ResourceRoleMapper resourceRoleMapper;

    @Override
    public ResourceRoleVO queryResourceForRole(Long roleId) {
        try {
            return resourceRoleMapper.queryResourceForRole(roleId);
        } catch (Exception e) {
            throw new DaoException(BaseCodeEnum.BASE_DATA_SELECT_EXCEPTION, e);
        }

    }
}
