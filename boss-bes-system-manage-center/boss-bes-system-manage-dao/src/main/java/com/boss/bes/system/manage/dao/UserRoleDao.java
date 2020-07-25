package com.boss.bes.system.manage.dao;

import com.boss.bes.system.manage.pojo.entity.UserRole;
import com.boss.bes.system.manage.pojo.query.UserRoleQuery;
import com.boss.bes.system.manage.pojo.vo.UserRoleVO;

/**
 * @description:用户中间表的dao
 * @author:zyz
 * @time:2020/7/15-16:13
 */
public interface UserRoleDao extends IBaseDao<UserRole>{

    UserRoleVO getUsersForRole(UserRoleQuery query);

    Integer deleteUserRoleWithCompanyId(Long roleId,Long companyId);
}
