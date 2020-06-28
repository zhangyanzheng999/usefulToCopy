package com.bosssoft.hr.train.service;

public interface CallWebService {

    Object callWebService(String wsdUrl, String operationName, String... params);

}
