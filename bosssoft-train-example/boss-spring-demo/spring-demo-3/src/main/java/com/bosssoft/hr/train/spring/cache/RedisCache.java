package com.bosssoft.hr.train.spring.cache;

import org.springframework.cache.Cache;
import org.springframework.cache.support.SimpleValueWrapper;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.RedisTemplate;
import org.apache.commons.lang3.SerializationUtils;

import java.io.Serializable;
import java.util.concurrent.Callable;

/**
 * @description:
 * @author:zyz
 * @time:2020/6/4--23:31
 */
public class RedisCache implements Cache {
    private RedisTemplate<String, Object> redisTemplate;
    private String name;

    /**
     * 清理缓存
     */
    public void clear() {
        redisTemplate.execute(new RedisCallback<String>() {
            public String doInRedis(RedisConnection connection) {
                connection.flushDb();
                return "ok";
            }
        });
    }

    /**
     * 缓存删除
     *
     * @param key
     */
    public void evict(Object key) {
        final String keySrc = key.toString();
        redisTemplate.execute(new RedisCallback<Long>() {
            public Long doInRedis(RedisConnection connection) {
                return connection.del(keySrc.getBytes());
            }
        });
    }

    /**
     * 缓存获取
     *
     * @param key
     * @return
     */
    public ValueWrapper get(Object key) {
        final String srcKey = key.toString();
        Object result = redisTemplate.execute(new RedisCallback<Object>() {
            public Object doInRedis(RedisConnection connection) {
                //局部变量
                byte[] key = srcKey.getBytes();
                byte[] value = connection.get(key);
                if (value == null) {
                    return null;
                }
                return SerializationUtils.deserialize(value);
            }
        });
        // 判断是否是null
        return (result != null ? new SimpleValueWrapper(result) : null);
    }

    /**
     * 加入缓存
     *
     * @param key
     * @param value
     */
    public void put(final Object key, Object value) {
        final String srcKey = key.toString();
        final Object srcValue = value;
        final long liveTime = 86400L;
        redisTemplate.execute(new RedisCallback<Long>() {
            public Long doInRedis(RedisConnection connection) {
                byte[] byteKey = srcKey.getBytes();
                byte[] byteValue = SerializationUtils.serialize((Serializable) srcValue);
                connection.set(byteKey, byteValue);
                if (liveTime > 0) {
                    connection.expire(byteKey, liveTime);
                }
                return 1L;
            }
        });

    }

    public String getName() {
        return this.name;
    }

    public Object getNativeCache() {
        return this.redisTemplate;
    }


    public <T> T get(Object key, Class<T> type) {
        final String finalKey = key.toString();
        final Object value;
        value = redisTemplate.execute(new RedisCallback<Object>() {
            @Override
            public Object doInRedis(RedisConnection connection) throws DataAccessException {
                return connection.get(finalKey.getBytes());
            }
        });
        if (value != null && type != null && !type.isInstance(value)) {
            throw new IllegalStateException(
                    "Cached value is not of required type [" + type.getName() + "]: " + value);
        }
        return (T) value;
    }

    public <T> T get(Object key, Callable<T> valueLoader) {


        ValueWrapper result = get(key);

        if (result != null) {
            return (T) result.get();
        }

        T value = valueFromLoader(key, valueLoader);
        put(key, value);
        return value;
    }

    private static <T> T valueFromLoader(Object key, Callable<T> valueLoader) {

        try {
            return valueLoader.call();
        } catch (Exception e) {
            throw new ValueRetrievalException(key, valueLoader, e);
        }
    }

    public void setRedisTemplate(RedisTemplate<String, Object> redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    public void setName(String name) {
        this.name = name;
    }
}
