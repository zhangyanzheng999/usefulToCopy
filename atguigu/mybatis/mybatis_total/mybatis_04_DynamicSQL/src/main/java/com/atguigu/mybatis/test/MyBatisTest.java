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
import java.util.*;

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
            EmployeeMapper employeeMapper = sqlSession.getMapper(EmployeeMapper.class);
            Employee emp = employeeMapper.getEmpById(1);
            System.out.println(employeeMapper.getClass());
            System.out.println(emp);
        } finally {
            sqlSession.close();
        }
    }

    @Test
    public void test02() throws IOException {
        SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
        SqlSession openSession = sqlSessionFactory.openSession();
        try {
            EmployeeMapperAnnotation mapper = openSession.getMapper(EmployeeMapperAnnotation.class);
            Employee emp = mapper.getEmpById(1);
            System.out.println(emp);
        } finally {
            openSession.close();
        }
    }

    /**
     * 测增删改查
     * 1、mybatis允许增删改查直接定义以下返回值:
     * Integer、Long、Boolean、void
     * sqlSessionFactory.openSession()===>手动提交
     * sqlSessionFactory.openSession(true);====>自动提交
     *
     * @throws IOException
     */

    @Test
    public void test03() throws IOException {
        SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
        //1、获取到的sqlSession 不自动提交数据
        SqlSession openSession = sqlSessionFactory.openSession();
        try {
            EmployeeMapper mapper = openSession.getMapper(EmployeeMapper.class);
            //插入
            Employee employee = new Employee(null, "zhangliu999", null, "1");
            mapper.addEmp(employee);
            System.out.println(employee.getId());
            //修改
            //     Employee employee = new Employee(1,"zhangsan","zhangsan@guigu.com","1");
            //    mapper.updateEmp(employee);
            //删除
            //mapper.deleteEmpById(2);
     /*       Employee zhangsan = mapper.getEmpByIdAndLastName(1, "zhangsan");
            System.out.println(zhangsan);*/

  /*          Map<String,Object> map=new HashMap<String, Object>();
            map.put("id",1);
            map.put("lastName","zhangsan");

            Employee employee = mapper.getEmpByMap(map);
            System.out.println(employee);*/

/*            List<String> list = new ArrayList<>();
            list.add("1");
            list.add("zhangsan");
            System.out.println(mapper.getEmpByList(list));*/
            //手动提交
            openSession.commit();
        } finally {
            openSession.close();
        }
    }


    @Test
    public void test04() throws IOException {
        SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
        SqlSession openSession = sqlSessionFactory.openSession();

        try {
            EmployeeMapper mapper = openSession.getMapper(EmployeeMapper.class);
/*            List<Employee> employees = mapper.getEmpsByLastNameLike("%"+"zhang"+"%");
            for (Employee e:employees) {
                System.out.println(e);
            }*/
           /* Map<String, Object> map = mapper.getEmpByIdReturnMap(1);
            System.out.println(map);*/
            Map<Integer, Employee> emps = mapper.getEmpsByLastNameLikeReturnMap("%" + "" + "%");
            System.out.println(emps);
        } finally {
            openSession.close();
        }

    }

    @Test
    public void test05() throws IOException {
        SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
        SqlSession openSession = sqlSessionFactory.openSession();
        try {
            EmployeeMapperPlus mapper = openSession.getMapper(EmployeeMapperPlus.class);
         /*   Employee emp = mapper.getEmpById(1);
            System.out.println(emp);*/

            /*     Employee employee = mapper.getEmpAndDeptById(1);*/
            Employee employee = mapper.getEmpByIdStep(4);
            System.out.println(employee);
        } finally {
            openSession.close();
        }

    }

    @Test
    public void test06() throws IOException {
        SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
        SqlSession openSession = sqlSessionFactory.openSession();

        try {
            DepartmentMapper mapper = openSession.getMapper(DepartmentMapper.class);
        /*    Department department = mapper.getDeptWithEmpsById(1);
            System.out.println(department);
            System.out.println(department.getEmps());*/
            Department department = mapper.getDeptByIdStep(1);
            System.out.println(department.getDeptName());
            //    System.out.println(department.getEmps());
        } finally {
            openSession.close();
        }


    }

    @Test
    public void test07() throws IOException {

        SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
        SqlSession openSession = sqlSessionFactory.openSession();
        try {
            EmployeeMapperDynamicSQL mapper = openSession.getMapper(EmployeeMapperDynamicSQL.class);
    /*        Employee employee=new Employee();
            employee.setGender("1");
            List<Employee> employees = mapper.getEmpsByConditionIF(employee);
            System.out.println(employees);*/


            //查询时如果有某些条件没带 可能sql拼装会有问题
            //1、给where后边加上1=1 以后条件都 and xxx
            //2、mybatis使用where标签来将所有查询条件包括在内. mybatis就会将where标签中拼装的sql，多出来的and或者or去掉。
            // where 只会去掉第一个多出来的and或者or


            //测试trim
         /*   Employee employee1=new Employee();
            employee1.setLastName("%z%");
            List<Employee> empsByConditionTrim = mapper.getEmpsByConditionTrim(employee1);
            System.out.println(empsByConditionTrim);*/


            //测试choose
     /*       Employee employee=new Employee();
            employee.setId(1);
            employee.setLastName("%%");
            List<Employee> employees = mapper.getEmpsByConditionChoose(employee);
            System.out.println(employees);
*/
            //测试set标签
    /*     Employee employee=new Employee(1,"admin0002",null,null);
         mapper.updateEmp(employee);*/

            // 测试foreach标签
            List<Integer> ids= Arrays.asList(1,2,3);
            List<Employee> employees = mapper.getEmpsByConditionForeach(ids);
            System.out.println(employees);

            openSession.commit();
        } finally {
            openSession.close();
        }
    }


    @Test
    public void testBatchSave() throws IOException {
        SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
        SqlSession openSession = sqlSessionFactory.openSession(true);
        try {
            EmployeeMapperDynamicSQL mapper = openSession.getMapper(EmployeeMapperDynamicSQL.class);
            List<Employee> emps=new ArrayList<Employee>();
            for(int i=0;i<5;i++){
                String lastName=UUID.randomUUID().toString().substring(0,5);
                Employee employee=new Employee(null, lastName,lastName+"@atguigu.com","1");
                Department department=new Department();
                department.setId(i%2+1);
                employee.setDept(department);
                emps.add(employee);
            }
            mapper.addEmps(emps);
        }finally {
            openSession.close();
        }


    }

    @Test
    public void testInnerParam() throws IOException {
        SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
        SqlSession openSession = sqlSessionFactory.openSession(true);
        try{
            EmployeeMapperDynamicSQL mapper = openSession.getMapper(EmployeeMapperDynamicSQL.class);
            List<Employee> employees = mapper.getEmpsTestInnerParameter(new Employee(null,"%zhang%",null,null));
            for(Employee employee:employees){
                System.out.println(employee);
            }

        }finally {
            openSession.close();
        }
    }

}
