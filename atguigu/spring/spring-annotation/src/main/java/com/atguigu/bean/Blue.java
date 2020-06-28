package com.atguigu.bean;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class Blue {

    public Blue(){
        System.out.println("Blue...constructor...");
    }

    @PostConstruct
    public void init(){
        System.out.println("Blue....init...");
    }

    @PreDestroy
    public void destroy(){
        System.out.println("Blue...destroy...");
    }
}
