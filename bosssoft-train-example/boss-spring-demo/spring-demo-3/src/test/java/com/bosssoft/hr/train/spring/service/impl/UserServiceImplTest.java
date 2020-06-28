package com.bosssoft.hr.train.spring.service.impl;

import com.bosssoft.hr.train.spring.bean.User;
import com.bosssoft.hr.train.spring.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class UserServiceImplTest {
    @Autowired
    UserService userService;

    @Test
    public void getUserById() {
        User user = new User();
        user.setId(10);
        user.setName("cache-get");
        assertEquals(user, userService.getUserById(10));
    }

    @Test
    public void getUsersLikeName() {
        assertTrue(!userService.getUsersLikeName("%%").isEmpty());
    }

    @Test
    public void addUser() {
        User user = new User();
        user.setName("cache-addUser");
        assertEquals(1, userService.addUser(user));
    }

    @Test
    public void deleteById() {
        User user = new User();
        user.setName("cache-delete");
        assertEquals(1, userService.addUser(user));

        assertEquals(1, userService.deleteById(user.getId()));
    }
}