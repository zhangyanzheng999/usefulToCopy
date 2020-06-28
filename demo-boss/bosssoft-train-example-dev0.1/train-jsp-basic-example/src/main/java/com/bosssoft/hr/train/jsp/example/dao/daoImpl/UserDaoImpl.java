package com.bosssoft.hr.train.jsp.example.dao.daoImpl;

import com.bosssoft.hr.train.jsp.example.dao.UserDao;
import com.bosssoft.hr.train.jsp.example.pojo.Query;
import com.bosssoft.hr.train.jsp.example.pojo.User;

import java.util.List;

/**
 * @description:
 * @author: Administrator
 * @create: 2020-05-30 10:42
 * @since
 **/
public class UserDaoImpl implements UserDao {
    @Override
    public int insert(User user) {
        return 0;
    }

    @Override
    public int deleteById(Integer id) {
        return 0;
    }

    @Override
    public int update(User user) {
        return 0;
    }

    @Override
    public List<User> queryByCondition(Query queryCondition) {
        return null;
    }
}
