package com.bosssoft.hr.trian.log;



import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;


/**
 * @description:
 * @author:zyz
 * @time:2020/6/8--17:25
 */
@Component
@Aspect
public class WebRequestLog {
    private final Logger logger = LoggerFactory.getLogger(WebRequestLog.class);

    /**
     * 声明切入点
     */
    @Pointcut("execution(public * com.bosssoft.hr.trian.controller..*.*(..))")
    public void pointCut() {

    }

    @Before("pointCut()")
    public void doBefore(JoinPoint joinPoint) {
        //这个RequestAttributes是SpringMVC提供来获得请求的
        RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = ((ServletRequestAttributes) requestAttributes).getRequest();
        //记录下请求内容
        logger.info("###############URL:" + request.getRequestURL().toString());
        logger.info("###############HTTP_METHOD:" + request.getMethod());
        logger.info("###############IP:" + request.getRemoteAddr());
        logger.info("###############THE ARGS OF THE CONTROLLER:" + Arrays.asList(joinPoint.getArgs()));
        //获取包名 和 方法名
        logger.info("###############CLASS_METHOD:" + joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName());

    }

    @AfterReturning(value = "pointCut()", returning = "result")
    public void afterReturning(Object result) {
        logger.info("##################the return of method is:" + result.toString());
    }


}
