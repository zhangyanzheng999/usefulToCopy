package com.boss.bes.system.manage.service;

import com.boss.bes.system.manage.pojo.dto.UserRoleDTO;
import com.boss.bes.system.manage.pojo.entity.Role;
import com.boss.bes.system.manage.pojo.query.UserRoleQuery;
import com.boss.bes.system.manage.pojo.vo.UserRoleVO;

import java.util.List;

/**
 * @description:用户角色中间表的业务层
 * @author:zyz
 * @time:2020/7/15-16:10
 */

public interface UserRoleService {
    void updateUserRole(Boolean update, List<Role> roleList, Long userId);
    UserRoleVO getUsersForRole(UserRoleQuery query);

    void updateUserForRole(UserRoleDTO dto);
}
