package com.boss.learning.springerr.common;

/**
 * @description:
 * @author:zyz
 * @time:2020/6/4--14:27
 */
public class MyThrowsException {

    public static void throwErr(IMyException myException) {
        throw new MyRunTimeException(myException);
    }
    public static void throwErr(Exception e) {
        throw new MyRunTimeException(new IMyException() {
            @Override
            public Integer code() {
                return -1;
            }

            @Override
            public String msg() {
                return e.toString();
            }
        });
    }

}
