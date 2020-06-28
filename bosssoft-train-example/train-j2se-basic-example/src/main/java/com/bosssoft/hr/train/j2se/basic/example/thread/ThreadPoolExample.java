package com.bosssoft.hr.train.j2se.basic.example.thread;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @description:
 * @author:zyz
 * @time:2020/5/30--16:59
 */
public class ThreadPoolExample {

    public ThreadPoolExecutor testThreadPool() {
        // 指定核心线程数量、最多线程数量、存活时间、阻塞队列、拒绝策略
        return new ThreadPoolExecutor(5,
                10,
                60,
                TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(10),
                new ThreadPoolExecutor.DiscardPolicy());

    }
}
