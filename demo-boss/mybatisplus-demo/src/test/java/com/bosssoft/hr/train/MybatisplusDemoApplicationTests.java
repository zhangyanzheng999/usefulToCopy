package com.bosssoft.hr.train;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.bosssoft.hr.train.entity.User;
import com.bosssoft.hr.train.service.IUserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class MybatisplusDemoApplicationTests {

    @Autowired
    IUserService userService;

    @Test
    void contextLoads() {
    }

    @Test
    void insert() {
        User user = new User(null, "mybatisplus", 12);
        userService.save(user);
        System.out.println(user);
    }

    @Test
    void update() {
        User user = new User(22862, "mybatisplus", 100);
        userService.updateById(user);
    }

    @Test
    void findById() {
        System.out.println(userService.getById(1));
    }

    @Test
    void findByWrapper() {
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.eq("name", "test0001")
                .ge("age", 99);

        System.out.println(userService.list(wrapper));

    }

    @Test
    void findByWrapperLikeName() {
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.like("name", "");

        System.out.println(userService.list(wrapper));
    }

    @Test
    void findWithPage() {
        Page<User> page = new Page<>(1, 5);
        Page<User> userPage = userService.page(page);
        System.out.println(userPage.getTotal());
    }

}
