package com.boss.bes.system.manage.dao.impl;

import boss.bes.log.exception.code.enums.BaseCodeEnum;
import boss.bes.log.exception.code.enums.SystemManageCodeEnum;
import boss.bes.log.exception.type.DaoException;
import com.boss.bes.system.manage.mapper.RoleMapper;
import com.boss.bes.system.manage.pojo.entity.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import java.util.List;

/**
 * @description:角色dao的实现类
 * @author:zyz
 * @time:2020/7/11-19:54
 */
@Repository
public class RoleDaoImpl extends AbstractRoleDao {
    @Autowired
    RoleMapper roleMapper;

    /**
     * 分为公司Id 是否为空两种情况
     *
     * @param name      %+角色名+%
     * @param companyId 公司Id
     * @param orgId     组织Id
     * @return
     */
    @Override
    public List<Role> queryAllWithPageAndCompanyAndOrg(String name, Long companyId, Long orgId) {
        try {
            if (companyId == null) {
                return roleMapper.getRoleWithPage(name, orgId);
            } else {
                return roleMapper.getRoleWithPageByCompanyId(name, companyId);
            }
        } catch (Exception e) {
            throw new DaoException(BaseCodeEnum.BASE_DATA_SELECT_EXCEPTION, e);
        }
    }


    @Override
    public List<Role> getRoleWithCompanyId(Long companyId) {
        try {
            return roleMapper.getRoleWithCompanyId(companyId);
        } catch (Exception e) {
            throw new DaoException(BaseCodeEnum.BASE_DATA_SELECT_EXCEPTION, e);
        }
    }


    @Override
    public Role query(Long id, Long version) {
        try {
            return roleMapper.getRoleWithCompanyAndOrg(id, version);
        } catch (Exception e) {
            throw new DaoException(BaseCodeEnum.BASE_DATA_SELECT_EXCEPTION, e);
        }
    }

    @Override
    public Role queryWithCompanyId(Long id, Long version, Long companyId) {
        try {
            return roleMapper.queryWithCompanyId(id, version, companyId);
        } catch (Exception e) {
            throw new DaoException(BaseCodeEnum.BASE_DATA_SELECT_EXCEPTION, e);
        }
    }

    @Override
    public Long generatorCode() {
        try {
            return roleMapper.generatorCode();
        } catch (Exception e) {
            throw new DaoException(SystemManageCodeEnum.SYSTEM_MANAGE_ROLE_CODE_GENERATOR_EXCEPTION,e);
        }
    }
}
