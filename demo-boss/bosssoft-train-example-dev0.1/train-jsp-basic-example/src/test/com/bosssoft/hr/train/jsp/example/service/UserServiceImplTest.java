package com.bosssoft.hr.train.jsp.example.service;

import com.bosssoft.hr.train.jsp.example.pojo.User;
import com.bosssoft.hr.train.jsp.example.service.impl.UserServiceImpl;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class UserServiceImplTest {

    private UserService userService=new UserServiceImpl();
    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void save() {
        User user =new User(1,"jim");
        Assert.assertEquals(true,userService.save(user));
        //测试没有id 和 名字的参数
        User user2 =new User();
        Assert.assertEquals(true,userService.save(user));

        // 如果需要测试为空等继续构建 可以验证的 User
    }

    /**
     * 测试插入重复
     */
    @Test
    public void saveSameId() {
        User user =new User(1,"jim");
        Assert.assertEquals(false,userService.save(user));
    }


    @Test
    public void remove() {
    }

    /**
     * 依据界面可能开展的测试编写测试用例  例如某一些字段为空等，实际就是依据
     * 项目需求的测试用例来扩展测试用例
     */
    @Test
    public void update() {

    }

    @Test
    public void queryByCondition() {
    }

    /**
     * 测试正确账号和错误账号
     */
    @Test
    public void authentication() {
        //测试正确
        User user=new User("001","123456");
        Assert.assertEquals(true, userService.authentication(user));

        //测试错误账号
        User user2=new User("003","123456");
        Assert.assertEquals(true, userService.authentication(user2));

    }
}