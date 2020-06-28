package com.bosssoft.hr.train.test;


import com.bosssoft.hr.train.bean.Student;
import com.bosssoft.hr.train.dao.StudentMapper;
import com.bosssoft.hr.train.util.MybatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.log4j.Logger;
import org.junit.Test;



/**
 * @description:
 * @author:zyz
 * @time:2020/6/7--19:46
 */
public class SecondLevelCacheTest {
    private static final Logger log = Logger.getLogger(SecondLevelCacheTest.class);
    /**
     * SqlSessionFactory
     */
    private static final SqlSessionFactory SQL_SESSION_FACTORY = MybatisUtil.getSqlSessionFactory();



    /**
     * 两次查询相同只会发送一条SQL语句
     */
    @Test
    public void testUserSecondCache() {
        //第一个
        SqlSession sqlSession = SQL_SESSION_FACTORY.openSession();
        StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);
        Student student = studentMapper.getStudentById(1);
        log.info(student);
        //关闭
        sqlSession.close();
        //第二个
        SqlSession sqlSession2 = SQL_SESSION_FACTORY.openSession();
        StudentMapper studentMapper2 = sqlSession2.getMapper(StudentMapper.class);
        Student student2 = studentMapper2.getStudentById(1);
        log.info(student2);
    }


}
