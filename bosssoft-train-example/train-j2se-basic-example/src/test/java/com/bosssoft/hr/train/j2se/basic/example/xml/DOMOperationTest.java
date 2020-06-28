package com.bosssoft.hr.train.j2se.basic.example.xml;

import com.bosssoft.hr.train.j2se.basic.example.pojo.Student;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class DOMOperationTest {
    DOMOperation domOperation;
    Student student;

    @Before
    public void setUp() throws Exception {
        domOperation = new DOMOperation();
        student = new Student(1, "zhangsan", 22);
    }

    @After
    public void tearDown() throws Exception {
        domOperation = null;
        student = null;
    }

    @Test
    public void create() {
        student.setId(4);
        assertTrue(domOperation.create(student));
    }

    @Test
    public void remove() {
        //先创建
        student.setId(5);
        assertTrue(domOperation.create(student));
        assertTrue(domOperation.remove(student));
    }

    @Test
    public void update() {
        student.setId(6);
        assertTrue(domOperation.create(student));
        student.setName("zhangsansan");
        assertTrue(domOperation.update(student));
    }

    @Test
    public void query() {
        Student student = new Student(1, "");
        assertEquals(this.student, domOperation.query(student));
    }
}