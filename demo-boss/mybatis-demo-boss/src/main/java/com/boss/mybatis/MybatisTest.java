package com.boss.mybatis;

import com.boss.mybatis.db.mapper.UserMapper;
import com.boss.mybatis.db.model.User;
import com.boss.mybatis.util.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;

import java.util.Date;
import java.util.List;

/**
 * @description:
 * @author:zyz
 * @time:2020/6/7--11:51
 */
public class MybatisTest {

    @Test
    public void testInsertUser() {
        SqlSessionFactory sqlSessionFactory = MyBatisUtil.getSqlSessionFactory();
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            UserMapper mapper = sqlSession.getMapper(UserMapper.class);
            User user = new User("Tom", "tom", new Date(), "河北", "123456", 1);
            mapper.insertUser(user);
            System.out.println(user.getUserId());
            sqlSession.commit();
        } finally {
            sqlSession.close();
        }

    }

    @Test
    public void testSelectUsers() {
        SqlSessionFactory sqlSessionFactory = MyBatisUtil.getSqlSessionFactory();
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            UserMapper mapper = sqlSession.getMapper(UserMapper.class);
            User condition = new User();
            condition.setUserName("%%");
            List<User> users = mapper.selectUserByCondition(condition);
            System.out.println(users);
            System.out.println(mapper.selectUserByCondition(condition));

            sqlSession.commit();
        } finally {
            sqlSession.close();
        }
    }
}
