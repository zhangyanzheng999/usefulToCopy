package com.atguigu.mybatis.test;

import com.atguigu.mybatis.bean.Employee;
import com.atguigu.mybatis.dao.EmployeeMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

/**
 * 1、接口式编程
 * 原生：  Dao====>DaoImpl
 * mybatis  Mapper==>xxMapper.xml
 *
 * 2、SqlSession代表和数据库的一次会话；用完必须关闭
 * 3、SqlSession和connection一样都是非线程安全的；每次使用都应该去获取新的对象
 * 4、mapper接口没有实现类，但是mybatis会为这个接口生成一个代理对象。
 *       (将接口和xml进行绑定)
 *       EmployeeMapper employeeMapper = sqlSession.getMapper(EmployeeMapper.class);
 * 5、两个重要的配置文件：
 *      mybatis的全局配置文件：包含数据库连接池信息，事务管理器等...系统运行环境
 *      sql映射文件:保存了每一个sql语句的映射信息：
 *          将sql抽取出来。
 *
 */
public class MyBatisTest {
    /**
     * 1、根据xml文件(全局配置文件)创建一个sqlSessionFactory对象
     * 有数据源一些运行环境的信息
     * 2、sql映射文件:配置了每一个sql，以及sql的封装规则等
     * 3、将sql映射文件注册在全局配置文件中
     * 4、写代码
     * 1)、根据全局配置文件得到SqlSessionFactory
     * 2)、使用sqlSession工厂，获取到sqlSession对象使用他进行增删改查
     * 一个sqlSession就是代表和数据库的一次会话，用完关闭
     * 3)、使用sql的唯一标识来告诉Mybatis执行哪个sql。sql都是保存在sql映射文件中的
     *          sqlSession.getMapper(EmployeeMapper.class);
     * @throws IOException
     */

    //获取SqlSessionFactory
    public SqlSessionFactory getSqlSessionFactory() throws IOException {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        return new SqlSessionFactoryBuilder().build(inputStream);
    }

    /**
     * 1、获取sqlSessionFactory对象:
     *      解析文件的每一个信息保存在Configuration中，返回包含Configuration的DefaultSqlSessionFactory；
     *      注意:【MappedStatement】：代表一个增删改查的详细信息
     * 2、获取sqlSession对象
     *      返回一个DefaultSqlSession对象，包含Executor和Configuration
     *      这一步会创建Executor对象
     * 3、获取接口的代理对象(MapperProxy)
     *      getMapper,使用MapperProxyFactory创建一个MapperProxy的代理对象,
     *      代理对象包含了DefaultSqlSession(Executor)
     * 4、执行增删改查方法
     * @throws IOException
     */
    @Test
    public void test01() throws IOException {
        //1、获取SQLSessionFactory对象
        SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
        //2、获取sqlSession对象
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            //3、获取接口实现类对象
            //会为接口自动创建一个代理对象，代理对象去执行增删改查
            EmployeeMapper employeeMapper = sqlSession.getMapper(EmployeeMapper.class);
            Employee emp = employeeMapper.getEmpById(1);
            System.out.println(employeeMapper.getClass());
            System.out.println(emp);
        } finally {
            sqlSession.close();
        }


    }
}
