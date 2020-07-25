package com.boss.bes.system.manage.service.impl;


import boss.bes.log.exception.code.enums.SystemManageCodeEnum;
import boss.bes.log.exception.type.DaoException;
import com.boss.bes.system.manage.dao.UserRoleDao;
import com.boss.bes.system.manage.pojo.dto.UserRoleDTO;
import com.boss.bes.system.manage.pojo.entity.Role;
import com.boss.bes.system.manage.pojo.entity.User;
import com.boss.bes.system.manage.pojo.entity.UserRole;
import com.boss.bes.system.manage.pojo.query.UserRoleQuery;
import com.boss.bes.system.manage.pojo.vo.UserRoleVO;
import com.boss.bes.system.manage.service.UserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * @description:用户角色中间表不能继承BaseService
 * @author:zyz
 * @time:2020/7/15-16:10
 */
@Service
public class UserRoleServiceImpl implements UserRoleService {
    @Autowired
    UserRoleDao userRoleDao;

    /**
     * 用来更新用户角色表
     *
     * @param update   是否新增
     * @param roleList 角色信息
     * @param userId   用户Id
     */
    @Transactional
    public void updateUserRole(Boolean update, List<Role> roleList, Long userId) {
        //更新要先删除
        if (update) {
            Example example = new Example(UserRole.class);
            example.createCriteria().andEqualTo("userId", userId);
            int result = userRoleDao.getListByExample(example).size();
            if (userRoleDao.delete(example) != result) {
                throw new DaoException(SystemManageCodeEnum.SYSTEM_MANAGE_USER_ROLE_UPDATE_EXCEPTION);
            }
        }
        //开始操作新的
        UserRole userRole;
        for (Role role : roleList) {
            userRole = new UserRole(userId, role.getId());
            if (userRoleDao.save(userRole) == 0) {
                throw new DaoException(SystemManageCodeEnum.SYSTEM_MANAGE_USER_ROLE_UPDATE_EXCEPTION);
            }
        }
    }


    @Override
    public UserRoleVO getUsersForRole(UserRoleQuery query) {
        UserRoleVO usersForRole = userRoleDao.getUsersForRole(query);
        //看先前有没有过
        return usersForRole == null ? new UserRoleVO() : usersForRole;
    }

    /**
     * 逻辑就是先删除掉之前公司有的，然后添加新的进去
     * @param dto
     */
    @Override
    @Transactional
    public void updateUserForRole(UserRoleDTO dto) {
        //先删除掉公司下的
        userRoleDao.deleteUserRoleWithCompanyId(dto.getRoleId(),dto.getCompanyId());

        //添加
        //开始操作新的
        UserRole userRole;
        for (User user : dto.getUsers()) {
            userRole = new UserRole(user.getId(), dto.getRoleId());
            if (userRoleDao.save(userRole) == 0) {
                throw new DaoException(SystemManageCodeEnum.SYSTEM_MANAGE_USER_ROLE_UPDATE_EXCEPTION);
            }
        }
    }
}
