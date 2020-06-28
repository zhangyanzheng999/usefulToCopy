package com.bosssoft.hr.train.lock;

/**
 * 分布式锁
 */
public interface DistributionLock {
    /**
     * 获取锁
     * @return
     */
    boolean lock(String key, String requestId, int expire);

    /**
     * 释放锁
     * @return
     */
    boolean release(String key, String requestId);
}
