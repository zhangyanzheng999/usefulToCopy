package com.atguigu.cache;

import com.atguigu.cache.bean.Employee;
import com.atguigu.cache.mapper.EmployeeMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;

@SpringBootTest
class Springboot01CacheApplicationTests {

    @Autowired
    EmployeeMapper employeeMapper;

    @Autowired
    StringRedisTemplate stringRedisTemplate; //操作字符串

    @Autowired
    RedisTemplate redisTemplate; //k-v都是对象的

    @Test
    /**
     * Redis常见的五大数据类型
     * String(字符串)、List(列表)、Set(集合)、ZSet(有序集合)、Hash(散列)
     *  stringRedisTemplate.opsForValue()
     *  stringRedisTemplate.opsForList()
     *  stringRedisTemplate.opsForSet()
     *  stringRedisTemplate.opsForZSet()
     *  stringRedisTemplate.opsForHash()
     */
    public void test01() {
        //stringRedisTemplate.opsForValue().append("msg","hello");
       /* String msg = stringRedisTemplate.opsForValue().get("msg");
        System.out.println(msg);*/
        stringRedisTemplate.opsForList().leftPush("mylist", "1");
        stringRedisTemplate.opsForList().leftPush("mylist", "2");
    }

    @Test
    /**
     * 测试保存对象
     */
    public void test02() {
        Employee emp = employeeMapper.getEmpById(1);
        // 如果保存对象，使用JDK序列化机制，序列化后的数据保存到redis中
        //redisTemplate.opsForValue().set("emp-01", emp);
        // 1.将数据以json的方式保存
         //(1)自己将对象转为json
        //(2)redisTemplate有默认的序列化规则
        redisTemplate.opsForValue().set("emp-02", emp);
    }

    @Test
    void contextLoads() {
        Employee emp = employeeMapper.getEmpById(1);
        System.out.println(emp);
    }

}
