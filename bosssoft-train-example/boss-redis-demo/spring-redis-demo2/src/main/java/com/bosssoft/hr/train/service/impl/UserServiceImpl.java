package com.bosssoft.hr.train.service.impl;

import com.bosssoft.hr.train.entity.User;
import com.bosssoft.hr.train.mapper.UserMapper;
import com.bosssoft.hr.train.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

/**
 * @description:
 * @author:zyz
 * @time:2020/6/13-21:23
 */
@Service
@Slf4j
public class UserServiceImpl implements UserService {
    @Autowired
    UserMapper userMapper;

    @Autowired
    RedisTemplate<String, Object> redisTemplate;

    private static final String PREFIX = "lockUser_";
    private static final int CACHE_TIME = 30;
    private static final String LOCK_NAME = "key_mutex";

    /**
     * 方法默认为数据库都有
     *
     * @param id
     * @return
     */
    public User getUserById(Integer id) {
        String cacheKey = PREFIX + "id";
        User user = (User) redisTemplate.opsForValue().get(cacheKey);
        if (user == null) { // 缓存值过期
            // 设置3min的超时，防止del操作失败的时候，下次缓存过期一直不能load db
            // 这里注意要value为锁的拥有者
            // 如果锁已经存在这里返回false
            Boolean ifAbsent = redisTemplate.opsForValue().setIfAbsent(LOCK_NAME, id, 180, TimeUnit.SECONDS);
            if (Boolean.TRUE.equals(ifAbsent)) {
                // 拿到锁,重新去数据库获取
                user = userMapper.getUserById(id);
                // 添加到redis
                redisTemplate.opsForValue().set(cacheKey, user, CACHE_TIME, TimeUnit.SECONDS);
                // 删除锁 这里有一个问题，当这个操作处理时间过长锁已经过期了，但是还是会删除掉锁
                // 所以需要判断一下所得拥有者 这样做可能还是会有些问题所以改用Lua脚本吧，可以看lock包下的实现类
                if (redisTemplate.opsForValue().get(LOCK_NAME).equals(id)) {
                    redisTemplate.delete(LOCK_NAME);
                }
            } else {
                tryGetLock(id, 5L);
            }
        }

        return user;
    }

    /**
     * 尝试再次拿到锁,用于第一次没获取到
     *
     * @param id
     * @param seconds
     */
    public void tryGetLock(Integer id, Long seconds) {
        //等待一会儿重新获取
        try {
            Thread.sleep(seconds * 60);
            getUserById(id);
        } catch (Exception e) {
            log.warn("线程被迫中断，方法为：{}", "UserServiceImpl.getUserById");
        }
    }


}
