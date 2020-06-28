package com.bosssoft.hr.train.spring.service;

import com.bosssoft.hr.train.spring.bean.User;

import java.util.List;

/**
 * @description:
 * @author:zyz
 * @time:2020/6/5--10:20
 */
public interface UserService {
    User getUserById(Integer id);

    List<User> getUsersLikeName(String name);

    int addUser(User user);

    int deleteById(Integer id);
}
