package com.bosssoft.hr.train.springmvc.controller;

import com.bosssoft.hr.train.springmvc.bean.Msg;
import com.bosssoft.hr.train.springmvc.bean.User;
import com.bosssoft.hr.train.springmvc.exception.BaseException;

import org.springframework.web.bind.annotation.*;

/**
 * @description:
 * @author:zyz
 * @time:2020/6/6--12:44
 */
@RestController
public class UserController {


    @GetMapping("/get")
    public Object get(@RequestParam(value = "id",required = false) Integer id) {
        if(id==null){
            throw new BaseException("some base exception occur : id is not exists", 400);
        }
        User user = new User();
        user.setId(id);
        user.setName("张三");
        return user;
    }

    @GetMapping("/exception")
    public Object occurBaseException() {
        throw new BaseException("some base exception occur : some other things", 500);
    }

    @ExceptionHandler(BaseException.class)
    public Msg handleException(BaseException e) {

        return new Msg().code(e.getCode()).msg(e.getMessage());
    }
}
