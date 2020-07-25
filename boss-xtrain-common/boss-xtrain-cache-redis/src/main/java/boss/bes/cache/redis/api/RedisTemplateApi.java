package boss.bes.cache.redis.api;

import org.springframework.data.domain.Sort;
import org.springframework.data.geo.Distance;
import org.springframework.data.geo.GeoResults;
import org.springframework.data.geo.Point;
import org.springframework.data.redis.connection.RedisGeoCommands;
import org.springframework.data.redis.core.ZSetOperations;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @class RedisTemplateApi
 * @classdesc 服务对外的接口保持稳定，调用者可以是API网关也可以其他的系统
 * @author 于海源
 * @date 2020-6-30  22:39
 * @version 1.0.0
 */
public interface RedisTemplateApi {
    /**
     * 尝试获取分布式锁
     * @param key 锁
     * @param id 请求标识
     * @param expireTime 超期时间
     * @return 是否获取成功
     */
    boolean lock(String key, String id, int expireTime) ;
    /**
     * 释放分布式锁
     * @param key 锁
     * @param id 请求标识
     * @return 是否释放成功
     */
    boolean release(String key, String id);
    /**
     * 指定缓存失效时间
     * @param key 键
     * @param time 时间(秒)
     * @return
     */
    boolean expire(String key,long time);

    /**
     * 根据key 获取过期时间
     * @param key 键 不能为null
     * @return 时间(秒) 返回0代表为永久有效
     */
    long getExpire(String key);

    /**
     * 判断key是否存在
     * @param key 键
     * @return true 存在 false不存在
     */
    boolean hasKey(String key);

    /**
     * 删除缓存
     * @param key 可以传一个值 或多个
     */
    @SuppressWarnings("unchecked")
    void del(String ... key);

    //============================String=============================
    /**
     * 普通缓存获取
     * @param key 键
     * @return 值
     */
    Object get(String key);

    /**
     * 普通缓存放入
     * @param key 键
     * @param value 值
     * @return true成功 false失败
     */
    boolean set(String key,Object value) ;

    /**
     * 普通缓存放入并设置时间
     * @param key 键
     * @param value 值
     * @param time 时间(秒) time要大于0 如果time小于等于0 将设置无限期
     * @return true成功 false 失败
     */
    boolean set(String key,Object value,long time);

    /**
     * 递增
     * @param key 键
     * @param delta 要增加几(大于0)
     * @return
     */
    long incr(String key, long delta);
    /**
     * 递减
     * @param key 键
     * @param delta 要减少几(小于0)
     * @return
     */
    long decr(String key, long delta);

    //================================Map=================================
    /**
     * HashGet
     * @param key 键 不能为null
     * @param item 项 不能为null
     * @return 值
     */
    Object hget(String key,String item);

    /**
     * 获取hashKey对应的所有键值
     * @param key 键
     * @return 对应的多个键值
     */
    Map<Object,Object> hmget(String key);

    /**
     * HashSet
     * @param key 键
     * @param map 对应多个键值
     * @return true 成功 false 失败
     */
    boolean hmset(String key, Map<String,Object> map);

    /**
     * HashSet 并设置时间
     * @param key 键
     * @param map 对应多个键值
     * @param time 时间(秒)
     * @return true成功 false失败
     */
    boolean hmset(String key, Map<String,Object> map, long time);

    /**
     * 向一张hash表中放入数据,如果不存在将创建
     * @param key 键
     * @param item 项
     * @param value 值
     * @return true 成功 false失败
     */
    boolean hset(String key,String item,Object value);

    /**
     * 向一张hash表中放入数据,如果不存在将创建
     * @param key 键
     * @param item 项
     * @param value 值
     * @param time 时间(秒)  注意:如果已存在的hash表有时间,这里将会替换原有的时间
     * @return true 成功 false失败
     */
    boolean hset(String key,String item,Object value,long time) ;

