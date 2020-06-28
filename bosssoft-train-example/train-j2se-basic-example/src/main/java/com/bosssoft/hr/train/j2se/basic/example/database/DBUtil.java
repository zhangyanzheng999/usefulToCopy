package com.bosssoft.hr.train.j2se.basic.example.database;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.*;

/**
 * @description: 我是工具类并且我不喜欢被继承 final 保护了我免于继承，private 保护我被创建
 * @author: Administrator
 * @create: 2020-05-28 20:45
 * @since
 **/
public final class DBUtil {
    private static final Logger log = LoggerFactory.getLogger(DBUtil.class);
    private static final String URL = "jdbc:mysql://112.124.21.230:3306/bosssoft?useUnicode=true&characterEncoding=utf-8&useSSL=false";
    private static final String USER = "root";
    private static final String PASSWORD = "123456";
    private static Connection conn = null;
    private static ResultSet rs = null;
    private static PreparedStatement ps = null;

    private DBUtil() {

    }

    /**
     * 封装一个方法用于连接
     *
     * @return
     */
    public static Connection init() {
        try {
            conn = DriverManager.getConnection(URL, USER, PASSWORD);
            return conn;
        } catch (Exception e) {
            log.error("com.bosssoft.hr.train.j2se.basic.example.database.DBUtil.init：获取数据库连接失败！");
        }
        return null;
    }

    /**
     * 用来增删改
     * 但是仅用于参数都确定
     *
     * @param sql
     * @return
     */
    public static int creatOrUpdateOrDelete(String sql) {
        int result = -1;
        if (conn != null) {
            try {
                ps = conn.prepareStatement(sql);
                //执行
                result = ps.executeUpdate();
            } catch (SQLException e) {
                log.error("数据库修改异常");
            }
        } else {
            log.error("com.bosssoft.hr.train.j2se.basic.example.database.DBUtil.CreatOrUpdateOrDelete：获取数据库连接失败！");
        }
        return result;
    }

    /**
     * 重写方法传入要处理的值
     *
     * @param sql
     * @param columns
     * @return
     */
    public static int creatOrUpdateOrDelete(String sql, String... columns) {
        int result = -1;
        if (conn != null) {
            try {
                ps = conn.prepareStatement(sql);
                for (int i = 1; i <= columns.length; i++) {
                    ps.setString(i, columns[i - 1]);
                }
                //执行
                result = ps.executeUpdate();
            } catch (SQLException e) {
                log.error("数据库修改异常");
            }
        } else {
            log.error("com.bosssoft.hr.train.j2se.basic.example.database.DBUtil.CreatOrUpdateOrDelete：获取数据库连接失败！");
        }
        return result;
    }


    /**
     * 查询
     *
     * @param sql
     * @return
     */
    public static ResultSet select(String sql) {
        try {
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery(sql);
        } catch (SQLException e) {
            log.error("sql数据库查询异常");

        }
        return rs;
    }

    /**
     * 关闭连接
     */
    public static void closeConn() {
        try {
            conn.close();
        } catch (SQLException e) {
            log.error("sql数据库关闭异常");

        }
    }
}
