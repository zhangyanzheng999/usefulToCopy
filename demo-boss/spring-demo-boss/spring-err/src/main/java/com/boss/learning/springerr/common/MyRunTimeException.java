package com.boss.learning.springerr.common;

/**
 * @description:
 * @author:zyz
 * @time:2020/6/4--14:21
 */
public class MyRunTimeException extends RuntimeException {

    public MyRunTimeException(IMyException myException) {
        super("错误代码: " + myException.code() + ",错误信息" + myException.msg());
    }
}
