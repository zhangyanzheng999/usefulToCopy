package com.boss.learning.springaop.common;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @description:
 * @author:zyz
 * @time:2020/6/3--9:19
 */
public class JDKProxy implements InvocationHandler {
    private Object srcObject;

    public Object newInstance(Object srcObject) {
        this.srcObject = srcObject;
        return Proxy.newProxyInstance(srcObject.getClass().getClassLoader(),
                srcObject.getClass().getInterfaces(),
                this);
    }

    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("JDKProxy方法调用前");
        Object result = method.invoke(srcObject, args);
        System.out.println("JDKProxy方法调用后");
        return result;
    }
}
