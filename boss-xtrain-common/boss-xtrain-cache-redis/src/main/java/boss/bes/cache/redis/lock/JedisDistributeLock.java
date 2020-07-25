package boss.bes.cache.redis.lock;

/**
 * @description: 分 布 锁 接 口
 * @author 于海源
 * @time:2020/6/30-21:07
 */
public interface JedisDistributeLock {
    /**
     * 尝试获取分布式锁
     * @param key 锁
     * @param id 请求标识
     * @param expireTime 超期时间
     * @return 是否获取成功
     */
    boolean getLock(String key, String id, int expireTime);
    /**
     * 释放分布式锁
     * @param key 锁
     * @param id 请求标识
     * @return 是否释放成功
     */
    boolean releaseLock(String key, String id);
}
