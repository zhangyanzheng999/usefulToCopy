/**
 * @file:  BusinessException.java
 * @author: Administrator    
 * @date:   2020-6-19 11:19
 * @copyright: 2020-2023 www.bosssoft.com.cn Inc. All rights reserved. 
 */  
package com.bosssoft.hr.train.springboot.basic.example.exception;

/**
 * @class BusinessException
 * @classdesc 基于异常码的方式统一了系统异常，对于不稳定的业务方法要求必须捕获异常抛出
 * 异常 全局要求对此类异常做日志记录和构建统一的应答给前端
 * @author Administrator
 * @date 2020-6-19  11:08
 * @version 1.0.0
 * @see
 * @since
 */
public class BusinessException extends RuntimeException {
    /**
     * 异常码
     */
    private  String code;

    public BusinessException(String code, String message) {
        super(message);
        this.code=code;
    }
    /**
     * 发生业务异常则构建异常对象抛出
     *
     * @param code
     * @param message
     * @param cause
     */
    public BusinessException(String code, String message, Throwable cause) {
        super(message,cause);
        this.code=code;
    }
    public BusinessException(BusinessErrorCode businessErrorCode, Throwable cause) {

    }

}
