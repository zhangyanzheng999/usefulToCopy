package com.atguigu.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * @description:监听项目的启动和停止
 * @author:zyz
 * @time:2020/5/19--11:26
 */
public class UserListener implements ServletContextListener {
    //监听ServletContext启动初始化
    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        System.out.println("UserListener.contextInitialized");
    }
    //监听ServletContext销毁
    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        System.out.println("UserListener.contextDestroyed");
    }
}
