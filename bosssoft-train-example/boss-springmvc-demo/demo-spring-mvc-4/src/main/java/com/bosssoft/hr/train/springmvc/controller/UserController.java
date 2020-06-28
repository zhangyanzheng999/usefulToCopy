package com.bosssoft.hr.train.springmvc.controller;

import com.bosssoft.hr.train.springmvc.annotation.ProcessException;
import com.bosssoft.hr.train.springmvc.bean.User;
import com.bosssoft.hr.train.springmvc.exception.ExceptionCode;
import com.bosssoft.hr.train.springmvc.exception.ThrowErr;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description:
 * @author:zyz
 * @time:2020/6/6--16:10
 */
@RestController
public class UserController {
    //@ProcessException 自定义的处理异常注解
    @ProcessException
    @GetMapping("/get")
    public Object get(@RequestParam(value = "id", required = false) String id,
                    @RequestParam(value = "name", required = false) String name,
                    @RequestParam(value = "age", required = false) String age) {

        if (id == null || name == null || age == null) {
           return  ThrowErr.throwException(ExceptionCode.USER_INFO_LACK_EXCEPTION);
        }
        //如果不是整形数字抛出异常
        int userId = 0;
        try {
            userId = Integer.parseInt(id);
        } catch (Exception e) {
            return ThrowErr.throwException(ExceptionCode.USER_ID_FORMAT_EXCEPTION);
        }
        //名字含有非法字符
        if (name.indexOf('#') != -1) {
            return ThrowErr.throwException(ExceptionCode.USER_NAME_EXCEPTION);
        }
        //年龄不是整形数字
        int userAge = 0;
        try {
            userAge = Integer.parseInt(age);
        } catch (Exception e) {
            return ThrowErr.throwException(ExceptionCode.USER_AGE_FORMAT_EXCEPTION);
        }

        //年龄超出范围
        if (userAge < 0 || userAge > 120) {
            return ThrowErr.throwException(ExceptionCode.USER_AGE_SCOPE_EXCEPTION);
        }

        return new User(userId, name, userAge);
    }

}
