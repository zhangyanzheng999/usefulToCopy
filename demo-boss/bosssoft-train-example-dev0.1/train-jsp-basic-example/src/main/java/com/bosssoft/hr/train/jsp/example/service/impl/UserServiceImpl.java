package com.bosssoft.hr.train.jsp.example.service.impl;

import com.bosssoft.hr.train.jsp.example.exception.BusinessException;
import com.bosssoft.hr.train.jsp.example.pojo.Query;
import com.bosssoft.hr.train.jsp.example.pojo.User;
import com.bosssoft.hr.train.jsp.example.service.UserService;

import java.util.List;

/**
 * @description:
 * @author: Administrator
 * @create: 2020-05-30 10:24
 * @since
 **/

public class UserServiceImpl implements UserService {
    @Override
    public boolean save(User user) {
        try {
            // do you logic
            return true;
        }catch (Exception ex){
            throw new BusinessException("10001",ex.getMessage(),ex);
        }

    }

    @Override
    public boolean remove(User user) {
        return false;
    }

    @Override
    public boolean update(User user) {
        return false;
    }

    @Override
    public List<User> queryByCondition(Query queryCondition) {
        return null;
    }

    @Override
    public boolean authentication(User user) {
        return false;
    }
}
