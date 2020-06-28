package com.boss.learning.springaop.service.impl;

import com.boss.learning.springaop.bean.User;
import com.boss.learning.springaop.service.IUserService;

/**
 * @description:
 * @author:zyz
 * @time:2020/6/3--9:17
 */
public class UserServiceImpl implements IUserService {
    public void saveUser(User user) {
        System.out.println("saveUser:"+user.getName());
    }
}
