package com.boss.learning.springaop;

import com.boss.learning.springaop.bean.User;
import com.boss.learning.springaop.common.CglibProxy;
import com.boss.learning.springaop.common.JDKProxy;
import com.boss.learning.springaop.service.IUserService;
import com.boss.learning.springaop.service.SysService;
import com.boss.learning.springaop.service.impl.UserServiceImpl;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @description:
 * @author:zyz
 * @time:2020/6/3--9:15
 */
public class App {

    @Test
    public void testJDKProxy() {

        JDKProxy jdkProxy = new JDKProxy();
        IUserService userService = new UserServiceImpl();
        System.out.println("userService = " + userService);
        IUserService userServiceProxy = (IUserService) jdkProxy.newInstance(userService);
        System.out.println("userServiceProxy = " + userServiceProxy);
        User user = new User();
        user.setName("sss");
        userServiceProxy.saveUser(user);

        // JDK代理必须实现接口

/*        SysService sysService=new SysService();
        SysService sysServiceProxy = (SysService) jdkProxy.newInstance(sysService);
        System.out.println(sysServiceProxy.getToken());*/
    }

    @Test
    public void testCglibProxy() {
        CglibProxy cglibProxy = new CglibProxy();
        IUserService userService = new UserServiceImpl();
        System.out.println("userService = " + userService);
        IUserService userServiceProxy = (IUserService) cglibProxy.newInstance(userService);
        System.out.println("userServiceProxy = " + userServiceProxy);
        User user = new User();
        user.setName("sss");
        userServiceProxy.saveUser(user);

        SysService sysService = new SysService();
        SysService sysServiceProxy = (SysService) cglibProxy.newInstance(sysService);
        System.out.println(sysServiceProxy.getToken());

    }

    @Test
    public void testAspect() {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        SysService sysService = applicationContext.getBean(SysService.class);
        sysService.validate();
    }
}
