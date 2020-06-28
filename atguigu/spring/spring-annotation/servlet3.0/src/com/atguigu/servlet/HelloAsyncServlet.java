package com.atguigu.servlet;

import javax.servlet.AsyncContext;
import javax.servlet.ServletException;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @description:
 * @author:zyz
 * @time:2020/5/19--16:01
 */
@WebServlet(value = "/async",asyncSupported = true)
public class HelloAsyncServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1、支持异步处理  asyncSupported = true
        //2、开启异步模式
        System.out.println("主线程开始..."+Thread.currentThread()+"===>"+System.currentTimeMillis());
        AsyncContext asyncContext = req.startAsync();
        //3、业务逻辑进行异步处理；开始异步处理
        asyncContext.start(new Runnable() {
            @Override
            public void run() {
                try {
                    System.out.println("副线程开始..."+Thread.currentThread()+"===>"+System.currentTimeMillis());
                    sayHello();

                    //获取到异步的上下文
                    AsyncContext reqAsyncContext = req.getAsyncContext();
                    //4、获取响应
                    ServletResponse response = reqAsyncContext.getResponse();
                    response.getWriter().write("hello async...");
                    asyncContext.complete();
                    System.out.println("副线程结束..."+Thread.currentThread()+"===>"+System.currentTimeMillis());
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        System.out.println("主线程结束..."+Thread.currentThread()+"===>"+System.currentTimeMillis());
    }

    public void sayHello() throws Exception{
        System.out.println(Thread.currentThread()+"processing..."+"===>"+System.currentTimeMillis());
        Thread.sleep(3000);
    }
}
