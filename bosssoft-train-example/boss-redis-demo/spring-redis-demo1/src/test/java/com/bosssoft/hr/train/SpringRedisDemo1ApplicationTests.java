package com.bosssoft.hr.train;

import com.bosssoft.hr.train.dao.UserMapper;
import com.bosssoft.hr.train.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class SpringRedisDemo1ApplicationTests {
    @Autowired
    UserMapper userMapper;



    @Test
    void contextLoads() {
        List<User> users = userMapper.findAll();
        System.out.println(users);
    }

}
