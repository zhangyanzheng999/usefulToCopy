package com.bosssoft.hr.train.springmvc.common;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface MyLogApi {
    /**
     * value可以协商方法作用
     *
     * @return
     */
    String value() default "";
}
