package com.bosssoft.hr.train.dao;

import com.bosssoft.hr.train.bean.User;

import java.util.List;

/**
 * @description:测试缓存一定是要有一个查询，再有可以更改数据库的语句
 * @author:zyz
 * @time:2020/6/7--18:37
 */
public interface UserMapper {
    List<User> getUserLikeName(String name);

    int insertUser(User user);
}
