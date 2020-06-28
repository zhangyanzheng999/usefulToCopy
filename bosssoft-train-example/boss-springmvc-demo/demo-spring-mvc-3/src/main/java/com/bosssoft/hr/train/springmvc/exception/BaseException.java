package com.bosssoft.hr.train.springmvc.exception;

/**
 * @description:自定义异常
 * @author:zyz
 * @time:2020/6/6--12:57
 */
public class BaseException extends RuntimeException {
    private final Integer code;

    public BaseException(String message, Integer code) {
        super(message);
        this.code = code;
    }


    public Integer getCode() {
        return code;
    }

}
