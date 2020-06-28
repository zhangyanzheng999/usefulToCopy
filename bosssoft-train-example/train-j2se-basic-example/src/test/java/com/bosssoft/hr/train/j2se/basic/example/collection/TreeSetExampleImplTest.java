package com.bosssoft.hr.train.j2se.basic.example.collection;

import com.bosssoft.hr.train.j2se.basic.example.pojo.User;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import static org.junit.Assert.*;
import static org.junit.Assert.assertTrue;

public class TreeSetExampleImplTest {
    TreeSetExampleImpl treeSetExample;
    User user;

    @Before
    public void setUp() throws Exception {
        treeSetExample = new TreeSetExampleImpl();
        user = new User(1, "zhangsan");
    }

    @After
    public void tearDown() throws Exception {
        treeSetExample = null;
        user = null;
    }

    @Test
    public void add() {
        assertEquals(true, treeSetExample.add(user));
    }

    @Test
    public void remove() {
        assertEquals(true, treeSetExample.add(user));
    }

    @Test
    public void size() {
        assertEquals(0, treeSetExample.size());
        // 添加之后
        assertEquals(true, treeSetExample.add(user));
        assertEquals(1, treeSetExample.size());
    }

    @Test
    public void isEmpty() {
        assertTrue(treeSetExample.isEmpty());
        assertEquals(true, treeSetExample.add(user));
        assertFalse(treeSetExample.isEmpty());
    }

    @Test
    public void contains() {
        assertFalse(treeSetExample.contains(user));

        assertEquals(true, treeSetExample.add(user));
        assertTrue(treeSetExample.contains(user));
    }

    @Test
    public void iterator() {

        assertNotNull(treeSetExample.iterator());
    }


    @Test
    public void addAll() {
        // 创建collection
        Collection<User> c = new ArrayList<>();
        c.add(user);
        User tempUser = new User(2, "lisi");
        c.add(tempUser);

        treeSetExample.addAll(c);
        assertTrue(treeSetExample.contains(user));
        assertTrue(treeSetExample.contains(tempUser));
    }

    @Test
    public void sort() {
        User testUser01 = new User(1, "zhangsan");
        User testUser02 = new User(3, "lisi");
        User testUser03 = new User(2, "wangwu");

        User[] users = new User[]{testUser01, testUser02, testUser03};
        User[] allUser = treeSetExample.sort(users);
        assertEquals(testUser01, allUser[0]);
        assertEquals(testUser02, allUser[2]);
        assertEquals(testUser03, allUser[1]);

    }

    @Test
    public void clear() {
        assertTrue(treeSetExample.add(user));

        //请控制后判断大小
        treeSetExample.clear();
        assertTrue(treeSetExample.isEmpty());
    }
}