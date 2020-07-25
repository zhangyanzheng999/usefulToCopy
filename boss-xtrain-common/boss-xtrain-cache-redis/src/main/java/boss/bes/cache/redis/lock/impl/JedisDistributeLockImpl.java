package boss.bes.cache.redis.lock.impl;

import boss.bes.cache.redis.api.RedisTemplateApi;
import boss.bes.cache.redis.lock.JedisDistributeLock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @description: 分布锁实现类，使用redisTemplate实现
 * @author 于海源
 * @time:2020/6/30-21:07
 */
@Component
public class JedisDistributeLockImpl implements JedisDistributeLock {

    @Autowired
    private RedisTemplateApi redisTemplateApi;

    /**
     * 尝试获取分布式锁
     * @param key 锁
     * @param id 请求标识
     * @param expireTime 超期时间
     * @return 是否获取成功
     */
    @Override
    public boolean getLock(String key, String id, int expireTime) {
        return redisTemplateApi.lock(key,id,expireTime);
    }

    /**
     * 释放分布式锁
     * @param key 锁
     * @param id 请求标识
     * @return 是否释放成功
     */
    @Override
    public boolean releaseLock(String key, String id) {
        return redisTemplateApi.release(key,id);
    }
}
