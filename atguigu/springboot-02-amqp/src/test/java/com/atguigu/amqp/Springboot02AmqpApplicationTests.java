package com.atguigu.amqp;

import com.atguigu.amqp.bean.Book;
import org.junit.jupiter.api.Test;
import org.springframework.amqp.core.AmqpAdmin;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@SpringBootTest
class Springboot02AmqpApplicationTests {
    @Autowired
    RabbitTemplate rabbitTemplate;

    @Test
    void contextLoads() {
        //Message需要自己构造一个;定义消息体内容和消息头
        //rabbitTemplate.send(exchange,routeKey,message);

        //object默认当成消息体 只需要传入要发送的对象，自动序列化发送给rabbitmq
        //rabbitTemplate.convertAndSend(exchange,routeKey,object);

        Map<String, Object> map = new HashMap<>();
        map.put("msg", "这是第一个消息");
        map.put("data", Arrays.asList("helloword", 123, true));
        //对象被默认序列化以后发送出去
        rabbitTemplate.convertAndSend("exchange.direct", "atguigu.news", new Book("西游记", "吴承恩"));
    }

    @Test
    void receive() {
        Object msg = rabbitTemplate.receiveAndConvert("atguigu.news");
        System.out.println(msg.getClass());
        System.out.println(msg);
    }

    /**
     * 广播
     */
    @Test
    void sendMsg() {
        rabbitTemplate.convertAndSend("exchange.fanout", "", new Book("红楼梦", "曹雪芹"));
    }

    @Autowired
    AmqpAdmin amqpAdmin;

    @Test
    void createExchange() {

        // amqpAdmin.declareExchange(new DirectExchange("amqpadmin.exchange"));

        //amqpAdmin.declareQueue(new Queue("amqpadmin.queue", true));

        amqpAdmin.declareBinding(new Binding("amqpadmin.queue", Binding.DestinationType.QUEUE, "amqpadmin.exchange", "amqp.haha", null));
        System.out.println("创建完成");
    }
}
