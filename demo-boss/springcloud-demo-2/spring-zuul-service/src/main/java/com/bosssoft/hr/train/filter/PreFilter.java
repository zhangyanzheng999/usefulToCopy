package com.bosssoft.hr.train.filter;

import com.bosssoft.hr.train.util.JwtUtil;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.springframework.stereotype.Component;


/**
 * @description:
 * @author:zyz
 * @time:2020/6/17-11:18
 */
@Component
public class PreFilter extends ZuulFilter {
    @Override
    public String filterType() {
        return "pre";
    }

    @Override
    public int filterOrder() {
        return 0;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() throws ZuulException {
        System.out.println("PreFilter.run");
        RequestContext context = RequestContext.getCurrentContext();
        context.getResponse().setContentType("text/html;charset=UTF-8");
        String token = context.getRequest().getParameter("token");
        token = token == null ? "" : token;
        String userId = context.getRequest().getParameter("userId");
        Long token_userId = JwtUtil.verify(token);

        System.out.println(token_userId + "::::::" + userId);
        if (Long.valueOf(userId).equals(token_userId)) {
            context.setSendZuulResponse(true);
            context.setResponseStatusCode(200);
        } else {
            context.setSendZuulResponse(false);
            context.setResponseStatusCode(401);
            context.setResponseBody("not Auth 非法的服务访问");
        }


        return null;
    }
}
