package com.bosssoft.hr.train.spring.service.impl;

import com.bosssoft.hr.train.spring.bean.User;
import com.bosssoft.hr.train.spring.dao.UserMapper;
import com.bosssoft.hr.train.spring.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @description:UserService的实现
 * @author:zyz
 * @time:2020/6/4--21:10
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserMapper userMapper;

    public int insert(User user) {
        return userMapper.insert(user);
    }

    public int update(User user) {
        return userMapper.update(user);
    }

    public int deleteById(Integer id) {
        return userMapper.deleteById(id);
    }


    public List<User> queryUsers(String name) {
        return userMapper.queryUsers(name);
    }

    /**
     * 批量删除开启事务管理，如果失败回滚
     *
     * @param ids
     * @return
     */
    @Transactional
    public int deleteByArray(int... ids) {
        return userMapper.deleteByArray(ids);
    }

}
