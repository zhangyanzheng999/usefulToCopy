package com.bosssoft.hr.train.springmvc.common;


import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Date;


/**
 * @description:
 * @author:zyz
 * @time:2020/6/5--20:13
 */
@Component
@Aspect
public class LogAspect {
    private final Logger log = LoggerFactory.getLogger(LogAspect.class);

    @Pointcut("@annotation(com.bosssoft.hr.train.springmvc.common.MyLogApi)")
    public void pointCut() {
        //切入点表达式
    }

    @Around(value = "pointCut()")
    public Object log(ProceedingJoinPoint joinPoint) {
        long startTime = System.currentTimeMillis();
        String time = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
        //获取参数值
        Object[] args = joinPoint.getArgs();
        String methodName = joinPoint.getSignature().getName();
        Method[] methods = joinPoint.getSignature().getClass().getMethods();
        //获取注解上的值
        String value = null;
        for (Method method : methods) {
            if (methodName.equals(method.getName())) {
                MyLogApi myLogApi = method.getAnnotation(MyLogApi.class);
                value = myLogApi.value();
                break;
            }
        }
        //获取IP
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        String ip = request.getRemoteAddr();

        //获取返回值
        Object result = null;
        try {
            result = joinPoint.proceed();
        } catch (Throwable throwable) {
            log.error("方法执行异常:{}", throwable);
        }
        // 响应值
        long respTime = System.currentTimeMillis() - startTime;
        log.info("访问者IP:{},请求时间:{},参数内容:{},请求耗时:{},应答内容:{},注解值为:{}", ip, time, args, respTime, result, value);
        return result;
    }

}
