package com.boss.hr.train.mybatis.dao;


import com.boss.hr.train.mybatis.bean.User;
import org.springframework.cache.annotation.Cacheable;

import java.util.List;

/**
 * @description:
 * @author:zyz
 * @time:2020/6/6--21:08
 */
@Cacheable
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
