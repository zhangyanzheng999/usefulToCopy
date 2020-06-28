package com.bosssoft.hr.train.springboot.basic.example.util;


import com.bosssoft.hr.train.springboot.basic.example.data.convention.CommonResponse;

public final class ResponseUtil {
    private ResponseUtil(){}
    public static CommonResponse buildCommonResponse(String code,String message, Object body){
       CommonResponse  commonResponse=    new CommonResponse(code,message,body);
       return  commonResponse;
    }

}
