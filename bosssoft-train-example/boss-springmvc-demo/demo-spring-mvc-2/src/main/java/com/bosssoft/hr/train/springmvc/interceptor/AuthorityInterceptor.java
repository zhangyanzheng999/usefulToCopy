package com.bosssoft.hr.train.springmvc.interceptor;

import com.bosssoft.hr.train.springmvc.bean.User;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @description:拦截登陆
 * @author:zyz
 * @time:2020/6/6--10:52
 */
public class AuthorityInterceptor implements HandlerInterceptor {
    /**
     * 仅仅拦截没有登录的
     *
     * @param request
     * @param response
     * @param handler
     * @return
     * @throws Exception
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        if (user == null) {
            request.getRequestDispatcher("/login").forward(request, response);
            return false;
        } else {
            return true;
        }
    }
}