    /**
     * 删除hash表中的值
     * @param key 键 不能为null
     * @param item 项 可以使多个 不能为null
     */
    void hdel(String key, Object... item);

    /**
     * 判断hash表中是否有该项的值
     * @param key 键 不能为null
     * @param item 项 不能为null
     * @return true 存在 false不存在
     */
    boolean hHasKey(String key, String item);

    /**
     * hash递增 如果不存在,就会创建一个 并把新增后的值返回
     * @param key 键
     * @param item 项
     * @param by 要增加几(大于0)
     * @return
     */
    double hincr(String key, String item,double by);

    /**
     * hash递减
     * @param key 键
     * @param item 项
     * @param by 要减少记(小于0)
     * @return
     */
    double hdecr(String key, String item,double by);

    //============================set=============================
    /**
     * 根据key获取Set中的所有值
     * @param key 键
     * @return
     */
    Set<Object> sGet(String key);

    /**
     * 根据value从一个set中查询,是否存在
     * @param key 键
     * @param value 值
     * @return true 存在 false不存在
     */
    boolean sHasKey(String key,Object value);

    /**
     * 将数据放入set缓存
     * @param key 键
     * @param values 值 可以是多个
     * @return 成功个数
     */
    long sSet(String key, Object...values);

    /**
     * 将set数据放入缓存
     * @param key 键
     * @param time 时间(秒)
     * @param values 值 可以是多个
     * @return 成功个数
     */
    long sSetAndTime(String key,long time,Object...values) ;

    /**
     * 获取set缓存的长度
     * @param key 键
     * @return
     */
    long sGetSetSize(String key);

    /**
     * 移除值为value的
     * @param key 键
     * @param values 值 可以是多个
     * @return 移除的个数
     */
    long setRemove(String key, Object ...values);
    //===============================list=================================

    /**
     * 获取list缓存的内容
     * @param key 键
     * @param start 开始
     * @param end 结束  0 到 -1代表所有值
     * @return
     */
    List<Object> lGet(String key, long start, long end);

    /**
     * 获取list缓存的长度
     * @param key 键
     * @return
     */
    long lGetListSize(String key);
    /**
     * 通过索引 获取list中的值
     * @param key 键
     * @param index 索引  index>=0时， 0 表头，1 第二个元素，依次类推；index<0时，-1，表尾，-2倒数第二个元素，依次类推
     * @return
     */
    Object lGetIndex(String key,long index);

    /**
     * 将list放入缓存
     * @param key
     * @param value
     * @return
     */
    boolean lSet(String key, Object value);

    /**
     * 将list放入缓存
     * @param key 键
     * @param value 值
     * @param time 时间(秒)
     * @return
     */
    boolean lSet(String key, Object value, long time);

    /**
     * 将list放入缓存
     * @param key 键
     * @param value 值
     * @return
     */
    boolean lSet(String key, List<Object> value);

    /**
     * 将list放入缓存
     * @param key 键
     * @param value 值
     * @param time 时间(秒)
     * @return
     */
    boolean lSet(String key, List<Object> value, long time);

    /**
     * 根据索引修改list中的某条数据
     * @param key 键
     * @param index 索引
     * @param value 值
     * @return
     */
    boolean lUpdateIndex(String key, long index,Object value);

    /**
     * 移除N个值为value
     * @param key 键
     * @param count 移除多少个
     * @param value 值
     * @return 移除的个数
     */
    long lRemove(String key,long count,Object value);


    /**
     * 添加 ZSet 元素
     *
     * @param key
     * @param value
     * @param score
     */
    boolean add(String key, Object value, double score) ;

    /**
     * 批量添加 Zset
     * Set<TypedTuple<Object>> tuples = new HashSet<>()
     * TypedTuple<Object> objectTypedTuple1 = new DefaultTypedTuple<Object>("zset-5",9.6);
     * tuples.add(objectTypedTuple1);
     *
     * @param key
     * @param tuples
     * @return
     */
    Long batchAddZset(String key,Set<ZSetOperations.TypedTuple<Object>> tuples);

