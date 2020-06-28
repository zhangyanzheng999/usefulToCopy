package com.boss.learning.springerr.common;

public enum MyExceptionCode implements IMyException {
    UNKNOWN_EXCEPTION(-1, "未知错误"),
    USER_AGE_SCOPE_EXCEPTION(2001, "用户年龄范围超出异常"),
    USER_NAME_EXCEPTION(2002, "用户名字包含非法字符异常");

    private int code;
    private String msg;

    private MyExceptionCode(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    @Override
    public Integer code() {
        return code;
    }

    @Override
    public String msg() {
        return msg;
    }
}
