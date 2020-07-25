package com.boss.config;

import org.springframework.context.annotation.Import;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.lang.annotation.*;

/**
 * <p>导入swagger配置的注解</p>
 *
 * @author : gln
 * @version 1.0
 * @date : 2020-07-01 16:10
 **/
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Target({ElementType.TYPE})
@EnableSwagger2
@Import({SwaggerConfig.class})
public @interface MySwagger {
}
