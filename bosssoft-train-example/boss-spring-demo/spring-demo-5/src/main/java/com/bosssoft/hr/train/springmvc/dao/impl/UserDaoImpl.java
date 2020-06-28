package com.bosssoft.hr.train.springmvc.dao.impl;

import com.bosssoft.hr.train.springmvc.bean.User;
import com.bosssoft.hr.train.springmvc.dao.UserDao;
import org.springframework.stereotype.Repository;

/**
 * @description:
 * @author:zyz
 * @time:2020/6/5--20:07
 */
@Repository
public class UserDaoImpl implements UserDao {
    @Override
    public User getUser() {
        User user = new User();
        user.setId(1);
        user.setName("张三");
        return user;
    }
}
