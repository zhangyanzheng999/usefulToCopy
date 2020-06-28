package com.bosssoft.hr.train.springmvc.common;

import com.bosssoft.hr.train.springmvc.exception.IException;
import com.bosssoft.hr.train.springmvc.exception.ThrowErr;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;


/**
 * @description: 处理所有Controller的注解
 * @author:zyz
 * @time:2020/6/6--15:03
 */
@Component
@Aspect
public class LogAspect {
    //自定义注解为切面
    @Pointcut("@annotation(com.bosssoft.hr.train.springmvc.annotation.ProcessException)")
    public void pointCut() {
        // 切入点
    }

    /**
     * 这样就没用了
     * @param joinPoint
     * @param e
     */
    @AfterThrowing(value = "pointCut()", throwing = "e")
    public void handleException(JoinPoint joinPoint, Exception e) {
        /**
         * 看Exception是否是我们自定义异常
         */
        try {
            ThrowErr.throwException((IException) e);
        } catch (ClassCastException exception) {
            ThrowErr.throwException(exception);
        }

    }

}
