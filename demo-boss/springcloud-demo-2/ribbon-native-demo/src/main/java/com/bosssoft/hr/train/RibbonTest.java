package com.bosssoft.hr.train;

import com.netflix.loadbalancer.BaseLoadBalancer;
import com.netflix.loadbalancer.LoadBalancerBuilder;
import com.netflix.loadbalancer.RoundRobinRule;
import com.netflix.loadbalancer.Server;
import com.netflix.loadbalancer.reactive.LoadBalancerCommand;
import com.netflix.loadbalancer.reactive.ServerOperation;
import rx.Observable;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.Arrays;
import java.util.List;

/**
 * @description:
 * @author:zyz
 * @time:2020/6/16-14:14
 */
public class RibbonTest {
    public static void main(String[] args) {
        //服务列表
        List<Server> servers = Arrays.asList(new Server("localhost", 8080), new Server("localhost", 8081));
        //构建负载实例
        BaseLoadBalancer loadBalancer = LoadBalancerBuilder.newBuilder().buildFixedServerListLoadBalancer(servers);
        loadBalancer.setRule(new RoundRobinRule());
        //调用五次来测试效果
        for (int i = 0; i < 5; i++) {
            Object result = LoadBalancerCommand.builder().withLoadBalancer(loadBalancer).build().
                    submit(new ServerOperation<Object>() {
                        @Override
                        public Observable<Object> call(Server server) {
                            try {
                                String addr = "http://" + server.getHost() + ":" + server.getPort() + "/stu";
                                System.out.println("调用地址:" + addr);
                                URL url = new URL(addr);
                                HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                                conn.setRequestMethod("GET");
                                conn.connect();
                                InputStream in = conn.getInputStream();
                                byte[] data = new byte[in.available()];
                                in.read(data);
                                return Observable.just(new String(data));
                            } catch (Exception e) {
                                return Observable.error(e);
                            }
                        }
                    }).toBlocking().first();
            System.out.println("调用结果:" + result);

        }
    }
}
