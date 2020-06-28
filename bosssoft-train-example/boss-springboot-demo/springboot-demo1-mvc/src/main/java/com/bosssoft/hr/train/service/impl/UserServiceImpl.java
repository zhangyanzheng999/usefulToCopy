package com.bosssoft.hr.train.service.impl;

import com.bosssoft.hr.train.bean.User;
import com.bosssoft.hr.train.bean.UserExample;
import com.bosssoft.hr.train.dao.UserMapper;
import com.bosssoft.hr.train.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @description:
 * @author:zyz
 * @time:2020/6/8--21:23
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public int insetUser(User user) {
        return userMapper.insert(user);
    }

    @Override
    public List<User> queryUsers(User user) {
        UserExample example = new UserExample();
        UserExample.Criteria criteria = example.createCriteria();
        if (user != null) {
            criteria.andNameLike("%" + user.getName() + "%");
        } else {
            criteria.andNameLike("%%");
        }

        return userMapper.selectByExample(example);
    }

    @Override
    public int deleteUserById(Integer id) {

        return userMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int updateUser(User user) {
        return userMapper.updateByPrimaryKeySelective(user);
    }
}
