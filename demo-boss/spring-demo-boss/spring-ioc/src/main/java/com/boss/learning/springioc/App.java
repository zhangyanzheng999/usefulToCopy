package com.boss.learning.springioc;

import com.boss.learning.springioc.bean.User;
import com.boss.learning.springioc.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;

/**
 * @description:
 * @author:zyz
 * @time:2020/6/2--19:45
 */
public class App {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext("com.boss.learning.springioc");
        for(int i=0;i<3;i++){
            UserService userService = applicationContext.getBean(UserService.class);
            System.out.println(userService);
            User user = new User();
            user.setName("ggs");
            userService.saveUser(user);
        }
        applicationContext.close();
    }
}
