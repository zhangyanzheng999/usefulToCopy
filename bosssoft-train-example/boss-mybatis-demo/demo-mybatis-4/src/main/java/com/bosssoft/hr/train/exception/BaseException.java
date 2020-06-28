package com.bosssoft.hr.train.exception;

/**
 * @description:为了解决SonarLint
 * @author:zyz
 * @time:2020/6/8--9:02
 */
public class BaseException extends RuntimeException {

    private final String code;


    public BaseException(String message, String code) {
        super(message);
        this.code = code;
    }

    public String getCode() {
        return code;
    }
}
