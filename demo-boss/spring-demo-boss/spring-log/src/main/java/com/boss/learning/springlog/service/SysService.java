package com.boss.learning.springlog.service;

import com.boss.learning.springlog.common.MyLog;
import org.springframework.stereotype.Service;

/**
 * @description:
 * @author:zyz
 * @time:2020/6/3--19:45
 */
@Service
public class SysService {

    @MyLog(action = "获取当前时间戳")
    public long getTimeStamp() {
        long time = System.currentTimeMillis();
        System.out.println(time);
        return time;
    }

}
