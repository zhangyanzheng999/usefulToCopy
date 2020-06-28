package com.atguigu.service;

import org.springframework.web.context.request.async.DeferredResult;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * @description:
 * @author:zyz
 * @time:2020/5/19--17:18
 */
public class DeferredResultQueue {
    private static Queue<DeferredResult<Object>> queue=new ConcurrentLinkedQueue<>();
    public static void save(DeferredResult<Object> deferredResult){
        queue.add(deferredResult);
    }

    public static DeferredResult<Object> get(){
        return queue.poll();
    }
}
