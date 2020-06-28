package com.bosssoft.hr.train.j2se.basic.example.thread;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.concurrent.ThreadPoolExecutor;

import static org.junit.Assert.*;

public class ThreadPoolExampleTest {

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void testThreadPool() {
        ThreadPoolExample threadPoolExample = new ThreadPoolExample();
        ThreadPoolExecutor executor = threadPoolExample.testThreadPool();
        for(int i=0;i<20;i++){
            Task task=new Task(i);
            // 提交任务间隔0.1s
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            executor.execute(task);
        }
    }
}