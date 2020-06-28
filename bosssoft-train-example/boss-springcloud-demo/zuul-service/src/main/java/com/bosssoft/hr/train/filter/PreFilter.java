package com.bosssoft.hr.train.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.util.concurrent.TimeUnit;

/**
 * @description:
 * @author:zyz
 * @time:2020/6/17-16:42
 */
@Component
public class PreFilter extends ZuulFilter {
    @Autowired
    RedisTemplate<String, Object> redisTemplate;

    //排除过滤的 uri 地址
    private static final String LOGIN_URI = "/login";


    @Override
    public String filterType() {
        return "pre";
    }

    @Override
    public int filterOrder() {
        return 0;
    }

    /**
     * 放行login
     *
     * @return
     */
    @Override
    public boolean shouldFilter() {
        RequestContext requestContext = RequestContext.getCurrentContext();
        HttpServletRequest request = requestContext.getRequest();
        return !LOGIN_URI.equals(request.getRequestURI());
    }

    /**
     * 校验token
     *
     * @return
     * @throws ZuulException
     */
    @Override
    public Object run() throws ZuulException {
        RequestContext requestContext = RequestContext.getCurrentContext();
        requestContext.getResponse().setContentType("text/html;charset=UTF-8");
        HttpServletRequest request = requestContext.getRequest();
        //拿到token之后需要做的事情是，去redis中找，看看有没有没有就是无效的token
        String token = request.getHeader("Authorization");
        //默认失败
        requestContext.setSendZuulResponse(false);
        requestContext.setResponseStatusCode(403);
        if (token == null) {
            requestContext.setResponseBody("请先登录");
        } else {
            Object userId = redisTemplate.opsForValue().get(token);
            if (userId == null) {
                requestContext.setResponseBody("无效的token或token已过期,请重新登录");
            } else {
                //都符合要求放行,但是需要给redis缓存时间增长一下，因为有了操作
                redisTemplate.opsForValue().set(token, userId, 15, TimeUnit.MINUTES);
                requestContext.setSendZuulResponse(true);
                requestContext.setResponseStatusCode(200);
            }
        }
        return null;
    }
}
