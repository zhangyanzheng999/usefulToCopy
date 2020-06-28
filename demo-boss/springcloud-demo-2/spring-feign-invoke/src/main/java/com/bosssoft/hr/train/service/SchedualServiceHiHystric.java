package com.bosssoft.hr.train.service;

import org.springframework.stereotype.Component;

/**
 * @description:
 * @author:zyz
 * @time:2020/6/16-19:50
 */
@Component
public class SchedualServiceHiHystric implements ComputeServiceClient  {
    @Override
    public String compute(Integer a, Integer b) {
        return "sorry there in an error can't compute:"+a+"---"+b;
    }
}
