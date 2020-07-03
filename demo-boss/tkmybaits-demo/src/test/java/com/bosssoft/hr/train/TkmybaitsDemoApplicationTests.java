package com.bosssoft.hr.train;


import com.bosssoft.hr.train.dao.impl.UserDaoImpl;

import com.bosssoft.hr.train.pojo.entity.User;
import com.bosssoft.hr.train.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class TkmybaitsDemoApplicationTests {
    @Autowired
    UserService userService;
    @Autowired
    UserDaoImpl userDao;

    @Test
    void contextLoads() {
        System.out.println("**************" + userService.findUserById(1));
    }

    @Test
    void testWithLikeName() {
        System.out.println(userService.findUsersLikeName("%%"));
    }

    @Test
    void testInsert() {
        User user = new User(null, "test0001", 99);
        // System.out.println(userService.insertUser(user));

        System.out.println(userDao.save(user));
    }


    @Test
    void findWithExample() {

        System.out.println(userService.findWithExample("%%"));
    }


    @Test
    void findWithPage() {
        System.out.println(userService.findWithPage(1, 3));
    }
    @Test
    void findWithPageNo() {
        System.out.println(userService.findWithPageAndNo(3, 3));
    }
}
