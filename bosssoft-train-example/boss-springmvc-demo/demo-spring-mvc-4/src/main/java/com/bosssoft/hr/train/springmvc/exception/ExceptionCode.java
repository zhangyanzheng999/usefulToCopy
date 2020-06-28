package com.bosssoft.hr.train.springmvc.exception;

/**
 * IException的枚举类
 */
public enum ExceptionCode implements IException {
    UNKNOWN_EXCEPTION(-1, "未知自定义异常"),
    USER_INFO_LACK_EXCEPTION(2000, "用户信息不完善"),
    USER_ID_FORMAT_EXCEPTION(2001, "用户ID不为整形数字"),
    USER_AGE_FORMAT_EXCEPTION(2002, "用户年龄不是整形数字"),
    USER_AGE_SCOPE_EXCEPTION(2003, "用户年龄范围异常"),
    USER_NAME_EXCEPTION(2004, "用户名字包含非法字符");


    private Integer code;

    private String msg;

    ExceptionCode(Integer code, String msg) {
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
