package com.atguigu.tx;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @description:
 * @author:zyz
 * @time:2020/5/17--13:58
 */
@Service
public class UserService {
    @Autowired
    private UserDao userDao;


    @Transactional
    public void insertUser(){
        userDao.insert();
        System.out.println("插入完成....");
        int i=10/0;
    }
}
