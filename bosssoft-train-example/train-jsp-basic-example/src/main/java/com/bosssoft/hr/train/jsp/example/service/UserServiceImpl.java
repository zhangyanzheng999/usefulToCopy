package com.bosssoft.hr.train.jsp.example.service;

import com.bosssoft.hr.train.jsp.example.dao.UserDao;
import com.bosssoft.hr.train.jsp.example.dao.impl.UserDaoImpl;
import com.bosssoft.hr.train.jsp.example.exception.BusinessException;
import com.bosssoft.hr.train.jsp.example.pojo.Query;
import com.bosssoft.hr.train.jsp.example.pojo.User;

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
            UserDao userDao = new UserDaoImpl();
            int result = userDao.insert(user);
            return result > 0;
        } catch (Exception ex) {
            throw new BusinessException("10001", ex.getMessage(), ex);
        }

    }

    @Override
    public boolean remove(User user) {
        UserDao userDao = new UserDaoImpl();
        Integer userId = user.getId();
        int result = userDao.deleteById(userId);
        return result > 0;
    }

    @Override
    public boolean update(User user) {
        UserDao userDao = new UserDaoImpl();
        int result = userDao.update(user);
        return result > 0;
    }

    @Override
    public List<User> queryByCondition(Query queryCondition) {
        UserDao userDao = new UserDaoImpl();
        return userDao.queryByCondition(queryCondition);
    }

    @Override
    public boolean authentication(User user) {
        UserDao userDao = new UserDaoImpl();
        Query query = new Query(user);
        List<User> users = userDao.queryByCondition(query);
        return !users.isEmpty();
    }
}
