package com.boss.learning.springlog.service;

import com.boss.learning.springlog.bean.User;
import com.boss.learning.springlog.common.MyLog;
import org.springframework.stereotype.Service;

/**
 * @description:
 * @author:zyz
 * @time:2020/6/3--19:41
 */
@Service
public class UserService {

    @MyLog(action = "添加用户", desc = "新增用户描述")
    public void saveUser(User user) {
        System.out.println("saveUser = " + user.getName());
    }

    @MyLog(action = "更新用户")
    public void updateUser(User user) {
        System.out.println("updateUser = " + user.getName());
    }

    @MyLog(action = "获取用户")
    public User getUser() {
        User user = new User();
        user.setName("test");
        return user;
    }
}
