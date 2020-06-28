package com.boss.learning.springioc.dao;

import com.boss.learning.springioc.bean.User;
import org.springframework.stereotype.Repository;

/**
 * @description:
 * @author:zyz
 * @time:2020/6/3--8:28
 */
@Repository
public class UserDao {
    public void saveUser(User user) {
        System.out.println(user.getName() + "保存到数据库了");
    }
}
