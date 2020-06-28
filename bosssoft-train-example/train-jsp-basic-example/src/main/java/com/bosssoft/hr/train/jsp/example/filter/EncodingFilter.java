package com.bosssoft.hr.train.jsp.example.filter;

import javax.servlet.*;
import java.io.IOException;

/**
 * @description: 统一字符格式
 * @author:zyz
 * @time:2020/5/30--22:04
 */
public class EncodingFilter implements Filter {
    //统一编码格式
    private  String encoding;
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        //接收web.xml中的初始参数
        encoding=filterConfig.getInitParameter("encode");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        //设置字符编码链锁
        request.setCharacterEncoding(encoding);
        response.setCharacterEncoding(encoding);
        //放行
        chain.doFilter(request,response);
    }

    @Override
    public void destroy() {
        //don't need do nothing
    }
}
