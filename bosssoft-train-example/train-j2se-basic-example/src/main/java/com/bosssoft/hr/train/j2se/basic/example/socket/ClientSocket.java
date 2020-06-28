package com.bosssoft.hr.train.j2se.basic.example.socket;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

/**
 * @param
 * @author: Administrator
 * @create: 2020-05-28 22:25
 * @since
 **/
public class ClientSocket implements Starter {
    private static final Logger log = LoggerFactory.getLogger(ClientSocket.class);

    @Override
    public boolean start() {
        SocketChannel socketChannel = null;
        try {
            // 绑定ip 端口号
            socketChannel = SocketChannel.open(new InetSocketAddress("127.0.0.1", 9898));
            // 非阻塞
            socketChannel.configureBlocking(false);
            // 缓冲区
            ByteBuffer buffer = ByteBuffer.allocate(1024);

            //给server发数据
            buffer.put("Hello Server".getBytes());
            buffer.flip();
            socketChannel.write(buffer);
            buffer.clear();

            //接收server数据
            int len = 0; //实际读取的字符数
            while ((len = socketChannel.read(buffer)) != -1) {
                buffer.flip();
                String context = new String(buffer.array(), 0, len);
                log.info(context);
                buffer.clear();
            }
            return true;
        } catch (IOException e) {
            log.error("socket连接异常:{}", e);
        } finally {
            if (socketChannel != null) {
                try {
                    socketChannel.close();
                } catch (IOException e) {
                    log.error("socket关闭异常:{}", e);
                }
            }
        }
        return false;
    }
}