    /**
     * Zset 删除一个或多个元素
     *
     * @param key
     * @param values
     * @return
     */
    Long removeZset(String key, String... values);

    /**
     * 对指定的 zset 的 value 值 , socre 属性做增减操作
     *
     * @param key
     * @param value
     * @param score
     * @return
     */
     Double incrementScore(String key, Object value, double score);

    /**
     * 获取 key 中指定 value 的排名(从0开始,从小到大排序)
     *
     * @param key
     * @param value
     * @return
     */
    Long rank(String key, Object value);

    /**
     * 获取 key 中指定 value 的排名(从0开始,从大到小排序)
     *
     * @param key
     * @param value
     * @return
     */
    Long reverseRank(String key, Object value);

    /**
     * 获取索引区间内的排序结果集合(从0开始,从小到大,带上分数)
     *
     * @param key
     * @param start
     * @param end
     * @return
     */
    Set<ZSetOperations.TypedTuple<Object>> rangeWithScores(String key, long start, long end);

    /**
     * 获取索引区间内的排序结果集合(从0开始,从小到大,只有列名)
     *
     * @param key
     * @param start
     * @param end
     * @return
     */
    Set<Object> range(String key, long start, long end) ;

    /**
     * 获取分数范围内的 [min,max] 的排序结果集合 (从小到大,只有列名)
     *
     * @param key
     * @param min
     * @param max
     * @return
     */
    Set<Object> rangeByScore(String key, double min, double max);

    /**
     * 获取分数范围内的 [min,max] 的排序结果集合 (从小到大,集合带分数)
     *
     * @param key
     * @param min
     * @param max
     * @return
     */
    Set<ZSetOperations.TypedTuple<Object>> rangeByScoreWithScores(String key, double min, double max) ;

    /**
     * 返回 分数范围内 指定 count 数量的元素集合, 并且从 offset 下标开始(从小到大,不带分数的集合)
     *
     * @param key
     * @param min
     * @param max
     * @param offset 从指定下标开始
     * @param count  输出指定元素数量
     * @return
     */
    Set<Object> rangeByScore(String key, double min, double max, long offset, long count) ;

    /**
     * 返回 分数范围内 指定 count 数量的元素集合, 并且从 offset 下标开始(从小到大,带分数的集合)
     *
     * @param key
     * @param min
     * @param max
     * @param offset 从指定下标开始
     * @param count  输出指定元素数量
     * @return
     */
    Set<ZSetOperations.TypedTuple<Object>> rangeByScoreWithScores(String key, double min, double max, long offset, long count);

    /**
     * 获取索引区间内的排序结果集合(从0开始,从大到小,只有列名)
     *
     * @param key
     * @param start
     * @param end
     * @return
     */
    Set<Object> reverseRange(String key, long start, long end) ;

    /**
     * 获取索引区间内的排序结果集合(从0开始,从大到小,带上分数)
     *
     * @param key
     * @param start
     * @param end
     * @return
     */
    Set<ZSetOperations.TypedTuple<Object>> reverseRangeWithScores(String key, long start, long end) ;

    /**
     * 获取分数范围内的 [min,max] 的排序结果集合 (从大到小,集合不带分数)
     *
     * @param key
     * @param min
     * @param max
     * @return
     */
    Set<Object> reverseRangeByScore(String key, double min, double max);

    /**
     * 获取分数范围内的 [min,max] 的排序结果集合 (从大到小,集合带分数)
     *
     * @param key
     * @param min
     * @param max
     * @return
     */
    Set<ZSetOperations.TypedTuple<Object>> reverseRangeByScoreWithScores(String key, double min, double max) ;

