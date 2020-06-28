package com.bosssoft.hr.train.spring;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class AppTest {
    App app;

    @Before
    public void setUp() throws Exception {
        app = new App();
    }

    @After
    public void tearDown() throws Exception {
        app = null;
    }

    @Test
    public void testByBeanFactory() {
        app.testByBeanFactory();
    }

    @Test
    public void testByClassPathXmlApplicationContext() {
        app.testByClassPathXmlApplicationContext();
    }
}