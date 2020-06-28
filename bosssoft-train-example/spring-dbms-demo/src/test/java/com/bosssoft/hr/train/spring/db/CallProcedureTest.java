package com.bosssoft.hr.train.spring.db;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class CallProcedureTest {

    @Autowired
    CallProcedure callProcedure;


    @Test
    public void callProcedure() {
        assertEquals(0,callProcedure.callProcedure(100000,10));
    }
}