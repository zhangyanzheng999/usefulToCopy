package boss.bes.cache.redis.api.impl;

import boss.bes.cache.redis.api.RedisTemplateApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.geo.Circle;
import org.springframework.data.geo.Distance;
import org.springframework.data.geo.GeoResults;
import org.springframework.data.geo.Point;
import org.springframework.data.redis.connection.RedisGeoCommands;
import org.springframework.data.redis.core.GeoOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ZSetOperations;
import org.springframework.data.redis.core.script.DefaultRedisScript;
import org.springframework.data.redis.core.script.RedisScript;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.util.*;
import java.util.concurrent.TimeUnit;
/**
 * redisTemplate封装
 * opsForValue ：对应 String（字符串）
 * opsForZSet：对应 ZSet（有序集合）
 * opsForHash：对应 Hash（哈希）
 * opsForList：对应 List（列表）
 * opsForSet：对应 Set（集合）
 * opsForGeo：对应 GEO（地理位置）
 * @class RedisTemplateApiImpl
 * @classdesc RedisTemplateApi实现类
 * @author 于海源
 * @date 2020-6-30  22:39
 * @version 1.0.0
 */

@Component
public class RedisTemplateApiImpl implements RedisTemplateApi {
    @Autowired
    private RedisTemplate<String,Object> redisTemplate;
    private static final Long LOCK_SUCCESS = 1L;
    // 使用lua脚本来保证原子性操作
    private static final String SCRIPT = "if redis.call('get',KEYS[1]) == ARGV[1] then return redis.call('del',KEYS[1]) else return 0 end";

