package com.bosssoft.hr.train.spring.dao;

import com.bosssoft.hr.train.spring.bean.User;

import java.util.List;

public interface UserDao {
    User getUserById(Integer id);
    List<User> getUsersLikeName(String name);
    int addUser(User user);
    int deleteById(Integer id);
}
