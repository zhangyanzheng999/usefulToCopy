package com.boss.mybatis.db.mapper;

import com.boss.mybatis.db.model.User;

import java.util.List;

/**
 * @description:
 * @author:zyz
 * @time:2020/6/6--21:08
 */
public interface UserMapper {
    /**
     * 新增用户
     *
     * @param user
     * @return
     */
    int insertUser(User user);

    /**
     * 修改用户
     *
     * @param user
     */
    void updateUser(User user);

    /**
     * 查询用户
     *
     * @param user
     * @return
     */
    List<User> selectUserByCondition(User user);
}
