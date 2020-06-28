package com.bosssoft.hr.train.controller;

import com.bosssoft.hr.train.dto.HouseInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

/**
 * @description:
 * @author:zyz
 * @time:2020/6/16-14:48
 */
@RestController
public class HouseClientController {
    @Autowired
    RestTemplate restTemplate;

    @GetMapping("/call/data")
    public HouseInfo getData(@RequestParam("name") String name) {
        return restTemplate.getForObject("http://localhost:8082/house/data?name=" + name, HouseInfo.class);
    }

    @GetMapping("/call/data/{name}")
    public String getData2(@PathVariable("name") String name) {
        return restTemplate.getForObject("http://localhost:8082/house/data/{name}", String.class, name);
    }

    @GetMapping("/call/dataEntity")
    public HouseInfo getDataEntity(@RequestParam("name") String name) {
        ResponseEntity<HouseInfo> responseEntity = restTemplate.getForEntity("http://localhost:8082/house/data?name=" + name, HouseInfo.class);
        return responseEntity.getBody();
    }

    @PostMapping("/call/save")
    public Long add(){
        HouseInfo houseInfo=new HouseInfo(2L,"福州","高新区","XXX");
        Long id = restTemplate.postForObject("http://localhost:8082/house/save", houseInfo, Long.class);
        return id;
    }
}
