package com.bosssoft.hr.train.test;

import com.bosssoft.hr.train.bean.User;
import com.bosssoft.hr.train.bean.UserExample;
import com.bosssoft.hr.train.dao.UserMapper;
import com.bosssoft.hr.train.util.MybatisUtil;
import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.log4j.Logger;
import org.junit.Test;

import java.util.List;
import java.util.UUID;

/**
 * @description:
 * @author:zyz
 * @time:2020/6/7--21:53
 */
public class UserMapperTest {
    private static final Logger log = Logger.getLogger(UserMapperTest.class);
    /**
     * SqlSessionFactory
     */
    private static final SqlSessionFactory SQL_SESSION_FACTORY = MybatisUtil.getSqlSessionFactory();
    /**
     * SqlSession
     */
    private static final SqlSession SQL_SESSION = SQL_SESSION_FACTORY.openSession();

    /**
     * 测试批量插入
     */

    @Test
    public void testInsertUsers() {
        //批处理
        SqlSession sqlSession = SQL_SESSION_FACTORY.openSession(ExecutorType.BATCH);
        try {
            UserMapper mapper = sqlSession.getMapper(UserMapper.class);
            //这样批量插入
            for (int i = 0; i < 10; i++) {
                mapper.insert(new User(UUID.randomUUID().toString().substring(0, 10), i % 2));
            }
            //手动提交
            sqlSession.commit();
        } finally {
            sqlSession.close();
        }

    }


    @Test
    public void testSelectUsers() {
        try {
            UserMapper mapper = SQL_SESSION.getMapper(UserMapper.class);

            UserExample example = new UserExample();
            UserExample.Criteria criteria = example.createCriteria();
            //查询所有 再拼接一个性别
            criteria.andLastNameLike("%%").andGenderEqualTo(0);
            List<User> users = mapper.selectByExample(example);
            log.info(users);


            //上面用的是and，下边用or
            UserExample example1 = new UserExample();
            criteria = example1.createCriteria();
            criteria.andGenderEqualTo(0);
            UserExample.Criteria criteria1 = example1.createCriteria();
            criteria1.andLastNameLike("%%");
            example1.or(criteria1);

            users = mapper.selectByExample(example);
            log.info(users);


            //查询不需要手动提交
        } finally {
            SQL_SESSION.close();
        }
    }

    @Test
    public void testUpdate() {
        try {
            UserMapper mapper = SQL_SESSION.getMapper(UserMapper.class);
            //有选择的，字段有值才更新
            User user = new User();
            user.setId(1);
            user.setLastName("updateByPrimaryKeySelective");
            mapper.updateByPrimaryKeySelective(user);

            //updateByExample  Example多用于查询条件的封装
            user = new User("updateByExample", 1);
            user.setId(10);
            UserExample example = new UserExample();
            UserExample.Criteria criteria = example.createCriteria();
            criteria.andIdEqualTo(2);
            //可以修改id
            mapper.updateByExample(user, example);


            //手动提交
            SQL_SESSION.commit();
        } finally {
            SQL_SESSION.close();
        }
    }

}
