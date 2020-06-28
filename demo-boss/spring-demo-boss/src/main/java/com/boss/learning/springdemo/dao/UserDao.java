package com.boss.learning.springdemo.dao;

import com.boss.learning.springdemo.bean.User;

/**
 * @description:
 * @author:zyz
 * @time:2020/6/3--8:28
 */
public class UserDao {
    public void saveUser(User user) {
        System.out.println(user.getName() + "保存到数据库了");
    }
}
