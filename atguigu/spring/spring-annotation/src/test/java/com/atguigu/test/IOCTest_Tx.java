package com.atguigu.test;

import com.atguigu.aop.MathCalculator;
import com.atguigu.config.MainConfigOfAOP;
import com.atguigu.tx.TxConfig;
import com.atguigu.tx.UserService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class IOCTest_Tx {


    @Test
    public void test01(){
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(TxConfig.class);
        UserService userService = applicationContext.getBean(UserService.class);
        userService.insertUser();

    }

    public  void printBeans(ApplicationContext applicationContext){
        String[] beanDefinitionNames = applicationContext.getBeanDefinitionNames();
        for (String name:beanDefinitionNames) {
            System.out.println(name);
        }

    }
}
