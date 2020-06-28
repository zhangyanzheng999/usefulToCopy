package com.bosssoft.hr.train.service.impl;

import com.bosssoft.hr.train.bean.DataDictionary;
import com.bosssoft.hr.train.dao.DataMapper;
import com.bosssoft.hr.train.service.DDService;
import com.github.pagehelper.PageInfo;
import com.github.pagehelper.page.PageMethod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.*;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;


/**
 * @description:
 * @author:zyz
 * @time:2020/6/14-21:30
 */
@Service
@CacheConfig(cacheNames = "ddo")
public class DDServiceImpl implements DDService {
    @Autowired
    DataMapper dataMapper;

    @Autowired
    RedisTemplate<String, Object> redisTemplate;

    @Override
    @Cacheable(key = "#id")
    public DataDictionary getDDById(Integer id) {

        return dataMapper.findById(id);
    }

    @Override
    @Cacheable(key = "#pageNum+','+#pageSize+'_page'")
    public PageInfo<DataDictionary> queryDDWithPage(Integer pageNum, Integer pageSize) {
        PageMethod.startPage(pageNum, pageSize);
        List<DataDictionary> dataDictionaries = dataMapper.queryDds();
        String cacheKey;
        for (DataDictionary dataDictionary : dataDictionaries) {
            cacheKey = "ddo::" + dataDictionary.getDdId();
            if (redisTemplate.opsForValue().get(cacheKey) == null) {
                redisTemplate.opsForValue().set(cacheKey, dataDictionary, 900, TimeUnit.SECONDS);
            }
        }
        return new PageInfo<>(dataDictionaries, 1);
    }

    @Override
    @CachePut(key = "#a0.ddId")
    public DataDictionary update(DataDictionary dataDictionary) {
        if (dataMapper.updateDD(dataDictionary) > 0) {
            deleteCache();
            return dataDictionary;
        } else {
            return new DataDictionary();
        }
    }

    @Override
    @Caching(evict = {
            @CacheEvict(key = "#id")
    })
    public Integer deleteById(Integer id) {
        deleteCache();
        return dataMapper.deleteById(id);
    }

    @Override
    @CachePut(key = "#result.ddId")
    public DataDictionary insert(DataDictionary dataDictionary) {
        deleteCache();
        dataMapper.insertDD(dataDictionary);
        return dataDictionary;
    }

    /**
     * 删掉分页相关缓存，
     * 因为已经有数据改变了
     * 可以更精确的删
     */
    private void deleteCache(){
        //删掉分页相关的
        Set<String> keys = redisTemplate.keys("*" + "_page");
        redisTemplate.delete(keys);
    }
}
