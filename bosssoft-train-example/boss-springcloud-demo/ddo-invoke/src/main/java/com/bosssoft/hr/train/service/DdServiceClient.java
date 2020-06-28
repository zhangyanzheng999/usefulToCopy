package com.bosssoft.hr.train.service;

import com.bosssoft.hr.train.bean.DataDictionary;
import com.github.pagehelper.PageInfo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

/**
 * @description:
 * @author:zyz
 * @time:2020/6/16-21:18
 */

@FeignClient(value = "ddo-server", fallback = DdServiceClientHystrix.class)
public interface DdServiceClient {

    @GetMapping("/dd/get/{id}")
    DataDictionary getById(@PathVariable("id") Integer id);

    @GetMapping("/dd/get")
    PageInfo<DataDictionary> getWithPage(@RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
                                         @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize);


    @PutMapping("/dd/update")
    String update(@RequestBody DataDictionary dataDictionary);

    @PostMapping("/dd/insert")
    String insert(@RequestBody DataDictionary dataDictionary);

    @DeleteMapping("/dd/delete/{id}")
    String deleteById(@PathVariable("id") Integer id);

    @GetMapping("/login")
    String getToken(@RequestParam("userName") String userName,
                    @RequestParam("userPassword") String userPassword);
}
