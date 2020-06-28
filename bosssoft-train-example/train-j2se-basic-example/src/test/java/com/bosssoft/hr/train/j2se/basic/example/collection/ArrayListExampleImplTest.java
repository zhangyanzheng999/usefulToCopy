package com.bosssoft.hr.train.j2se.basic.example.collection;

import com.bosssoft.hr.train.j2se.basic.example.pojo.User;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import javax.lang.model.element.VariableElement;

import static org.junit.Assert.*;

public class ArrayListExampleImplTest {
    ArrayListExampleImpl arrayListExample;
    User user;
    User user2;

    @Before
    public void setUp() throws Exception {
        arrayListExample = new ArrayListExampleImpl();
        user = new User(1, "zhangsan");
        user2 = new User(2, "lisi");
    }

    @After
    public void tearDown() throws Exception {
        arrayListExample = null;
        user = null;
        user2 = null;
    }

    @Test
    public void append() {
        //正常添加
        assertEquals(true, arrayListExample.append(user));
        // 添加为null
        assertEquals(true, arrayListExample.append(null));


    }

    @Test
    public void get() {
        //首先插入
        assertEquals(true, arrayListExample.append(user));
        //正常查询
        assertEquals(user, arrayListExample.get(0));

        //超出范围为null
        assertNull(arrayListExample.get(-1));

    }

    @Test
    public void insert() {
        //测试正常插入
        assertEquals(true, arrayListExample.insert(0, user));
        // 测试超出范围
        assertEquals(false, arrayListExample.insert(3, user));
        assertEquals(false, arrayListExample.insert(-1, user));

    }

    @Test
    public void remove() {
        //测试正常插入
        assertEquals(true, arrayListExample.insert(0, user));
        assertEquals(true, arrayListExample.insert(1, user));

        //正常删除
        assertEquals(true, arrayListExample.remove(0));

        //超出范围
        assertEquals(false, arrayListExample.remove(-1));
        assertEquals(false, arrayListExample.remove(5));
    }

    @Test
    public void listByIndex() {
        //测试正常插入
        assertEquals(true, arrayListExample.insert(0, user));
        assertEquals(true, arrayListExample.insert(1, user));
        try {
            arrayListExample.listByIndex();
            assertTrue(true);
        } catch (Exception e) {
            assertTrue(false);
        }

    }

    @Test
    public void listByIterator() {
        //测试正常插入
        assertEquals(true, arrayListExample.insert(0, user));
        assertEquals(true, arrayListExample.insert(1, user2));
        try {
            arrayListExample.listByIterator();
            assertTrue(true);
        } catch (Exception e) {
            assertTrue(false);
        }
    }

    @Test
    public void toArray() {
        //测试正常插入
        assertEquals(true, arrayListExample.insert(0, user));
        assertEquals(true, arrayListExample.insert(1, user2));
        User[] users = new User[]{user, user2};
        assertArrayEquals(users, arrayListExample.toArray());

    }

    @Test
    public void sort() {
        //测试正常插入
        assertEquals(true, arrayListExample.append(user2));
        assertEquals(true, arrayListExample.append(user));

        //顺序是否正确
        arrayListExample.sort();
        assertEquals(user, arrayListExample.get(0));
        assertEquals(user2, arrayListExample.get(1));
    }


}