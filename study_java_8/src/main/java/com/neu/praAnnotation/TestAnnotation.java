package com.neu.praAnnotation;

import org.junit.Test;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

/**
 * @description:
 *   重复注解与类型注解
 * @author:zyz
 * @time:2021/6/22-20:58
 */
public class TestAnnotation {
    @MyAnnotation("World")
    @MyAnnotation("Hello")
    public void show(@MyAnnotation("abc") String str){

    }

    @Test
    public void test01() throws NoSuchMethodException {
        Class<TestAnnotation> clazz = TestAnnotation.class;
        Method m1 = clazz.getMethod("show",String.class);
        MyAnnotation[] myAnnotations = m1.getAnnotationsByType(MyAnnotation.class);
        Annotation[][] parameterAnnotations = m1.getParameterAnnotations();
        for (MyAnnotation myAnnotation:myAnnotations){
            System.out.println(myAnnotation.value());
        }
    }

}
