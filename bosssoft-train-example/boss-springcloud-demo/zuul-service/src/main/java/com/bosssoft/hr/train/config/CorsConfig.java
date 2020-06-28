package com.bosssoft.hr.train.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @description:解决跨域问题
 * @author:zyz
 * @time:2020/6/14-20:30
 */
@Configuration
public class CorsConfig implements WebMvcConfigurer {


    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedHeaders("*")
                .allowedOrigins("*")
                .allowCredentials(true)
                .maxAge(3600)
                .allowedMethods("GET", "POST", "HEAD", "PUT", "DELETE", "OPTIONS");
    }
}
