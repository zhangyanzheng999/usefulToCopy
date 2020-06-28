package com.atguigu.Interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @description:
 * @author:zyz
 * @time:2020/5/19--15:49
 */
public class MyFirstInterceptor implements HandlerInterceptor {
    //目标方法运行之前执行
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        System.out.println("MyFirstInterceptor.preHandle"+request.getRequestURI());
        return true;
    }
    //目标方法执行正确之后执行
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("MyFirstInterceptor.postHandle");
    }
    //页面相应之后执行
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("MyFirstInterceptor.afterCompletion");
    }
}
