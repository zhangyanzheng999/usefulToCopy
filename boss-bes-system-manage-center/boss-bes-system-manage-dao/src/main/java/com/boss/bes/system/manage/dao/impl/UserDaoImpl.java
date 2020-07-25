package com.boss.bes.system.manage.dao.impl;

import boss.bes.log.exception.code.enums.BaseCodeEnum;
import boss.bes.log.exception.code.enums.SystemManageCodeEnum;
import boss.bes.log.exception.type.DaoException;
import com.boss.bes.system.manage.mapper.UserMapper;
import com.boss.bes.system.manage.pojo.dto.UserForExamDTO;
import com.boss.bes.system.manage.pojo.dto.UserInfoDTO;
import com.boss.bes.system.manage.pojo.entity.User;
import com.boss.bes.system.manage.pojo.query.UserPageQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @description:用户dao的实现类
 * @author:zyz
 * @time:2020/7/12-16:02
 */
@Repository
public class UserDaoImpl extends AbstractUserDao {
    @Autowired
    UserMapper userMapper;

    @Override
    public List<User> queryAllWithPageAndCompany(UserPageQuery pageQuery) {

        try {
            return userMapper.getUsersWithCompanyName(pageQuery);
        } catch (Exception e) {
            throw new DaoException(BaseCodeEnum.BASE_DATA_SELECT_EXCEPTION,e);
        }
    }

    @Override
    public User query(Long id, Long version) {
        try {
            return userMapper.getUser(id, version);
        } catch (Exception e) {
            throw new DaoException(BaseCodeEnum.BASE_DATA_SELECT_EXCEPTION,e);
        }
    }


    @Override
    public Long getUserIdWithCode(String code) {
        try {
            return userMapper.getUserIdWithCode(code);
        } catch (Exception e) {
            throw new DaoException(BaseCodeEnum.BASE_DATA_SELECT_EXCEPTION,e);
        }

    }

    @Override
    public UserForExamDTO getUserWithOrgIdAndCompanyIdAndName(Long id) {
        try {
            //先正常拿，如果没有公司Id和组织Id那么去按照角色拿组织Id
            UserForExamDTO user = userMapper.getUserWithOrgIdAndCompanyIdAndName(id);
            if (user == null) {
                return new UserForExamDTO();
            }
            if (user.getCompanyId() == null && user.getCompanyId() == null) {
                Long orgByUserIdWithOutCompanyId = userMapper.getOrgByUserIdWithOutCompanyId(id);
                System.out.println(orgByUserIdWithOutCompanyId);
                user.setOrganizationId(orgByUserIdWithOutCompanyId);
            }
            return user;
        } catch (Exception e) {
            throw new DaoException(BaseCodeEnum.BASE_DATA_SELECT_EXCEPTION,e);
        }
    }


    @Override
    public Long generatorCode() {
        try {
            return userMapper.generatorCode();
        } catch (Exception e) {
            throw new DaoException(SystemManageCodeEnum.SYSTEM_MANAGE_USER_CODE_GENERATOR_EXCEPTION,e);
        }
    }


    @Override
    public List<UserInfoDTO> queryUserByRole(String roleName) {
        try {
            return userMapper.queryUserByRole(roleName);
        } catch (Exception e) {
            throw new DaoException(BaseCodeEnum.BASE_DATA_SELECT_EXCEPTION,e);
        }
    }
}
