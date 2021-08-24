package com.neu.praAnnotation;

import java.lang.annotation.*;


/**
 * @description:
 * @author:zyz
 * @time:2021/6/22-21:00
 */
@Repeatable(MyAnnotations.class)
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE_PARAMETER,ElementType.TYPE, ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER, ElementType.CONSTRUCTOR, ElementType.LOCAL_VARIABLE})
public @interface MyAnnotation {
    String value() default "atguigu";
}
