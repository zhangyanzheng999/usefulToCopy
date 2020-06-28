package com.bosssoft.hr.train.spring;

import com.bosssoft.hr.train.spring.service.impl.UserServiceImplWithXml;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;

/**
 * @description:
 * @author:zyz
 * @time:2020/6/4--15:13
 */
@Slf4j
public class App {
    private static final String PATH = "applicationContext.xml";

    /**
     * 测试BeanFactory
     */
    public void testByBeanFactory() {
        BeanFactory beanFactory = new XmlBeanFactory(new ClassPathResource(PATH));
        log.info("beanFactory创建了");
        log.info("准备执行userService");
        UserServiceImplWithXml userService = beanFactory.getBean(UserServiceImplWithXml.class);
        log.info("userService:{}", userService);

    }

    /**
     * 测试ClassPathXmlApplicationContext
     */
    public void testByClassPathXmlApplicationContext() {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext(PATH);
        log.info("applicationContext创建了");


        applicationContext.close();
        log.info("applicationContext关闭了");
    }

}
