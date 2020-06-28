package com.boss.learning.springlog.common;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.lang.reflect.Array;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @description:
 * @author:zyz
 * @time:2020/6/3--21:35
 */
@Component
@Aspect
public class LogAspect {

    @Pointcut("execution(* com.boss.learning.springlog.service.*.*(..))")
    public void pointCut() {
    }

    @Around(value = "pointCut()")
    public Object log(ProceedingJoinPoint joinPoint) {
        long startTime = System.currentTimeMillis();
        String time = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
        String methodName = joinPoint.getSignature().getName();
        String className = joinPoint.getSignature().getDeclaringTypeName();
        Object[] args = joinPoint.getArgs();
        String operate = "";
        String desc = "";
        //所有方法
        Method[] methods = joinPoint.getTarget().getClass().getMethods();
        for (Method method : methods) {
            if (method.getName().equals(methodName)) {
                MyLog myLog = method.getAnnotation(MyLog.class);
                operate = myLog.action();
                desc = myLog.desc();
                break;
            }
        }


        //返回结果
        Object result = null;
        try {
            result = joinPoint.proceed();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        //响应时间
        long respTime = System.currentTimeMillis() - startTime;

        Map<String, Object> logMap = new HashMap<>();
        logMap.put("time", time);
        logMap.put("className", className);
        logMap.put("methodName", methodName);
        logMap.put("args", Arrays.asList(args));
        logMap.put("operate", operate);
        logMap.put("desc", desc);
        logMap.put("result", result);
        logMap.put("respTime", respTime);
        System.out.println("logMap:" + logMap);

        return result;
    }

}
