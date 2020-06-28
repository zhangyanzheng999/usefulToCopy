package com.bosssoft.hr.train.socket;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.websocket.*;
import javax.websocket.server.ServerEndpoint;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @description:
 * @author:zyz
 * @time:2020/6/9--9:01
 */
@Component
@ServerEndpoint("/websocket")
public class MyWebSocketServer {
    /**
     * 存放所有在线客户端
     */
    private static Map<String, Session> clients = new ConcurrentHashMap<>();

    private static final Logger log = LoggerFactory.getLogger(MyWebSocketServer.class);

    @OnOpen
    public void onOpen(Session session) {
        log.info("有新的客户端连接了,id为：" + session.getId());
        //加入到map中
        clients.put(session.getId(), session);
    }

    @OnClose
    public void onClose(Session session) {
        log.info("有用户离开了,id为：" + session.getId());
        clients.remove(session.getId());
    }

    @OnError
    public void onError(Throwable throwable) {
        log.error("有错误发生了", throwable);
    }

    /**
     * 接收客户端的消息
     */
    @OnMessage
    public void onMessage(String message) {
        log.info("服务端收到客户端发来的消息:" + message);
        if (message.indexOf("server") != -1) {
            message = message.replace("server", "client");
        }
        sendMessage(message);
    }


    /**
     * 群发消息
     *
     * @param message
     */
    public void sendMessage(String message) {
        for (Map.Entry<String, Session> client : clients.entrySet()) {
            client.getValue().getAsyncRemote().sendText(message);
        }
    }

}
