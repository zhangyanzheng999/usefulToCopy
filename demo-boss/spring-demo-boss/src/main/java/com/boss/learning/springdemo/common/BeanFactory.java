package com.boss.learning.springdemo.common;

import com.boss.learning.springdemo.service.UserService;

/**
 * @description:
 * @author:zyz
 * @time:2020/6/2--19:59
 */
public class BeanFactory {
    private static UserService userService;

    static {
        try {
            userService = (UserService) Class.forName("com.boss.learning.springdemo.service.UserService").newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static UserService getUserService() {

        return userService;
    }
}
