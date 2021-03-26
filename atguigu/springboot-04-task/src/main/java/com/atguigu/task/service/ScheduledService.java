package com.atguigu.task.service;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

/**
 * @description:
 * @author:zyz
 * @time:2021/3/25-19:10
 */
@Service
public class ScheduledService {

   // @Scheduled(cron = "0/5 * * * * ?")
    public void hello(){
        System.out.println("hello ...");
    }
}
