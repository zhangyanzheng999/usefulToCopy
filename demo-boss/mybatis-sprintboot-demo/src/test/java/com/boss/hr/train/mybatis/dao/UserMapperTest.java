package com.boss.hr.train.mybatis.dao;

import com.boss.hr.train.mybatis.bean.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;
@SpringBootTest
@RunWith(SpringRunner.class)
public class UserMapperTest {

    @Autowired
    UserMapper userMapper;

    @Test
    public void insertUser() {
    }

    @Test
    public void updateUser() {
    }

    @Test
    public void selectUserByCondition() {
        User user=new User();
        user.setUserName("%%");
        List<User> users = userMapper.selectUserByCondition(user);
        System.out.println(users);

        System.out.println(userMapper.selectUserByCondition(user));
    }
}