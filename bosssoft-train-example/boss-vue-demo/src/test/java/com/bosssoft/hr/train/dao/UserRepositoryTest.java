package com.bosssoft.hr.train.dao;

import com.bosssoft.hr.train.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.Assert.*;

@SpringBootTest
class UserRepositoryTest {
    @Autowired
    private UserRepository userRepository;

    @Test
    void findAll() {
        System.out.println(userRepository.findAll());
    }


    @Test
    void save() {
        User user = new User();
        user.setName("王大虎");
        user.setCode("10001");
        userRepository.save(user);
    }
    @Test
    void findById(){
        User user = userRepository.findById(1).get();
        System.out.println(user);
    }
    @Test
    void update(){
        User user=new User();
        user.setId(12);
        user.setName("test");
        user.setCode("test123");
        System.out.println(userRepository.save(user));
    }
    @Test
    void deleteById(){
       // userRepository.deleteById(13);
    }
}