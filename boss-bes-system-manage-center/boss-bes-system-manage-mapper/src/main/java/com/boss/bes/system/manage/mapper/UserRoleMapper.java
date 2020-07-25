package com.boss.bes.system.manage.mapper;


import com.boss.bes.system.manage.pojo.entity.UserRole;
import com.boss.bes.system.manage.pojo.query.UserRoleQuery;
import com.boss.bes.system.manage.pojo.vo.UserRoleVO;
import org.apache.ibatis.annotations.Param;

public interface UserRoleMapper extends CommonMapper<UserRole> {



    UserRoleVO getUserForRoleByRoleId(UserRoleQuery query);

    Integer deleteUserRoleWithCompanyId(@Param("roleId") Long roleId,@Param("companyId") Long companyId);

}