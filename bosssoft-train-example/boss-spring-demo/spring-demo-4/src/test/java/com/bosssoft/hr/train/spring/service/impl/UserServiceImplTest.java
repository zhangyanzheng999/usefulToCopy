package com.bosssoft.hr.train.spring.service.impl;

import com.bosssoft.hr.train.spring.bean.User;
import com.bosssoft.hr.train.spring.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class UserServiceImplTest {
    @Autowired
    UserService userService;


    @Test
    public void insert() {
        User user = new User("张三");
        assertTrue(userService.insert(user) > 0);
    }

    @Test
    public void update() {
        User user = new User(2, "张三2");
        assertEquals(1, userService.update(user));
    }

    @Test
    public void deleteById() {
        //不存在
        assertEquals(0, userService.deleteById(0));

        //删除一条 先添加防止找不到
        User user = new User("张三");
        userService.insert(user);
        assertEquals(1, userService.deleteById(user.getId()));

    }

    @Test
    public void queryUsers() {
        assertTrue(!userService.queryUsers("%%").isEmpty());
    }

    @Test
    public void deleteByArray() {
        User user = new User("张三deleteByArray");
        userService.insert(user);
        User user2 = new User("李四deleteByArray");
        userService.insert(user2);
        // 批量删除，两条记录
        assertEquals(2, userService.deleteByArray(user.getId(), user2.getId()));

    }
}