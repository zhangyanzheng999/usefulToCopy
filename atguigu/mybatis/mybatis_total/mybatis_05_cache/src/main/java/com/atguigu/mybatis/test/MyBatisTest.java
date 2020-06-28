package com.atguigu.mybatis.test;

import com.atguigu.mybatis.bean.Department;
import com.atguigu.mybatis.bean.Employee;
import com.atguigu.mybatis.dao.*;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;



public class MyBatisTest {

    //获取SqlSessionFactory
    public SqlSessionFactory getSqlSessionFactory() throws IOException {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        return new SqlSessionFactoryBuilder().build(inputStream);
    }

    /**
     * 两级缓存：
     *      一级缓存：(本地缓存)；sqlSession级别的缓存。一级缓存是一直开启的； SqlSession级别的一个Map
     *          与数据库同一次会话期间查询到的数据会放在本地缓存之中。
     *          以后如果需要获取相同的数据，直接从缓存中拿，没必要再去查询数据库
     *
     *          一级缓存失效的情况(没有使用到一级缓存的情况，效果就是，还需要再向数据库发送sql)
     *              1、sqlSession不同
     *              2、sqlSession相同，但是查询条件不同(当前一级缓存中没有这个数据)
     *              3、sqlSession相同，但是两次查询期间执行了增删改操作(这次增删改可能对当前数据有影响)
     *              4、sqlSession相同，但是手动清除了一级缓存 openSession.clearCache();
     *
     *      二级缓存: (全局缓存) 基于namespace级别的缓存;一个namespace对应的一个二级缓存
     *          工作机制：
     *          1、一个会话,查询一条数据，这个数据就会被放在当前会话的一级缓存中
     *          2、如果会话关闭；一级缓存中的数据会被保存到二级缓存中；新的会话查询信息，就会参照二级缓存中的内容
     *          3、sqlSession====>EmployeeMapper==>Employee
     *                           DepartmentMapper==>Department
     *             不同namespace查出的数据会放在自己对应的缓存中(map中)
     *           效果:数据会从二级缓存中获取
     *                查出的数据都会被默认放在一起缓存中
     *                只有会话提交或者关闭以后,一级缓存中的数据才会转移到二级缓存中
     *
     *          使用步骤:
     *              1)、开启全局二级缓存配置;  <setting name="cacheEnabled" value="true"/>
     *              2)、去mapper.xml中配置使用二级缓存  <cache></cache>
     *              3)、我们的POJO需要实现序列化接口
     *
     *  和缓存有关的设置/属性:
     *      1)、cacheEnable=true,  false:是关闭缓存(关闭的是二级缓存，一级缓存一直可用)
     *      2)、每个select标签都有useCache="true" 属性，默认为true ，如果设置为false(一级缓存依然使用,关闭二级缓存)
     *      3)、每个增删改标签都会有：flushCache="true"
     *          增删改执行完之后会清空缓存，
     *          测试结果:清空一级缓存;二级缓存也会被清空
     *          查询标签默认flushCache="false",如果改为true,每次查询之后都会清空缓存;缓存没有被使用
     *      4)、sqlSession.clearCache()；只清空当前session的一级缓存
     *      5)、localCacheScope:本地缓存作用域(一级缓存 SESSION:当前会话的所有数据保存在会话缓存中)
     *                                               STATEMENT:可以禁用一级缓存
     *
     *  第三方缓存整合:
     *      1)、导入第三方缓存包
     *      2)、导入与第三方整合的适配包
     *      3)、mapper.xml使用缓存
     *          <cache type="org.mybatis.caches.ehcache.EhcacheCache"></cache>
     *
     */

    @Test
    public void testFirstLevelCache() throws IOException {
        SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
        SqlSession openSession = sqlSessionFactory.openSession();
        try{
            EmployeeMapper mapper = openSession.getMapper(EmployeeMapper.class);
            Employee emp01 = mapper.getEmpById(1);
            System.out.println(emp01);

            /*mapper.addEmp(new Employee(null,"wangwang","wangwang@qq.com","1",new Department(1)));
            System.out.println("数据添加完成.....");*/

            //清空缓存
            openSession.clearCache();

            Employee emp02 = mapper.getEmpById(1);
            System.out.println(emp02);

            System.out.println(emp01==emp02);

            openSession.commit();
        }finally {
            openSession.close();
        }
    }

    @Test
    public void testSecondLevelCache() throws IOException {
        SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
        SqlSession openSession = sqlSessionFactory.openSession();
        SqlSession openSession2=sqlSessionFactory.openSession();
        try{
            EmployeeMapper mapper = openSession.getMapper(EmployeeMapper.class);
            EmployeeMapper mapper2 = openSession2.getMapper(EmployeeMapper.class);

            Employee emp = mapper.getEmpById(1);
            System.out.println(emp);
            //只有关闭了会话,才会保存到二级缓存中
            openSession.close();

            //第二次查询是从二级缓存中拿到数据,并没有发送新的sql
            Employee emp2 = mapper2.getEmpById(1);
            System.out.println(emp2);
            openSession2.close();
            System.out.println(emp==emp2);
          //  openSession.commit();
        }finally {

        }

    }
}
