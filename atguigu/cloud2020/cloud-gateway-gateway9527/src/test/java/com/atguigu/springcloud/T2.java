package com.atguigu.springcloud;

import org.junit.jupiter.api.Test;

import java.time.ZonedDateTime;

/**
 * @description:
 * @author:zyz
 * @time:2020/6/19-22:00
 */
public class T2 {

    @Test
    public void getTime(){
        ZonedDateTime zbj=ZonedDateTime.now();//默认时区
        System.out.println(zbj);
    }
}
