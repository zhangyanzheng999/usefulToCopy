package com.bosssoft.hr.train.service;

import com.bosssoft.hr.train.pojo.entity.User;
import com.github.pagehelper.PageInfo;

import java.util.List;

/**
 * @description:
 * @author:zyz
 * @time:2020/6/22-12:38
 */
public interface UserService {
    User findUserById(Integer id);

    List<User> findUsersLikeName(String name);

    User insertUser(User user);

    List<User> findWithExample(String name);

    PageInfo<User> findWithPage(Integer pageNum,Integer pageSize);
    PageInfo<User> findWithPageAndNo(Integer pageNum,Integer pageSize);
}
