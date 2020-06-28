package com.atguigu.servlet;

import com.atguigu.UserFilter;
import com.atguigu.listener.UserListener;
import com.atguigu.service.HelloService;

import javax.servlet.*;
import javax.servlet.annotation.HandlesTypes;
import java.util.EnumSet;
import java.util.Set;

/**
 * @description:
 * @author:zyz
 * @time:2020/5/19--10:08
 */
//容器启动的时候会将@HandlesTypes指定的这个类型下面的子类(实现类、子接口等)全部传递过来

//传入感兴趣类型
@HandlesTypes(value={HelloService.class})
public class MyServletContainerInitializer implements ServletContainerInitializer {
    /**
     * 应用启动的时候，运行onStartup方法
     * @param set   感兴趣的类型的所有子类型
     * @param servletContext        代表当前Web应用的ServletContext，一个web应用一个ServletContext
     * @throws ServletException
     *
     *
     * 1)、使用servletContext注册Web组件(Servlet、Filter、Listener)
     * 2)、使用编码的方式，在项目启动的时候给ServletContext里面添加组件；
     *          必须在项目启动的时候添加
     *          1)、ServletContainerInitializer得到的ServletContext
     *          2)、ServletContextListener得到的组件
     */
    @Override
    public void onStartup(Set<Class<?>> set, ServletContext servletContext) throws ServletException {
        System.out.println("感兴趣的类型：");
        for (Class<?> typeClass:set) {
            System.out.println(typeClass);
        }

        //注册组件
        ServletRegistration.Dynamic userServlet = servletContext.addServlet("userServlet", new UserServlet());
        //配置Servlet映射信息
        userServlet.addMapping("/user");

        servletContext.addListener(UserListener.class);
        //注册过滤器
        FilterRegistration.Dynamic userFilter = servletContext.addFilter("userFilter", UserFilter.class);
       //配置filter映射信息
        userFilter.addMappingForUrlPatterns(EnumSet.of(DispatcherType.REQUEST),true,"/*");
    }
}
