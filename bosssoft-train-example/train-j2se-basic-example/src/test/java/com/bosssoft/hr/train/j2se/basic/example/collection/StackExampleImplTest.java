package com.bosssoft.hr.train.j2se.basic.example.collection;

import com.bosssoft.hr.train.j2se.basic.example.pojo.User;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayDeque;
import java.util.Deque;


import static org.junit.Assert.*;

public class StackExampleImplTest {
    StackExampleImpl stackExample;
    Deque<User> users;
    User user;
    User firstUser;
    @Before
    public void setUp() throws Exception {
        stackExample = new StackExampleImpl();
        firstUser=new User(0,"lisi");
        user = new User(1, "zhangsan");
        // 默认添加一个
        users=new ArrayDeque<>();
        users.push(firstUser);
        stackExample.setUsers(users);
    }

    @After
    public void tearDown() throws Exception {
        stackExample = null;
    }

    @Test
    public void push() {
        assertEquals(user,stackExample.push(user));
    }

    @Test
    public void pop() {
        assertEquals(firstUser,stackExample.pop());
    }

    @Test
    public void peek() {
        assertEquals(firstUser,stackExample.peek());
    }

    @Test
    public void empty() {
        //开始不为空
        assertFalse(stackExample.empty());
        // 删掉一个
        assertEquals(firstUser,stackExample.pop());
        //应该为空
        assertTrue(stackExample.empty());
    }


}