package com.bosssoft.hr.train.service.impl;

import com.bosssoft.hr.train.service.CallWebService;
import org.apache.cxf.endpoint.Client;
import org.apache.cxf.jaxws.endpoint.dynamic.JaxWsDynamicClientFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.Arrays;

/**
 * @description:
 * @author:zyz
 * @time:2020/6/9--13:34
 */
@Service
public class CallWebServiceImpl implements CallWebService {
    private static final Logger log = LoggerFactory.getLogger(CallWebServiceImpl.class);

    @Override
    public Object callWebService(String wsdUrl, String operationName, String... params) {
        JaxWsDynamicClientFactory jaxWsDynamicClientFactory = JaxWsDynamicClientFactory.newInstance();
        Client client = jaxWsDynamicClientFactory.createClient(wsdUrl);

        Object[] result;
        try {
            result = client.invoke(operationName, params);
            return result[0];
        } catch (Exception e) {
            log.error("链接：{},方法：{},参数:{},调用出错", wsdUrl, operationName, Arrays.asList(params), e);
            return e.toString();
        }

    }
}
