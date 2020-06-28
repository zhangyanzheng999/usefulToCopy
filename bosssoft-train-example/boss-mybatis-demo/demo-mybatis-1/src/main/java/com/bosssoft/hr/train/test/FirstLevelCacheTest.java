package com.bosssoft.hr.train.test;

import com.bosssoft.hr.train.bean.User;
import com.bosssoft.hr.train.dao.UserMapper;

import com.bosssoft.hr.train.util.MybatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.log4j.Logger;
import org.junit.Test;

import java.util.List;

/**
 * @description:
 * @author:zyz
 * @time:2020/6/7--19:46
 */
public class FirstLevelCacheTest {
    private static final Logger log = Logger.getLogger(FirstLevelCacheTest.class);
    /**
     * SqlSessionFactory
     */
    private static final SqlSessionFactory SQL_SESSION_FACTORY = MybatisUtil.getSqlSessionFactory();

    /**
     * SqlSession
     */
    private static final SqlSession SQL_SESSION = SQL_SESSION_FACTORY.openSession();

    @Test
    /**
     * 两次查询相同只会发送一条SQL语句
     */
    public void testUserFirstCacheWithOutModify() {
        //查询两次相同内容，看发几条Sql语句
        UserMapper userMapper = SQL_SESSION.getMapper(UserMapper.class);

        List<User> users = userMapper.getUserLikeName("%%");
        log.info(users);
        List<User> users2 = userMapper.getUserLikeName("%%");
        log.info(users2);
    }

    @Test
    public void testUserFirstCacheWithModify() {
        UserMapper userMapper = SQL_SESSION.getMapper(UserMapper.class);
        List<User> users = userMapper.getUserLikeName("%%");
        log.info(users);
        //插入一条
        User user = new User(null, "张三", 20);
        userMapper.insertUser(user);
        List<User> users2 = userMapper.getUserLikeName("%%");
        log.info(users2);
    }


    @Test
    public void testUserFirstCacheWithTwoSqlSession() {
        UserMapper userMapper = SQL_SESSION.getMapper(UserMapper.class);
        List<User> users = userMapper.getUserLikeName("%%");
        log.info(users);
        //新的SqlSession
        SqlSession sqlSession2 = SQL_SESSION_FACTORY.openSession();
        UserMapper userMapper2 = sqlSession2.getMapper(UserMapper.class);
        List<User> users2 = userMapper2.getUserLikeName("%%");
        log.info(users2);
    }
}
