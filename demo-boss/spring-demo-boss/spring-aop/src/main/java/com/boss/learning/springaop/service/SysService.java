package com.boss.learning.springaop.service;

import org.springframework.stereotype.Service;

/**
 * @description:
 * @author:zyz
 * @time:2020/6/3--9:43
 */
@Service
public class SysService {
    //返回值不要为基础数据类型
    public Long getToken() {
        long time = System.currentTimeMillis();
        System.out.println("SysService.getToken = " + time);
        return time;
    }

    public void validate(){
        throw new NullPointerException("空指针异常");
    }
}
