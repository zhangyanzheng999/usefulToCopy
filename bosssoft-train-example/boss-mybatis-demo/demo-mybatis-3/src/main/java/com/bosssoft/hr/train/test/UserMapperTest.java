package com.bosssoft.hr.train.test;

import com.bosssoft.hr.train.bean.User;
import com.bosssoft.hr.train.dao.UserMapper;
import com.bosssoft.hr.train.util.MybatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.log4j.Logger;
import org.junit.Test;

import java.util.ArrayList;
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
        try {
            UserMapper mapper = SQL_SESSION.getMapper(UserMapper.class);
            List<User> users = new ArrayList<User>();
            User user;
            for (int i = 0; i < 5; i++) {
                user = new User(UUID.randomUUID().toString().substring(0, 5), i % 2);
                users.add(user);
            }
            mapper.insertUsers(users);
            //手动提交
            SQL_SESSION.commit();
        } finally {
            SQL_SESSION.close();
        }

    }


    @Test
    public void testSelectUsers() {
        try {
            UserMapper mapper = SQL_SESSION.getMapper(UserMapper.class);
            User user = new User();
            //根据Id直接查找
            user.setId(1);
            List<User> users = mapper.selectUsersByCondition(user);
            log.info(users);

            //根据名字模糊搜索
            user = new User();
            user.setLastName("%a%");
            users = mapper.selectUsersByCondition(user);
            log.info(users);

            //都没有按照性别查找女性
            user = new User();
            users = mapper.selectUsersByCondition(user);
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
            User user = new User("updateUser", 1);
            user.setId(1);
            mapper.updateUser(user);
            //手动提交
            SQL_SESSION.commit();
        } finally {
            SQL_SESSION.close();
        }
    }

}
