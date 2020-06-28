package com.atguigu;

import com.atguigu.config.AppConfig;
import com.atguigu.config.RootConfig;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

/**
 * @description:  web容器启动的时候创建对象：调用方法来初始化容器以及前端控制器
 * @author:zyz
 * @time:2020/5/19--14:51
 */
public class MyWebAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {
    //获取根容器的配置类(Spring配置文件)  父容器
    protected Class<?>[] getRootConfigClasses() {
        return new Class<?>[]{RootConfig.class};
    }

    //获取web容器的配置类（SpringMVC配置文件） 子容器
    protected Class<?>[] getServletConfigClasses() {
        return new Class<?>[]{AppConfig.class};
    }

    //获取DispatcherServlet的映射信息
    //  /是拦截所有请求(包括静态资源(js、png)),但是不包括*.jsp
    //  /*:拦截所有请求，*.jsp页面也拦截    jsp页面是tomcat的jsp引擎解析的
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }
}