    /**
     * 返回 分数范围内 指定 count 数量的元素集合, 并且从 offset 下标开始(从大到小,不带分数的集合)
     *
     * @param key
     * @param min
     * @param max
     * @param offset 从指定下标开始
     * @param count  输出指定元素数量
     * @return
     */
    Set<Object> reverseRangeByScore(String key, double min, double max, long offset, long count);

    /**
     * 返回 分数范围内 指定 count 数量的元素集合, 并且从 offset 下标开始(从大到小,带分数的集合)
     *
     * @param key
     * @param min
     * @param max
     * @param offset 从指定下标开始
     * @param count  输出指定元素数量
     * @return
     */
    Set<ZSetOperations.TypedTuple<Object>> reverseRangeByScoreWithScores(String key, double min, double max, long offset, long count);
    /**
     * 返回指定分数区间 [min,max] 的元素个数
     *
     * @param key
     * @param min
     * @param max
     * @return
     */
    long countZSet(String key, double min, double max) ;
    /**
     * 返回 zset 集合数量
     *
     * @param key
     * @return
     */
    long sizeZset(String key);

    /**
     * 获取指定成员的 score 值
     *
     * @param key
     * @param value
     * @return
     */
    Double score(String key, Object value) ;

    /**
     * 删除指定索引位置的成员,其中成员分数按( 从小到大 )
     *
     * @param key
     * @param start
     * @param end
     * @return
     */
    Long removeRange(String key, long start, long end);

    /**
     * 删除指定 分数范围 内的成员 [main,max],其中成员分数按( 从小到大 )
     *
     * @param key
     * @param min
     * @param max
     * @return
     */
    Long removeRangeByScore(String key, double min, double max);

    /**
     * key 和 other 两个集合的并集,保存在 destKey 集合中, 列名相同的 score 相加
     *
     * @param key
     * @param otherKey
     * @param destKey
     * @return
     */
    Long unionAndStoreZset(String key, String otherKey, String destKey) ;

    /**
     * key 和 otherKeys 多个集合的并集,保存在 destKey 集合中, 列名相同的 score 相加
     *
     * @param key
     * @param otherKeys
     * @param destKey
     * @return
     */
    Long unionAndStoreZset(String key, Collection<String> otherKeys, String destKey);

    /**
     * key 和 otherKey 两个集合的交集,保存在 destKey 集合中
     *
     * @param key
     * @param otherKey
     * @param destKey
     * @return
     */
    Long intersectAndStore(String key, String otherKey, String destKey);
    /**
     * key 和 otherKeys 多个集合的交集,保存在 destKey 集合中
     *
     * @param key
     * @param otherKeys
     * @param destKey
     * @return
     */
    Long intersectAndStore(String key, Collection<String> otherKeys, String destKey);


    /////////////////扩展-经纬度////////////////////////

    /**
     * 增加经纬度
     * @param key
     * @param x
     * @param y
     * @param member 元素名
     * @return
     */
    boolean addGeo(String key, double x, double y, String member) ;
    /**
     * 批量添加经纬度
     * @param key
     * @param locations
     */
    void addGeoAll(String key, Iterable<RedisGeoCommands.GeoLocation<String>> locations);
    /**
     * 删除经纬度
     * @param key
     * @param members
     * @return
     */
    Long removeGeo(String key, String...members) ;

    /**
     * 两点经纬度之间的距离
     * @param key
     * @param member1
     * @param member2
     * @return
     */
    Distance distanceGeo(String key, String member1, String member2);

    /**
     * 根据key和members获取这些经纬信息
     * @param key
     * @param members
     * @return
     */
    List<Point> getGeo(String key, String...members);
    /**
     * 按照经纬度和半径 取得相应的数据
     * @param key
     * @param x
     * @param y
     * @param distance 半径 单位：m米
     * @param direction 远到近/近到远 排序 ASC/DESC
     * @param limit 取多少个数据
     * @return
     */
    GeoResults<RedisGeoCommands.GeoLocation<Object>> radiusGeo(String key, double x, double y, double distance, Sort.Direction direction, long limit);


}
