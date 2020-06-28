package com.atguigu.test;

import com.atguigu.bean.Blue;
import com.atguigu.bean.Person;
import com.atguigu.config.MainConfig;
import com.atguigu.config.MainConfig2;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;

import java.util.Map;

public class IOCTest {
    AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfig2.class);
    @Test
    public void test01(){
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfig.class);
        String[] beanDefinitionNames = applicationContext.getBeanDefinitionNames();
        for(String name:beanDefinitionNames)
            System.out.println(name);
    }

    @Test
    public void test02(){
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfig2.class);
        //String[] beanDefinitionNames = applicationContext.getBeanDefinitionNames();
        System.out.println("ioc容器创建完成");
        Person person = (Person) applicationContext.getBean("person");
        Person person2 = (Person) applicationContext.getBean("person");
        System.out.println(person==person2);
       /* for(String name:beanDefinitionNames)
            System.out.println(name);*/
    }
    @Test
    public void test03(){
        String[] beanNamesForType = applicationContext.getBeanNamesForType(Person.class);
        for(String name:beanNamesForType) System.out.println(name);
        Map<String, Person> persons = applicationContext.getBeansOfType(Person.class);
        System.out.println(persons);

        //获取环境变量
        ConfigurableEnvironment environment = applicationContext.getEnvironment();
        String property = environment.getProperty("os.name");
        System.out.println(property);
    }

    @Test
    public void testImport(){
        printBeans(applicationContext);
        Blue bean = applicationContext.getBean(Blue.class);

        //工厂Bean获取的是调用getObject方法创建的对象
        Object colorFactoryBean = applicationContext.getBean("colorFactoryBean");
        Object colorFactoryBean2 = applicationContext.getBean("colorFactoryBean");
        //
        Object colorFactoryBean3 = applicationContext.getBean("&colorFactoryBean");
        System.out.println("bean的类型:"+colorFactoryBean3.getClass());
        System.out.println("bean的类型:"+colorFactoryBean.getClass());
        System.out.println(colorFactoryBean==colorFactoryBean2);
    }


    private void printBeans(AnnotationConfigApplicationContext applicationContext){
        String[] beanDefinitionNames = applicationContext.getBeanDefinitionNames();
        for(String name:beanDefinitionNames) System.out.println(name);

    }
}
