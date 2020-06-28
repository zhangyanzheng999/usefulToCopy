package com.boss.learning.springlog;

import com.boss.learning.springlog.bean.User;
import com.boss.learning.springlog.service.SysService;
import com.boss.learning.springlog.service.UserService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @description:
 * @author:zyz
 * @time:2020/6/3--19:40
 */
public class App {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");

        UserService userService = applicationContext.getBean(UserService.class);
        SysService sysService = applicationContext.getBean(SysService.class);

        User user = new User();
        user.setName("zz");

        userService.saveUser(user);

        userService.updateUser(user);

        User user2 = userService.getUser();
        System.out.println("user2 = " + user2.getName());

        sysService.getTimeStamp();
    }

}
