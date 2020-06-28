package cn.neu.his.test;

import java.util.UUID;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cn.neu.his.bean.Dept;
import cn.neu.his.bean.User;
import cn.neu.his.bean.UserExample;
import cn.neu.his.dao.DeptMapper;
import cn.neu.his.dao.UserMapper;
//浣跨敤spring鍗曞厓娴嬭瘯
//娴嬭瘯dao
//
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:applicationContext.xml"})
public class MapperTest {
	@Autowired
	DeptMapper deptMapper;
	@Autowired
	UserMapper usermapper;
	@Autowired
	SqlSession sqlsession;
	@Test
	public void testCRUD() {
		//1.SpringIOC
		ApplicationContext ioc =new ClassPathXmlApplicationContext("applicationContext.xml");
		DeptMapper bean=ioc.getBean(DeptMapper.class);
		//2mapper
		
		System.out.println(deptMapper);
		//1.插入
		
	//	deptMapper.insertSelective(new Dept(140,"YHY","kkkk",99,9));
		
	/*	//2查找
		UserExample user=new UserExample();
		
		System.out.println(usermapper.selectByExample(user));
		
		//批量插入
		DeptMapper mapper=sqlsession.getMapper(DeptMapper.class);
		for(int i=0;i<10;i++) {
			String uid=UUID.randomUUID().toString().substring(0,5)+i;
			mapper.insertSelective(new Dept(null, "PL", uid,888, 888));
		}
		System.out.println("插入结束");*/
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
