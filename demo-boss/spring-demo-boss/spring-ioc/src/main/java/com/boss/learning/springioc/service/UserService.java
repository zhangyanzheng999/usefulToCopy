package com.boss.learning.springioc.service;

import com.boss.learning.springioc.bean.User;
import com.boss.learning.springioc.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * @description:
 * @author:zyz
 * @time:2020/6/2--19:55
 */
@Service
/*@Scope("prototype")*/
public class UserService {
    @Autowired
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

    @PostConstruct
    public void init() {

        System.out.println("UserService 初始化了");
    }
    @PreDestroy
    public void destroy() {
        System.out.println("UserService 销毁了");
    }

}
