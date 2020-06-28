package com.bosssoft.hr.train.service.impl;

import com.bosssoft.hr.train.bean.User;
import com.bosssoft.hr.train.dao.UserMapper;
import com.bosssoft.hr.train.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @description:
 * @author:zyz
 * @time:2020/6/17-16:26
 */
@Service
public class LoginServiceImpl implements LoginService {
    @Autowired
    UserMapper userMapper;

    @Override
    public Integer checkUser(User user) {
        User queryUser = userMapper.getUser(user);
        return queryUser == null ? -1 : queryUser.getUserId();
    }
}
