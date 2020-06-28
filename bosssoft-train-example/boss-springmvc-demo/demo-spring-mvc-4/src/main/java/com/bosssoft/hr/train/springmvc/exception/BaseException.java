package com.bosssoft.hr.train.springmvc.exception;

/**
 * @description:自定义异常
 * @author:zyz
 * @time:2020/6/6--12:57
 */
public class BaseException extends RuntimeException implements IException {
     final transient IException exception;

    public BaseException(IException exception) {
        super("错误代码:" + exception.code() + ",错误消息:" + exception.msg());
        this.exception = exception;
    }

    @Override
    public Integer code() {
        return exception.code();
    }

    @Override
    public String msg() {
        return exception.msg();
    }
}
