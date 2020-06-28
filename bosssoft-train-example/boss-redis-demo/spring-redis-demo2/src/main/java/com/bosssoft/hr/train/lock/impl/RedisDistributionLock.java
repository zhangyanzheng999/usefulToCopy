package com.bosssoft.hr.train.lock.impl;

import com.bosssoft.hr.train.lock.DistributionLock;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.script.DefaultRedisScript;
import org.springframework.data.redis.core.script.RedisScript;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.concurrent.TimeUnit;

/**
 * @param
 * @description: 首先，为了确保分布式锁可用，我们至少要确保锁的实现同时满足以下四个条件：
 * 互斥性。在任意时刻，只有一个客户端能持有锁。
 * 不会发生死锁。即使有一个客户端在持有锁的期间崩溃而没有主动解锁，也能保证后续其他客户端能加锁。
 * 具有容错性。只要大部分的Redis节点正常运行，客户端就可以加锁和解锁。
 * 解铃还须系铃人。加锁和解锁必须是同一个客户端，客户端自己不能把别人加的锁给解了。
 * @author: Administrator
 * @create: 2020-03-09 14:11
 * @since
 **/
@Slf4j
@Component(value = "lock")
public class RedisDistributionLock implements DistributionLock {
    private static final Long SUCCESS = 1L;
    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    /**
     * 升级 spring-data-redis 版本到 2.1 以上 setIfAbsent为原子操作
     *
     * @param key
     * @param requestId uuid
     * @param expire    过期时间防止死锁
     * @return 加锁成功则true 否则 false
     */
    @Override
    public boolean lock(String key, String requestId, int expire) {
        //保证获取锁和设置过期时间为原子操作
        return redisTemplate.opsForValue().setIfAbsent(key, requestId, expire, TimeUnit.SECONDS);

    }

    /**
     * A 进程业务还没有处理完锁过期，B进程将成功获得锁，A进程继续执行业务最后释放锁前要判断是否
     * A 进程的锁，如果不是A则不可以释放该锁，因此释放动作需要保证原子操作
     *
     * @param key
     * @param requestId
     * @return
     */
    @Override
    public boolean release(String key, String requestId) {
        //使用lua
        String script = "if redis.call('get', KEYS[1]) == ARGV[1] then return redis.call('del', KEYS[1]) else return 0 end";
        RedisScript<String> redisScript = new DefaultRedisScript<>(script, String.class);
        log.info(String.format("%s 准备释放锁 ", requestId));
        Object result = redisTemplate.execute(redisScript, Collections.singletonList(key), requestId);
        //这里的result返回的是是否成功
        return result.equals(SUCCESS);

    }
}
