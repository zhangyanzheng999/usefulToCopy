package com.atguigu.task.service;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

/**
 * @description:
 * @author:zyz
 * @time:2021/3/25-18:59
 */
@Service
public class AsyncService {
    //告诉Spring这是一个异步方法
    @Async
    public void hello() {
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("数据处理中");
    }
}
