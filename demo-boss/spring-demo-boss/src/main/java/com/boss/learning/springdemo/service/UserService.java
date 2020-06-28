package com.boss.learning.springdemo.service;

import com.boss.learning.springdemo.bean.User;
import com.boss.learning.springdemo.dao.UserDao;

/**
 * @description:
 * @author:zyz
 * @time:2020/6/2--19:55
 */
public class UserService {

    private UserDao userDao;

    public UserService(UserDao userDao) {
        this.userDao = userDao;
    }

    public UserService() {

        System.out.println("UserService:创建了");
    }

    public void saveUser(User user) {
        userDao.saveUser(user);
        System.out.println("saveUser:" + user.getName());
    }


    public void init() {

        System.out.println("UserService 初始化了");
    }

    public void destroy() {
        System.out.println("UserService 销毁了");
    }

}
