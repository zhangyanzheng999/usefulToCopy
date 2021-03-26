package com.atguigu.amqp.service;

import com.atguigu.amqp.bean.Book;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

/**
 * @description:
 * @author:zyz
 * @time:2021/3/24-15:57
 */
@Service
public class BookService {
    @RabbitListener(queues = "atguigu.news")
    public void receive(Book book) {
        System.out.println("收到消息:" + book);
    }

    @RabbitListener(queues = "atguigu")
    public void receive02(Message message) {
        System.out.println(message.getBody());
        System.out.println(message.getMessageProperties());
    }
}
