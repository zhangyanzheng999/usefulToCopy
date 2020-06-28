package com.bosssoft.hr.train.spring;

import com.bosssoft.hr.train.spring.service.impl.UserServiceImplPrototype;
import com.bosssoft.hr.train.spring.service.impl.UserServiceImplSingleton;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @description:
 * @author:zyz
 * @time:2020/6/4--16:38
 */
@Slf4j
public class App {
    private AnnotationConfigApplicationContext annotationConfigApplicationContext;

    public App() {
        annotationConfigApplicationContext = new AnnotationConfigApplicationContext("com.bosssoft.hr.train.spring");
    }


    public void testSingleton() {
        for (int i = 0; i < 3; i++) {
            log.info("第{}次获取单实例Bean的地址为{}", i, annotationConfigApplicationContext.getBean(UserServiceImplSingleton.class));
        }
    }


    public void testPrototype() {
        for (int i = 0; i < 3; i++) {
            log.info("第{}次获取多实例Bean的地址为{}", i, annotationConfigApplicationContext.getBean(UserServiceImplPrototype.class));
        }
    }
}
