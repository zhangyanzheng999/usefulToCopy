package com.bosssoft.hr.train.service;

import com.bosssoft.hr.train.bean.DataDictionary;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @description:熔断处理
 * @author:zyz
 * @time:2020/6/16-21:19
 */
@Component
public class DdServiceClientHystrix implements DdServiceClient {
    @Override
    public DataDictionary getById(Integer id) {
        return null;
    }

    @Override
    public PageInfo<DataDictionary> getWithPage(Integer pageNum, Integer pageSize) {
        return null;
    }

    @Override
    public String update(DataDictionary dataDictionary) {
        return "方法update调用时服务器出错了";
    }

    @Override
    public String insert(DataDictionary dataDictionary) {
        return "方法insert调用时服务器出错了";
    }

    @Override
    public String deleteById(Integer id) {
        return "方法deleteById调用时服务器出错了";
    }

    @Override
    public String getToken(@RequestParam("userName") String userName,
                           @RequestParam("userPassword") String userPassword) {
        return "方法getToken调用时服务器出错了";
    }
}
