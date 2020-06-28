package com.atguigu.mybatis.test;

import com.atguigu.mybatis.bean.Employee;
import com.atguigu.mybatis.dao.EmployeeMapper;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

/**
 * 1、接口式编程
 * 原生：  Dao====>DaoImpl
 * mybatis  Mapper==>xxMapper.xml
 * <p>
 * 2、SqlSession代表和数据库的一次会话；用完必须关闭
 * 3、SqlSession和connection一样都是非线程安全的；每次使用都应该去获取新的对象
 * 4、mapper接口没有实现类，但是mybatis会为这个接口生成一个代理对象。
 * (将接口和xml进行绑定)
 * EmployeeMapper employeeMapper = sqlSession.getMapper(EmployeeMapper.class);
 * 5、两个重要的配置文件：
 * mybatis的全局配置文件：包含数据库连接池信息，事务管理器等...系统运行环境
 * sql映射文件:保存了每一个sql语句的映射信息：
 * 将sql抽取出来。
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
     * sqlSession.getMapper(EmployeeMapper.class);
     *
     * @throws IOException
     */

    //获取SqlSessionFactory
    public SqlSessionFactory getSqlSessionFactory() throws IOException {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        return new SqlSessionFactoryBuilder().build(inputStream);
    }

    @Test
    public void test() throws IOException {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        //2、获取sqlSession实例，能直接执行已经映射的sql语句
        //sql的唯一标识:statement Unique identifier matching the statement to use
        //执行sql要用的参数：parameter A parameter object to pass to the statement.
        SqlSession openSession = sqlSessionFactory.openSession();
        try {
            Employee employee = (Employee) openSession.selectOne("com.atguigu.mybatis.EmployeeMapper.selectEmp", 1);
            System.out.println(employee);
        } finally {
            openSession.close();
        }


    }

    @Test
    public void test01() throws IOException {
        //1、获取SQLSessionFactory对象
        SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
        //2、获取sqlSession对象
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            //3、获取接口实现类对象
            //会为接口自动创建一个代理对象，代理对象去执行增删改查
            EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);
            Page<Object> page = PageHelper.startPage(1, 5);
            List<Employee> emps = mapper.getEmps();
            PageInfo<Employee> pageInfo = new PageInfo<Employee>(emps,1);
           /* for (Employee employee : emps) {
                System.out.println(employee);
            }*/
           /* System.out.println("当前页码："+page.getPageNum());
            System.out.println("总记录数："+page.getTotal());
            System.out.println("每页记录数："+page.getPageSize());
            System.out.println("总共页数："+page.getPages());*/

            System.out.println(pageInfo);
            List<Employee> lists = pageInfo.getList();
            for(Employee list:lists){
                System.out.println(list);
            }
        } finally {
            sqlSession.close();
        }
    }


    @Test
    public void testBatch() throws IOException {
        SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
        //可以执行批量操作的sqlSession
        SqlSession openSession = sqlSessionFactory.openSession(ExecutorType.BATCH);
        try{
            EmployeeMapper mapper = openSession.getMapper(EmployeeMapper.class);
            long start = System.currentTimeMillis();
            for(int i=0;i<10000;i++){
                mapper.addEmp(new Employee(UUID.randomUUID().toString().substring(0,5),"b","1"));
            }
            openSession.commit();
            long end = System.currentTimeMillis();
            System.out.println("执行时长："+(end-start));
        }finally {
            openSession.close();
        }
    }

    /**
     * Oracle 分页：
     *      借助rownum:行号
     *          还要有子查询
     */
    @Test
    public void testProcedure() throws IOException {
        SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
        SqlSession openSession = sqlSessionFactory.openSession();
        try{
            EmployeeMapper mapper = openSession.getMapper(EmployeeMapper.class);
            com.atguigu.mybatis.bean.Page page = new com.atguigu.mybatis.bean.Page(1,5);
            mapper.getPageByProcedure(page);
            System.out.println(page.getCount());
            System.out.println(page.getEmps());

        }finally {
            openSession.close();
        }

    }

    /**
     * DateTimeFormatter
     * LocalDateTime
     * @throws Exception
     */
    @Test
    public void testForDate() throws Exception{
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println(localDateTime.format(dateTimeFormatter));

        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String format = simpleDateFormat.format(System.currentTimeMillis());
        System.out.println(format);
    }
}
