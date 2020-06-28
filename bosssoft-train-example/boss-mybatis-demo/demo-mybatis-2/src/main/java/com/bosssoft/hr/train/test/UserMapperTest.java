package com.bosssoft.hr.train.test;

import com.bosssoft.hr.train.bean.User;
import com.bosssoft.hr.train.dao.UserMapper;
import com.bosssoft.hr.train.util.MybatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.log4j.Logger;
import org.junit.Test;

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
     * Mapper
     */

    @Test
    public void testWithCompany() {
        try {
            UserMapper mapper = SQL_SESSION.getMapper(UserMapper.class);
            User user = mapper.getUserByIdWithCompany(1);
            log.info(user.toStringWithCompany());
        } finally {
            SQL_SESSION.close();
        }

    }

    @Test
    public void testWithRole() {
        try {
            UserMapper mapper = SQL_SESSION.getMapper(UserMapper.class);
            log.info(mapper.getUserByIdWithRole(1).toStringWithRole());
            log.info("--------------------");
            log.info(mapper.getUserByIdWithRole(2).toStringWithRole());
        } finally {
            SQL_SESSION.close();
        }

    }

}
