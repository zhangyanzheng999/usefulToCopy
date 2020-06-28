package com.atguigu.config;

import com.atguigu.Service.BookService;
import com.atguigu.bean.Person;
import org.springframework.context.annotation.*;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

//配置类==配置文件
@Configuration //告诉Spring这是一个配置类

@ComponentScans(value = {
        @ComponentScan(value = "com.atguigu",includeFilters ={
          /*      @ComponentScan.Filter(type= FilterType.ANNOTATION,classes= {Controller.class}),
                @ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE,classes = {BookService.class}),*/
                @ComponentScan.Filter(type = FilterType.CUSTOM,classes = {myTypeFilter.class})
        } ,useDefaultFilters = false)
})
//@ComponentScan value:指定要扫描的包
//excludeFilters=Filter[] 排除
// includeFilters=Filter[] 包含
//FilterType.ANNOTATION 按照注解
//FilterType.ASSIGNABLE_TYPE 按照给定类型
//FilterType.REGEX 正则表达式
//FilterType.CUSTOM自定义规则
public class MainConfig {
    //给IOC容器中注册一个bean;类型为返回值的类型，id默认是方法名作为id
    //value就是id
    @Bean("person")
    public Person person01(){
        return new Person("lisi",20);
    }
}
