package com.bosssoft.hr.train.j2se.basic.example.annotation;


import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class BaseModelTest {
    UserModel userModel;

    @Before
    public void setUp() throws Exception {
        userModel = new UserModel(226, "zhaowu", 33);
    }

    @After
    public void tearDown() throws Exception {
        userModel = null;
    }

    @Test
    public void save() {
        userModel.setId(233);
        assertEquals(1, userModel.save());
        //删除防止之后测试重复
        assertEquals(1, userModel.remove());
    }

    @Test
    public void update() {
        userModel.setName("赵武");
        assertEquals(1, userModel.update());

    }

    @Test
    public void remove() {
        //先添加
        userModel = new UserModel(227, "zhaowu", 33);
        Assert.assertEquals(1, userModel.save());
        //存在返回1 不存在返回0
        assertEquals(1, userModel.remove());

    }

    @Test
    public void queryForList() {
        userModel.queryForList();
    }
}