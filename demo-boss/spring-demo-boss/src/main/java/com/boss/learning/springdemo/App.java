package com.boss.learning.springdemo;

import com.boss.learning.springdemo.bean.Student;
import com.boss.learning.springdemo.bean.User;
import com.boss.learning.springdemo.service.ISysService;
import com.boss.learning.springdemo.service.UserService;
import org.junit.Test;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;

import java.util.Arrays;

/**
 * @description:
 * @author:zyz
 * @time:2020/6/2--19:55
 */
public class App {

    public static void main(String[] args) {
      /*  User user = new User();
        user.setName("zhangsan");
        UserService userService = new UserService();
        userService.saveUser(user);*/
 /*       for (int i = 0; i < 5; i++) {
            User user = new User();
            user.setName("zhangsan");
            UserService userService = BeanFactory.getUserService();
            System.out.println(userService);
            userService.saveUser(user);
        }*/


    }

    @Test
    public void beanFactoryDemo() {
        org.springframework.beans.factory.BeanFactory beanFactory = new XmlBeanFactory(new ClassPathResource("applicationContext.xml"));
        UserService userService = (UserService) beanFactory.getBean("userService");
        User user = new User();
        user.setName("zhangsan");
        userService.saveUser(user);

    }

    @Test
    public void applicationContextDemo() {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserService userService = (UserService) context.getBean("userService");
        User user = new User();
        user.setName("zhangsan");
        userService.saveUser(user);
    }

    @Test
    public void applicationContextDemo2() {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        ISysService sysService = (ISysService) context.getBean("sysService");
        System.out.println(sysService.getToken());
    }


    @Test
    public void scopeDemo() {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        for (int i = 0; i < 5; i++) {
            UserService userService = (UserService) context.getBean("userService");
            System.out.println(userService);
        }
        ((ClassPathXmlApplicationContext) context).close();
    }

    @Test
    public void diDemo(){
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        Student student = context.getBean(Student.class);
        System.out.println(student.getName()+"  "+student.getAge()+"  "+ Arrays.toString(student.getAddress()));
    }
}
