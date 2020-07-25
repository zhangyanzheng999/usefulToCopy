package com.boss.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author : gln
 * @version 1.0
 * @description : swagger2配置类
 * @date : 2020-06-30 21:59
 **/
@Configuration
@EnableSwagger2
@ConfigurationProperties(prefix = "swagger")
@Data
public class SwaggerConfig {
    private String title;
    private String description;
    private String version;
    private String name;
    private String url;
    private String email;
    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .pathMapping("/")
                .select()
                // 指明文档包含的包范围（主要配置点）
                .apis(RequestHandlerSelectors.withClassAnnotation(RestController.class))
                .paths(PathSelectors.any())
                .build().apiInfo(new ApiInfoBuilder()
                        .title(title)
                        .description(description)
                        .version(version)
                        // 创建人信息
                        .contact(new Contact(name,url,email))
                        .build());
    }
}

