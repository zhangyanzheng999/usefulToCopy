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
    //Ŀ�귽������֮ǰִ��
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        System.out.println("MyFirstInterceptor.preHandle"+request.getRequestURI());
        return true;
    }
    //Ŀ�귽��ִ����ȷ֮��ִ��
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("MyFirstInterceptor.postHandle");
    }
    //ҳ����Ӧ֮��ִ��
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("MyFirstInterceptor.afterCompletion");
    }
}
