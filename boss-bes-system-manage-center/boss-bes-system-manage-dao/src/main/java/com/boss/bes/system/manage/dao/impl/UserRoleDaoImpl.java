package com.boss.bes.system.manage.dao.impl;

import boss.bes.log.exception.code.enums.BaseCodeEnum;
import boss.bes.log.exception.type.DaoException;
import com.boss.bes.system.manage.mapper.UserRoleMapper;
import com.boss.bes.system.manage.pojo.query.UserRoleQuery;
import com.boss.bes.system.manage.pojo.vo.UserRoleVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * @description:用户角色中间表的dao层实现类
 * @author:zyz
 * @time:2020/7/15-16:15
 */
@Repository
public class UserRoleDaoImpl extends AbstractUserRoleDao {
    @Autowired
    UserRoleMapper userRoleMapper;


    @Override
    public UserRoleVO getUsersForRole(UserRoleQuery query) {
        try {
            return userRoleMapper.getUserForRoleByRoleId(query);
        } catch (Exception e) {
            System.out.println(e);
            throw new DaoException(BaseCodeEnum.BASE_DATA_SELECT_EXCEPTION, e);
        }

    }


    @Override
    public Integer deleteUserRoleWithCompanyId(Long roleId, Long companyId) {
        try {
            return userRoleMapper.deleteUserRoleWithCompanyId(roleId, companyId);
        } catch (Exception e) {
            System.out.println(e);
            throw new DaoException(BaseCodeEnum.BASE_DATA_SELECT_EXCEPTION, e);
        }
    }
}
