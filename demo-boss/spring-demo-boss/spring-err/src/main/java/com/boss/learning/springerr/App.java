package com.boss.learning.springerr;

import com.boss.learning.springerr.bean.User;
import com.boss.learning.springerr.service.UserService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @description:
 * @author:zyz
 * @time:2020/6/4--14:02
 */
public class App {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserService userService = applicationContext.getBean(UserService.class);

        User user=new User();
        user.setName("张三#1");
        user.setAge(20);
        userService.saveUser(user);
    }
}
