package com.boss.bes.system.manage.dao.impl;

import boss.bes.log.exception.code.enums.BaseCodeEnum;
import boss.bes.log.exception.type.DaoException;
import com.boss.bes.system.manage.mapper.OrganizationMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * @description:组织dao的实现类
 * @author:zyz
 * @time:2020/7/6-20:49
 */
@Repository
public class OrgDaoImpl extends AbstractOrgDao {
    @Autowired
    OrganizationMapper organizationMapper;

    @Override
    public String getOrgName(Long id) {
        try {
            return organizationMapper.getOrgName(id);
        } catch (Exception e) {
            throw new DaoException(BaseCodeEnum.BASE_DATA_SELECT_EXCEPTION);
        }
    }
}
