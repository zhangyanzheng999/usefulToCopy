package com.bosssoft.hr.train.service.impl;


import com.bosssoft.hr.train.dao.mapper.UserMapper;
import com.bosssoft.hr.train.pojo.entity.User;
import com.bosssoft.hr.train.service.UserService;
import com.github.pagehelper.PageInfo;
import com.github.pagehelper.page.PageMethod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;
import tk.mybatis.mapper.util.Sqls;
import tk.mybatis.mapper.weekend.WeekendSqls;

import java.util.List;

/**
 * @description:
 * @author:zyz
 * @time:2020/6/22-12:39
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserMapper userMapper;

    @Override
    public User findUserById(Integer id) {


        return userMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<User> findUsersLikeName(String name) {

        return userMapper.findUsersLikeName(name);
    }

    @Override
    public User insertUser(User user) {
        userMapper.insert(user);
        return user;
    }

    @Override
    public List<User> findWithExample(String name) {
   /*     Example example = Example.builder(User.class)
                .select("id","name", "age")
                .where(Sqls.custom().andLike("name", name))
                .build();*/
 /*       Example example=new Example(User.class);
        example.setDistinct(true);
        Example.Criteria criteria = example.createCriteria();
        criteria.andLike("name",name);*/

        Example example = Example.builder(User.class)
                .where(WeekendSqls.<User>custom().andEqualTo(User::getId, 1))
                .build();
        return userMapper.selectByExample(example);
    }

    @Override
    public PageInfo<User> findWithPage(Integer pageNum, Integer pageSize) {
        PageMethod.startPage(pageNum, pageSize);
        List<User> users = userMapper.selectAll();

        return PageInfo.of(users, 5);
    }


    public PageInfo<User> findWithPageAndNo(Integer pageNum, Integer pageSize) {

        PageMethod.startPage(pageNum, pageSize);
        List<User> users = userMapper.findUsersWithNo((pageNum - 1) * pageSize);
        System.err.println(users);
        return PageInfo.of(users, 5);
    }
}
