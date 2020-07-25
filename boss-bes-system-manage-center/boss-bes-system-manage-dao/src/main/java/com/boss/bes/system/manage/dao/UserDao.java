package com.boss.bes.system.manage.dao;

import com.boss.bes.system.manage.pojo.dto.UserForExamDTO;
import com.boss.bes.system.manage.pojo.dto.UserInfoDTO;
import com.boss.bes.system.manage.pojo.entity.User;
import com.boss.bes.system.manage.pojo.query.UserPageQuery;

import java.util.List;

/**
 * @description:用户dao
 * @author:zyz
 * @time:2020/7/12-16:00
 */
public interface UserDao {
    /**
     * 查询
     * @param id
     * @param version
     * @return
     */
    User query(Long id, Long version);

    /**
     * 分页查询
     * @param pageQuery
     * @return
     */
    List<User> queryAllWithPageAndCompany(UserPageQuery pageQuery);


    /**
     * 根据用户Code返回用户Id
     * @param code
     * @return
     */
    Long getUserIdWithCode(String code);

    /**
     * 根据用户Id拿到用户一些信息
     * @param id
     * @return
     */
    UserForExamDTO getUserWithOrgIdAndCompanyIdAndName(Long id);



    /**
     * 自动生成Code
     * @return
     */
    Long generatorCode();


    List<UserInfoDTO> queryUserByRole(String roleName);
}
