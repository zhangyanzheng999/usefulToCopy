package com.bosssoft.hr.train.j2se.basic.example.xml;

import com.bosssoft.hr.train.j2se.basic.example.pojo.Student;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class SAXOperationTest {
    SAXOperation saxOperation;
    Student student;

    @Before
    public void setUp() throws Exception {
        saxOperation = new SAXOperation();
        student = new Student(1, "zhangsan", 10);
    }

    @After
    public void tearDown() throws Exception {
        saxOperation = null;
        student = null;
    }

    @Test
    public void create() {
        assertFalse(saxOperation.create(null));
        student.setId(5);
        assertTrue(saxOperation.create(student));
    }

    @Test
    public void remove() {
        //先添加一个
        student.setId(6);
        assertTrue(saxOperation.create(student));
        assertTrue(saxOperation.remove(student));
    }

    @Test
    public void update() {
        //先添加一个
        student.setId(7);
        assertTrue(saxOperation.create(student));
        student.setName("test");
        assertTrue(saxOperation.update(student));
    }

    @Test
    public void query() {
        //假定 年龄为22
        student.setId(4);
        Student result = new Student(4, "zhangsan", 22);
        assertEquals(result, saxOperation.query(student));
    }
}