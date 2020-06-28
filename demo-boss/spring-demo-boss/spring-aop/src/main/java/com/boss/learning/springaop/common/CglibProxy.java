package com.boss.learning.springaop.common;


import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @description:
 * @author:zyz
 * @time:2020/6/3--9:36
 */
public class CglibProxy implements MethodInterceptor {
    private Object srcObject;

    public Object newInstance(Object srcObject) {
        this.srcObject = srcObject;
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(this.srcObject.getClass());
        enhancer.setCallback(this);
        return enhancer.create();
    }


    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        Object result = method.invoke(this.srcObject, objects);
        return result;
    }
}
