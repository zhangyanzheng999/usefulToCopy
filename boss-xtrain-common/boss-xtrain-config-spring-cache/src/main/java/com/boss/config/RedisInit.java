package com.boss.config;

import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

/**
 * <p>导入redis配置的注解</p>
 *
 * @author : gln
 * @version 1.0
 * @date : 2020-07-01 21:30
 **/
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Target({ElementType.TYPE})
@Import(RedisConfig.class)
public @interface RedisInit {
}
