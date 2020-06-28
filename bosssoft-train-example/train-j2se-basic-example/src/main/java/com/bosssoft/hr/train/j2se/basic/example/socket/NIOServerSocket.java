package com.bosssoft.hr.train.j2se.basic.example.socket;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.util.Iterator;

/**
 * @description:
 * @author: Administrator
 * @create: 2020-05-28 22:25
 * @since
 **/
public class NIOServerSocket implements Starter {
    private static final Logger log = LoggerFactory.getLogger(NIOServerSocket.class);

    @Override
    public boolean start() {
        ServerSocketChannel serverSocketChannel = null;
        Selector selector = null;
        try {
            //创建serverSocketChannel，监听8888端口
            serverSocketChannel = ServerSocketChannel.open();
            serverSocketChannel.bind(new InetSocketAddress(9898));
            //设置为非阻塞
            serverSocketChannel.configureBlocking(false);
            // 为socketChannel注册selector
            selector = Selector.open();
            serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);
            log.info("服务端开始工作");

            while (selector.select() > 0) {
                // 获取所有事件
                Iterator<SelectionKey> iterator = selector.selectedKeys().iterator();
                while (iterator.hasNext()) {
                    SelectionKey sk = iterator.next();
                    //判断什么事件就绪
                    if (sk.isAcceptable()) {
                        SocketChannel socketChannel = serverSocketChannel.accept();
                        socketChannel.configureBlocking(false);
                        socketChannel.register(selector, SelectionKey.OP_READ);
                    } else if (sk.isReadable()) {
                        SocketChannel socketChannel = (SocketChannel) sk.channel();
                        //读取数据
                        ByteBuffer buffer = ByteBuffer.allocate(1024);
                        int len = 0;
                        while ((len = socketChannel.read(buffer)) > 0) {
                            buffer.flip();
                            String context = new String(buffer.array(), 0, len);
                            log.info(context);
                            buffer.clear();
                        }
                        //回复一句 Hello Client
                        buffer.put("Hello Client".getBytes());
                        buffer.flip();
                        socketChannel.write(buffer);

                        socketChannel.close();
                    }
                    //用完删掉
                    iterator.remove();
                }
            }

            return true;
        } catch (IOException e) {
            log.error("socket连接异常:{}", e);
        } finally {
            try {
                serverSocketChannel.close();
                selector.close();
            } catch (IOException e) {
                log.error("socket关闭异常:{}", e);
            }
        }
        return false;
    }
}
