package com.bosssoft.hr.train.jsp.example.util;

import com.bosssoft.hr.train.jsp.example.exception.BusinessException;
import org.slf4j.*;
import org.slf4j.LoggerFactory;

import java.sql.*;

/**
 * @description: 我是工具类并且我不喜欢被继承 final 保护了我免于继承，private 保护我被创建
 * @author: Administrator
 * @create: 2020-05-28 20:45
 * @since
 **/
public final class DBUtil {
    private static Connection jspConn = null;
    private static ResultSet jspRs = null;
    private static PreparedStatement jspPs = null;

    private static final Logger log = LoggerFactory.getLogger(DBUtil.class);
    private static final String URL = "jdbc:mysql://112.124.21.230:3306/bosssoft?useUnicode=true&characterEncoding=utf-8&useSSL=false";
    private static final String USER = "root";
    private static final String PASSWORD = "123456";
    private static final String CODE = "10001";


    private DBUtil() {

    }

    /**
     * 封装一个方法用于连接
     *
     * @return
     */
    public static Connection init() {
        try {
            jspConn = DriverManager.getConnection(URL, USER, PASSWORD);
            return jspConn;
        } catch (Exception e) {
            throw new BusinessException(CODE, "数据库连接异常", e);
        }
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
        if (jspConn != null) {
            try {
                jspPs = jspConn.prepareStatement(sql);
                //执行
                result = jspPs.executeUpdate();
            } catch (SQLException e) {
                throw new BusinessException(CODE, "数据库修改异常", e);
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
            jspPs = jspConn.prepareStatement(sql);
            jspRs = jspPs.executeQuery(sql);
        } catch (SQLException e) {
            throw new BusinessException(CODE, "数据库查询异常", e);
        }
        return jspRs;
    }

    /**
     * 关闭连接
     */
    public static void closeConn() {
        try {
            if (jspConn != null) {
                jspConn.close();
            }
            if (jspRs != null) {
                jspRs.close();
            }
            if (jspPs != null) {
                jspPs.close();
            }
        } catch (SQLException e) {
            throw new BusinessException(CODE, "数据库关闭异常", e);
        }
    }
}
