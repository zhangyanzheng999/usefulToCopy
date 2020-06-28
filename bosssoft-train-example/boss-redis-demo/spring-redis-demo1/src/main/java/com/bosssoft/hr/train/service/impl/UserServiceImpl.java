package com.bosssoft.hr.train.service.impl;

import com.bosssoft.hr.train.dao.UserMapper;
import com.bosssoft.hr.train.entity.User;
import com.bosssoft.hr.train.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.concurrent.TimeUnit;

/**
 * @description:
 * @author:zyz
 * @time:2020/6/13-17:57
 */
@Service
@Slf4j
@CacheConfig(cacheNames = "user")
public class UserServiceImpl implements UserService {
    @Autowired
    UserMapper userMapper;

    @Autowired
    RedisTemplate<Object, Object> redisTemplate;
    /**
     * 通识符前缀
     */
    private static final String PREFIX = "user_";

    /**
     * 使用redisTemplate手动添加缓存
     *
     * @return
     */
    @Override
    public Object findAll() {
        //默认缓存时间
        int cacheTime = 30;
        String cacheKey = "user_list";
        //缓存标记
        String cacheSign = cacheKey + "_sign";
        String sign = (String) redisTemplate.opsForValue().get(cacheSign);
        //根据前缀模糊查询
        //获取所有的key
        Set<Object> keys = redisTemplate.keys(PREFIX + "*");
        //获取数据
        List<Object> cacheValue = redisTemplate.opsForValue().multiGet(keys);

        //如果缓存了(没过期)
        if (sign != null) {
            //直接返回
            log.info("redis中存在用户列表,值为{}", cacheValue);
            return cacheValue;
        } else {
            log.info("redis中不存在用户列表,下面重新放入");
            //将这个标记缓存一下
            redisTemplate.opsForValue().set(cacheSign, "1", cacheTime, TimeUnit.SECONDS);
            //User的数据放入redis中
            List<User> users = userMapper.findAll();
            for (User user : users) {
                //添加一个随机过期时间防止雪崩
                int keyCacheTime = cacheTime + new Random().nextInt(cacheTime);
                redisTemplate.opsForValue().set(PREFIX + user.getId(), user,
                        keyCacheTime, TimeUnit.SECONDS);
            }
            return users;
        }
    }

    /**
     * 先去缓存中拿一下，如果没有去数据库查
     * ----------对于没有的或者说没查到的也缓存一下防止穿透
     *
     * @param id
     * @return
     */
    @Override
    public User getUserById(Integer id) {
        String cacheKey = PREFIX + id;
        User user = (User) redisTemplate.opsForValue().get(cacheKey);
        if (user != null) {
            log.info("UserServiceImpl.getUserById,从缓存中获取:{}", id);
            return user;
        } else {
            log.info("UserServiceImpl.getUserById，从数据库中查询:{}", id);
            user = userMapper.getUserById(id);
            //缓存到redis
            redisTemplate.opsForValue().set(cacheKey, user != null ? user : new User(), user != null ? 300 : 600, TimeUnit.SECONDS);
            return user;
        }
    }
}