    public RedisTemplateApiImpl(RedisTemplate<String, Object> redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    @Override
    public boolean lock(String key, String id, int expireTime){
        //保证获取锁和设置过期时间为原子操作
        return redisTemplate.opsForValue().setIfAbsent(key,id,expireTime, TimeUnit.SECONDS);
    }

    @Override
    public boolean release(String key, String id) {
        RedisScript<String> redisScript = new DefaultRedisScript<>(SCRIPT, String.class);
        Object result = redisTemplate.execute(redisScript, Collections.singletonList(key),Collections.singletonList(id));
        return LOCK_SUCCESS.equals(result);
    }

    @Override
    public boolean expire(String key, long time){
        if(time > 0){
            redisTemplate.expire(key,time, TimeUnit.SECONDS);
        }
        return true;
    }

    @Override
    public long getExpire(String key){
        return redisTemplate.getExpire(key,TimeUnit.SECONDS);
    }

    @Override
    public boolean hasKey(String key){
        return redisTemplate.hasKey(key);
    }

    @Override
    public void del(String... key) {
        if(key!=null&&key.length>0){
            if(key.length==1){
                redisTemplate.delete(key[0]);
            }else{
                redisTemplate.delete(CollectionUtils.arrayToList(key));
            }
        }
    }

    @Override
    public Object get(String key) {
        return key==null?null:redisTemplate.opsForValue().get(key);
    }

    @Override
    public boolean set(String key, Object value){
        redisTemplate.opsForValue().set(key,value);
        return true;
    }

    @Override
    public boolean set(String key, Object value, long time){
        if(time>0){
            redisTemplate.opsForValue().set(key, value, time, TimeUnit.SECONDS);
        }else{
            set(key, value);
        }
        return true;
    }

    @Override
    public long incr(String key, long delta) {
        return redisTemplate.opsForValue().increment(key, delta);
    }

    @Override
    public long decr(String key, long delta) {
        return redisTemplate.opsForValue().increment(key, -delta);
    }

    @Override
    public Object hget(String key, String item) {
        return redisTemplate.opsForHash().get(key, item);
    }

    @Override
    public Map<Object, Object> hmget(String key) {
        return redisTemplate.opsForHash().entries(key);
    }

    @Override
    public boolean hmset(String key, Map<String, Object> map){
        redisTemplate.opsForHash().putAll(key, map);
        return true;
    }

    @Override
    public boolean hmset(String key, Map<String, Object> map, long time){
        redisTemplate.opsForHash().putAll(key, map);
        if(time>0){
            expire(key, time);
        }
        return true;
    }

    @Override
    public boolean hset(String key, String item, Object value){
        redisTemplate.opsForHash().put(key, item, value);
        return true;
    }

    @Override
    public boolean hset(String key, String item, Object value, long time){
        redisTemplate.opsForHash().put(key, item, value);
        if(time>0){
            expire(key, time);
        }
        return true;
    }

    @Override
    public void hdel(String key, Object... item) {
        redisTemplate.opsForHash().delete(key,item);
    }

    @Override
    public boolean hHasKey(String key, String item) {
        return redisTemplate.opsForHash().hasKey(key, item);
    }

    @Override
    public double hincr(String key, String item, double by) {
        return redisTemplate.opsForHash().increment(key, item, by);
    }

    @Override
    public double hdecr(String key, String item, double by) {
        return redisTemplate.opsForHash().increment(key, item,-by);
    }

    @Override
    public Set<Object> sGet(String key){
        return redisTemplate.opsForSet().members(key);
    }

    @Override
    public boolean sHasKey(String key, Object value){
        return redisTemplate.opsForSet().isMember(key, value);
    }

    @Override
    public long sSet(String key, Object... values){
        return redisTemplate.opsForSet().add(key, values);
    }

    @Override
    public long sSetAndTime(String key, long time, Object... values){
        Long count = redisTemplate.opsForSet().add(key, values);
        if(time>0) {
            expire(key, time);
        }
        return count;
    }

    @Override
    public long sGetSetSize(String key){
        return redisTemplate.opsForSet().size(key);
    }

    @Override
    public long setRemove(String key, Object... values){
        return redisTemplate.opsForSet().remove(key, values);
    }

    @Override
    public List<Object> lGet(String key, long start, long end){
        return redisTemplate.opsForList().range(key, start, end);
    }

    @Override
    public long lGetListSize(String key) {
        return redisTemplate.opsForList().size(key);
    }

    @Override
    public Object lGetIndex(String key, long index) {
        return redisTemplate.opsForList().index(key, index);
    }

    @Override
    public boolean lSet(String key, Object value){
        redisTemplate.opsForList().rightPush(key, value);
        return true;
    }

    @Override
    public boolean lSet(String key, Object value, long time) {
        redisTemplate.opsForList().rightPush(key, value);
        if (time > 0) {
            expire(key, time);
        }
        return true;
    }

    @Override
    public boolean lSet(String key, List<Object> value){
        redisTemplate.opsForList().rightPushAll(key, value);
        return true;
    }

    @Override
    public boolean lSet(String key, List<Object> value, long time){
        redisTemplate.opsForList().rightPushAll(key, value);
        if (time > 0) {
            expire(key, time);
        }
        return true;
    }

    @Override
    public boolean lUpdateIndex(String key, long index, Object value){
        redisTemplate.opsForList().set(key, index, value);
        return true;
    }

    @Override
    public long lRemove(String key, long count, Object value){
        return redisTemplate.opsForList().remove(key, count, value);
    }

    @Override
    public boolean add(String key, Object value, double score) {
        return redisTemplate.opsForZSet().add(key, value, score);
    }

    @Override
    public Long batchAddZset(String key, Set<ZSetOperations.TypedTuple<Object>> tuples) {
        return redisTemplate.opsForZSet().add(key, tuples);
    }

    @Override
    public Long removeZset(String key, String... values) {
        return redisTemplate.opsForZSet().remove(key, values);
    }

    @Override
    public Double incrementScore(String key, Object value, double score) {
        return redisTemplate.opsForZSet().incrementScore(key, value, score);
    }

    @Override
    public Long rank(String key, Object value) {
        return redisTemplate.opsForZSet().rank(key, value);
    }

    @Override
    public Long reverseRank(String key, Object value) {
        return redisTemplate.opsForZSet().reverseRank(key, value);
    }

    @Override
    public Set<ZSetOperations.TypedTuple<Object>> rangeWithScores(String key, long start, long end) {
        return redisTemplate.opsForZSet().rangeWithScores(key, start, end);
    }

    @Override
    public Set<Object> range(String key, long start, long end) {
        return redisTemplate.opsForZSet().range(key, start, end);
    }

    @Override
    public Set<Object> rangeByScore(String key, double min, double max) {
        return redisTemplate.opsForZSet().rangeByScore(key, min, max);
    }

    @Override
    public Set<ZSetOperations.TypedTuple<Object>> rangeByScoreWithScores(String key, double min, double max) {
        return redisTemplate.opsForZSet().rangeByScoreWithScores(key, min, max);
    }

    @Override
    public Set<Object> rangeByScore(String key, double min, double max, long offset, long count) {
        return redisTemplate.opsForZSet().rangeByScore(key, min, max, offset, count);
    }

    @Override
    public Set<ZSetOperations.TypedTuple<Object>> rangeByScoreWithScores(String key, double min, double max, long offset, long count) {
        return redisTemplate.opsForZSet().rangeByScoreWithScores(key, min, max, offset, count);
    }

    @Override
    public Set<Object> reverseRange(String key, long start, long end) {
        return redisTemplate.opsForZSet().reverseRange(key, start, end);
    }

    @Override
    public Set<ZSetOperations.TypedTuple<Object>> reverseRangeWithScores(String key, long start, long end) {
        return redisTemplate.opsForZSet().reverseRangeWithScores(key, start, end);
    }

    @Override
    public Set<Object> reverseRangeByScore(String key, double min, double max) {
        return redisTemplate.opsForZSet().reverseRangeByScore(key, min, max);
    }

    @Override
    public Set<ZSetOperations.TypedTuple<Object>> reverseRangeByScoreWithScores(String key, double min, double max) {
        return redisTemplate.opsForZSet().reverseRangeByScoreWithScores(key, min, max);
    }

    @Override
    public Set<Object> reverseRangeByScore(String key, double min, double max, long offset, long count) {
        return redisTemplate.opsForZSet().reverseRangeByScore(key, min, max, offset, count);
    }

    @Override
    public Set<ZSetOperations.TypedTuple<Object>> reverseRangeByScoreWithScores(String key, double min, double max, long offset, long count) {
        return redisTemplate.opsForZSet().reverseRangeByScoreWithScores(key, min, max, offset, count);
    }

    @Override
    public long countZSet(String key, double min, double max) {
        return redisTemplate.opsForZSet().count(key, min, max);
    }

    @Override
    public long sizeZset(String key) {
        return redisTemplate.opsForZSet().size(key);
    }

    @Override
    public Double score(String key, Object value) {
        return redisTemplate.opsForZSet().score(key, value);
    }

    @Override
    public Long removeRange(String key, long start, long end) {
        return redisTemplate.opsForZSet().removeRange(key, start, end);
    }

    @Override
    public Long removeRangeByScore(String key, double min, double max) {
        return redisTemplate.opsForZSet().removeRangeByScore(key, min, max);
    }

    @Override
    public Long unionAndStoreZset(String key, String otherKey, String destKey) {
        return redisTemplate.opsForZSet().unionAndStore(key, otherKey, destKey);
    }

    @Override
    public Long unionAndStoreZset(String key, Collection<String> otherKeys, String destKey) {
        return redisTemplate.opsForZSet().unionAndStore(key, otherKeys, destKey);
    }

    @Override
    public Long intersectAndStore(String key, String otherKey, String destKey) {
        return redisTemplate.opsForZSet().intersectAndStore(key, otherKey, destKey);
    }

    @Override
    public Long intersectAndStore(String key, Collection<String> otherKeys, String destKey) {
        return redisTemplate.opsForZSet().intersectAndStore(key, otherKeys, destKey);
    }

    @Override
    public boolean addGeo(String key, double x, double y, String member) {
        GeoOperations<String,Object> geoOps = redisTemplate.opsForGeo();
        return 1 == geoOps.add(key, new Point(x, y), member);
    }

    @Override
    public void addGeoAll(String key, Iterable<RedisGeoCommands.GeoLocation<String>> locations) {
        for (RedisGeoCommands.GeoLocation<String> location : locations) {
            addGeo(key, location.getPoint().getX(), location.getPoint().getY(), location.getName());
        }
    }

    @Override
    public Long removeGeo(String key, String... members) {
        GeoOperations<String,Object> geoOps = redisTemplate.opsForGeo();
        return geoOps.remove(key, members);
    }

    @Override
    public Distance distanceGeo(String key, String member1, String member2) {
        GeoOperations<String,Object> geoOps = redisTemplate.opsForGeo();
        return geoOps.distance(key, member1, member2);
    }

    @Override
    public List<Point> getGeo(String key, String... members) {
        GeoOperations<String,Object> geoOps = redisTemplate.opsForGeo();
        return geoOps.position(key, members);
    }

    @Override
    public GeoResults<RedisGeoCommands.GeoLocation<Object>> radiusGeo(String key, double x, double y, double distance, Sort.Direction direction, long limit) {
        GeoOperations<String,Object> geoOps = redisTemplate.opsForGeo();
        //设置geo查询参数
        RedisGeoCommands.GeoRadiusCommandArgs geoRadiusArgs = RedisGeoCommands.GeoRadiusCommandArgs.newGeoRadiusArgs();
        geoRadiusArgs = geoRadiusArgs.includeCoordinates().includeDistance();//查询返回结果包括距离和坐标
        if (Sort.Direction.ASC.equals(direction)) {//按查询出的坐标距离中心坐标的距离进行排序
            geoRadiusArgs.sortAscending();
        } else if (Sort.Direction.DESC.equals(direction)) {
            geoRadiusArgs.sortDescending();
        }
        geoRadiusArgs.limit(limit);//限制查询数量
        return geoOps.radius(key, new Circle(new Point(x, y), new Distance(distance, RedisGeoCommands.DistanceUnit.METERS)), geoRadiusArgs);
    }
}
