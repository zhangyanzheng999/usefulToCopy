package com.boss.bes.system.manage.mapper;

import com.boss.bes.system.manage.pojo.dto.UserForExamDTO;
import com.boss.bes.system.manage.pojo.dto.UserInfoDTO;
import com.boss.bes.system.manage.pojo.entity.User;
import com.boss.bes.system.manage.pojo.query.UserPageQuery;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @description:UserMapper 主要是联级查询
 * @author:zyz
 * @time:2020/7/13-21:58
 */
public interface UserMapper extends CommonMapper<User> {

    User getUser(@Param("id") Long id, @Param("version") Long version);


    List<User> getUsersWithCompanyName(UserPageQuery userPageQuery);


    Long getUserIdWithCode(String code);

    UserForExamDTO getUserWithOrgIdAndCompanyIdAndName(Long id);

    Long generatorCode();

    User getUserById(Long id);


    Long getOrgByUserIdWithOutCompanyId(Long id);

    List<UserInfoDTO> queryUserByRole(String roleName);
}