package com.bosssoft.hr.train.springmvc.exception;

import com.bosssoft.hr.train.springmvc.bean.Msg;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @description:
 * @author:zyz
 * @time:2020/6/6--16:07
 */

@RestControllerAdvice
@Slf4j
public class ThrowErr {
    /**
     * 如果是自定义异常
     *
     * @param exception
     */
    @ExceptionHandler(BaseException.class)
    public static Object throwException(IException exception) {
        log.error("IException,异常编码：{},异常消息:{}", exception.code(), exception.msg());

        return new Msg().code(exception.code()).msg(exception.msg());
    }

    /**
     * 基本异常
     *
     * @param exception
     */
    @ExceptionHandler(Exception.class)
    public static Object throwException(Exception exception) {
        log.error("Exception,异常编码：{},异常消息:{}", -1, exception.toString());
        return new Msg().code(-1).msg(exception.toString());
    }

    private ThrowErr() {
    }
}
