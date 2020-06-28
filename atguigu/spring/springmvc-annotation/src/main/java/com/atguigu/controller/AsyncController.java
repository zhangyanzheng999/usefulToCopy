package com.atguigu.controller;

import com.atguigu.service.DeferredResultQueue;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.async.DeferredResult;

import java.util.UUID;
import java.util.concurrent.Callable;


@Controller
public class AsyncController {
    /**
     * 1������������Callable
     * 2��Spring�첽������Callable�ύ��TaskExecutor ʹ��һ��������߳�ִ��
     * 3��DispatcherServlet�����е�Filter�˳�web�������̣߳�����response���ִ�״̬
     * 4��Callable���ؽ����SpringMVC�����������ɷ����������ָ�֮ǰ�Ĵ���
     * 5������Callable���صĽ����SpringMVC����������ͼ��Ⱦ���̵�(��������->��ͼ��Ⱦ)
     *
     *
     *MyFirstInterceptor.preHandle  /springmvc_annotation/async01
     ���߳̿�ʼ....Thread[http-nio-8080-exec-7,5,main]==>1589877324516
     ���߳̽���....Thread[http-nio-8080-exec-7,5,main]==>1589877324519
     ==============DispatcherServlet�����е�Filter�˳�web�������߳�==========



     ================�ȴ�Callableִ��================
     ���߳̿�ʼ....Thread[MvcAsync1,5,main]==>1589877324533
     ���߳̿�ʼ....Thread[MvcAsync1,5,main]==>1589877326534
     ================Callableִ�����================
     MyFirstInterceptor.preHandle  /springmvc_annotation/async01
     MyFirstInterceptor.postHandle  (Callable��֮ǰ�ķ���ֵ����Ŀ�귽���ķ���ֵ)
     MyFirstInterceptor.afterCompletion

     �첽��������
        1)��ԭ��API��AsyncListener
        2)��SpringMVC:ʵ��AsyncHandlerInterceptor
     * @return
     */
    @ResponseBody
    @RequestMapping("/async01")
    public Callable<String> async01() {
        System.out.println("���߳̿�ʼ...." + Thread.currentThread() + "==>" + System.currentTimeMillis());
        Callable<String> callable = new Callable<String>() {
            public String call() throws Exception {
                System.out.println("���߳̿�ʼ...." + Thread.currentThread() + "==>" + System.currentTimeMillis());
                Thread.sleep(2000);
                System.out.println("���߳̿�ʼ...." + Thread.currentThread() + "==>" + System.currentTimeMillis());
                return "Callable<String> async01";
            }
        };
        System.out.println("���߳̽���...." + Thread.currentThread() + "==>" + System.currentTimeMillis());
        return callable;
    }



    @ResponseBody
    @RequestMapping("/createOrder")
    public DeferredResult<Object> createOrder(){
        DeferredResult<Object> deferredResult = new DeferredResult<Object>((long)3000,"create fail...");
        DeferredResultQueue.save(deferredResult);
        return deferredResult;
    }

    @ResponseBody
    @RequestMapping("/create")
    public String create(){
        //��������
        String order = UUID.randomUUID().toString();
        DeferredResult<Object> deferredResult = DeferredResultQueue.get();
        deferredResult.setResult(order);
        return "success===>"+order;
    }










}
