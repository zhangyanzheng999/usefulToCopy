package com.boss.learning.springerr.common;

import com.boss.learning.springerr.bean.User;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * @description:
 * @author:zyz
 * @time:2020/6/4--14:06
 */
@Aspect
@Component
public class ErrAspect {
    @Pointcut("execution(* com.boss.learning.springerr.service.*.*(..))")
    public void pointCut() {

    }

    @AfterThrowing(value = "pointCut()", throwing = "e")
    public void err(JoinPoint joinPoint, Exception e) {
        MyThrowsException.throwErr(e);
    }

}
