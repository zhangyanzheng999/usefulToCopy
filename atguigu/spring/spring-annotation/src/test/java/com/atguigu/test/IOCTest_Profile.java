package com.atguigu.test;

import com.atguigu.bean.Yellow;
import com.atguigu.config.MainConfigOfLifeCycle;
import com.atguigu.config.MainConfigOfProfile;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import javax.sql.DataSource;

public class IOCTest_Profile {

    @Test
    public void test01(){
        //1.创建ioc容器
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        //2.设置需要激活的环境
        applicationContext.getEnvironment().setActiveProfiles("test");
        //3.注册配置类
        applicationContext.register(MainConfigOfProfile.class);
        //4.启动刷新容器
        applicationContext.refresh();


        String[] beanNamesForType = applicationContext.getBeanNamesForType(DataSource.class);
        for(String name:beanNamesForType){
            System.out.println(name);
        }
        Yellow yellow = (Yellow)applicationContext.getBean("yellow");
        System.out.println(yellow);
    }
}
