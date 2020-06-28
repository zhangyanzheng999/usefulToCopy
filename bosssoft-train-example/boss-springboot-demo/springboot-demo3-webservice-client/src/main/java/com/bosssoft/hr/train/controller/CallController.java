package com.bosssoft.hr.train.controller;

import com.bosssoft.hr.train.service.CallWebService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description:
 * @author:zyz
 * @time:2020/6/9--13:45
 */
@RestController
public class CallController {

    @Autowired
    private CallWebService callWebService;

    @GetMapping("/webservice")
    public Object get(@RequestParam("word") String word) {
        String webUrl = "http://www.webxml.com.cn/WebServices/TranslatorWebService.asmx?wsdl";
        String methodName = "getEnCnTwoWayTranslator";

        return callWebService.callWebService(webUrl, methodName, word);
    }
}
