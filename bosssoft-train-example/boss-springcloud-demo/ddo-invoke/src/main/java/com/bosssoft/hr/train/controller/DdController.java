package com.bosssoft.hr.train.controller;

import com.bosssoft.hr.train.bean.DataDictionary;
import com.bosssoft.hr.train.service.DdServiceClient;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;


/**
 * @description:
 * @author:zyz
 * @time:2020/6/16-21:25
 */
@RestController

public class DdController {


    @Autowired
    DdServiceClient ddServiceClient;

    @GetMapping("/dd/get/{id}")
    public DataDictionary getById(@PathVariable("id") Integer id) {
        return ddServiceClient.getById(id);
    }

    @GetMapping("/dd/get")
    public PageInfo<DataDictionary> getWithPage(@RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
                                                @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize) {
        return ddServiceClient.getWithPage(pageNum, pageSize);
    }

    @PutMapping("/dd/update")
    public String update(@RequestBody DataDictionary dataDictionary) {
        return ddServiceClient.update(dataDictionary);
    }

    @PostMapping("/dd/insert")
    public String insert(@RequestBody DataDictionary dataDictionary) {
        return ddServiceClient.insert(dataDictionary);
    }

    @DeleteMapping("/dd/delete/{id}")
    public String deleteById(@PathVariable("id") Integer id) {
        return ddServiceClient.deleteById(id);
    }

    @GetMapping("/login")
    public String getToken(@RequestParam("userName") String userName,
                           @RequestParam("userPassword") String userPassword) {
        return ddServiceClient.getToken(userName, userPassword);
    }

    @Value("${test}")
    String test;

    @GetMapping("/test")
    public String getTest() {
        return "test---->" + test;
    }
}
