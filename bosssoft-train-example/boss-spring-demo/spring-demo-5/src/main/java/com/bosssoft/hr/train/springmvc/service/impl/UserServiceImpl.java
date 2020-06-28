package com.bosssoft.hr.train.springmvc.service.impl;

import com.bosssoft.hr.train.springmvc.bean.User;
import com.bosssoft.hr.train.springmvc.dao.UserDao;
import com.bosssoft.hr.train.springmvc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @description:
 * @author:zyz
 * @time:2020/6/5--20:06
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public User getUser() {
        return userDao.getUser();
    }
}
