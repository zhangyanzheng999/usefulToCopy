package com.bosssoft.hr.train.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * @description:
 * @author:zyz
 * @time:2020/6/16-19:10
 */
@Service
public class ComputeService {
    @Autowired
    RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "hiError")
    public String compute(Integer a, Integer b) {
        return restTemplate.getForEntity("http://COMPUTE-SERVICE/api/compute/add?a=" + a + "&b=" + b, String.class).getBody();
    }

    public String hiError(Integer a, Integer b) {

        return "sorry there is an error";
    }
}
