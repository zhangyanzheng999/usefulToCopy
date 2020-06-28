package com.bosssoft.hr.train.jsp.example.listener;

import com.bosssoft.hr.train.jsp.example.exception.BusinessException;
import com.mysql.jdbc.AbandonedConnectionCleanupThread;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Enumeration;

/**
 * @description: 解决 have started a thread named [Abandoned connection cleanup thread]
 * but has failed to stop it.
 * This is very likely to create a memory leak. Stack trace of thread:
 * @author:zyz
 * @time:2020/5/31--19:54
 */
public class AllDriversListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        // Do nothing because don't use
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        //这里如果Web应用拥有多个数据库的连接，可以一并关闭
        Enumeration<Driver> drivers = DriverManager.getDrivers();
        Driver driver = null;
        while (drivers.hasMoreElements()) {
            try {
                driver = drivers.nextElement();
                DriverManager.deregisterDriver(driver);
            } catch (SQLException ex) {
                throw new BusinessException("10001", "驱动关闭异常", ex);
            }
        }
        AbandonedConnectionCleanupThread.checkedShutdown();
    }
}
