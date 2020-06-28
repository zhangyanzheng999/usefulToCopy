package com.boss.learning.springaop.common;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * @description:
 * @author:zyz
 * @time:2020/6/3--9:54
 */
@Aspect
@Component
public class LogAspect {
    @Pointcut("execution(* *com.boss.learning.springaop.service.*.*(..))")
    public void pointCut() {
    }


    @Before("pointCut()")
    public void before(JoinPoint joinPoint) {

        System.out.println("LogAspect.before :" + joinPoint.getSignature());
    }

    @After("pointCut()")
    public void after(JoinPoint joinPoint) {
        System.out.println("LogAspect.after :" + joinPoint.getSignature());
    }
    @Around("pointCut()")
    public void around(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("LogAspect.around :" + joinPoint.getSignature());
        Object result = joinPoint.proceed();

        System.out.println("LogAspect.around finish:" + result);
    }
    // 注解开启环绕增强如果抛出了异常  使这个无效
    @AfterThrowing(value = "pointCut()",throwing = "e")
    public void err(JoinPoint joinPoint, Exception e) {
        System.out.println("err :" + joinPoint.getSignature() + " " + e.getMessage());
    }
}
