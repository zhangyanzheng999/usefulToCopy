package com.bosssoft.hr.train.util;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.log4j.Logger;

import java.io.IOException;
import java.io.Reader;

/**
 * @description: 获取Mybatis的SqlSessionFactory
 * @author:zyz
 * @time:2020/6/7--18:38
 */
public class MybatisUtil {
    private static final SqlSessionFactory SQL_SESSION_FACTORY;
    private static final Logger log = Logger.getLogger(MybatisUtil.class);

    static {
        String resource = "mybatis-config.xml";
        Reader reader = null;

        try {
            reader = Resources.getResourceAsReader(resource);
        } catch (IOException e) {
            log.error("文件读取失败", e);
        }
        SQL_SESSION_FACTORY = new SqlSessionFactoryBuilder().build(reader);
    }

    private MybatisUtil() {
    }

    public static SqlSessionFactory getSqlSessionFactory() {
        return SQL_SESSION_FACTORY;
    }
}
