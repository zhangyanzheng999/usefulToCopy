package com.bosssoft.hr.train.j2se.basic.example.database;

import java.sql.Connection;
import java.sql.ResultSet;

/**
 * @description:  我是工具类并且我不喜欢被继承 final 保护了我免于继承，private 保护我被创建
 * @author: Administrator
 * @create: 2020-05-28 20:45
 * @since
 **/
public final class DBUtil {
    private final static String DB_URL="jdbc://xxx";
    private DBUtil(){

    }


    private Connection createConnection(){
        Connection connection=null;
        return null;
    }


    /**
     *  如果需要参数的你可以选择overload 改方法
     * @param sql
     * @return
     */
    public static ResultSet executeQuery(String sql){
        return null;
    }
    public static int executeUpdate(String sql) {
        return 0;
    }
}
