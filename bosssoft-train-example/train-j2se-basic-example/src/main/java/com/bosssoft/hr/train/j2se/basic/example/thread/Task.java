package com.bosssoft.hr.train.j2se.basic.example.thread;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.util.Random;

/**
 * @description:
 * @author:zyz
 * @time:2020/5/30--19:43
 */
@Slf4j
@Data
public class Task implements Runnable {
    // 表示一个次序
    private int index;

    public Task(int index) {
        this.index = index;
    }

    @Override
    public void run() {

        //运行时间 至少执行1s
        int runTime = new Random().nextInt(5) + 1;
        log.info("正在执行的线程序号为：{},运行时间为：{} ", index, runTime);
        try {
            Thread.sleep((long) runTime * 100);
            log.info("线程{}执行完毕", index);
        } catch (Exception e) {
            log.warn("线程睡眠被打断");
        }

    }

    public Task() {
    }

}
