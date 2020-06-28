package com.atguigu.ext;

import javafx.application.Application;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

/**
 * @description:
 * @author:zyz
 * @time:2020/5/17--19:46
 */

@Service
public class UserService {
    @EventListener(classes= ApplicationEvent.class)
    public void listen(ApplicationEvent applicationEvent){
        System.out.println("UserService.listen...监听到的事件:"+applicationEvent);
    }
}
