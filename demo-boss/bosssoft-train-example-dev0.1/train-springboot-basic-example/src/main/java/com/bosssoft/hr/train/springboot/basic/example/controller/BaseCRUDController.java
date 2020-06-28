package com.bosssoft.hr.train.springboot.basic.example.controller;

import com.bosssoft.hr.train.springboot.basic.example.data.convention.CommonResponse;
import com.bosssoft.hr.train.springboot.basic.example.service.BaseCURDService;
import org.springframework.web.bind.annotation.RequestBody;
import javax.validation.Valid;
import com.bosssoft.hr.train.springboot.basic.example.util.ResponseUtil;

/**
 * @class BaseCRUDController
 * @classdesc
 * @author Administrator
 * @date 2020-6-26  20:08
 * @version 1.0.0
 * @see
 * @since
 */
public abstract class BaseCRUDController<D,T,Q,M,V> extends AbstractController {
    protected BaseCURDService<D,T,Q,M> service;
    public  CommonResponse<Integer> create(@RequestBody @Valid D dtoParam){
         Integer ret=this.service.save(dtoParam);
         return   ResponseUtil.buildCommonResponse("","",ret);
    }

    public  CommonResponse<V> query(@RequestBody @Valid Q queryParam){
        this.doPagination();
        Object returnDto= service.query(queryParam);
        V vo=doObjectTransf(returnDto);
       return  ResponseUtil.buildCommonResponse("","",vo);

    }

    /**
     * @param: service 层返回的dto对象
     * @return: dto转化为controller 层需要的VO对象
     * @see
     * @since
     */

    protected  abstract V doObjectTransf(Object returnDto);

    public  CommonResponse update(@RequestBody @Valid D dtoParam){
        Integer ret=this.service.update(dtoParam);
        return   ResponseUtil.buildCommonResponse("","",ret);
    }

    public CommonResponse delete(@RequestBody @Valid D dtoParam){
        Integer ret=this.service.update(dtoParam);
        return   ResponseUtil.buildCommonResponse("","",ret);
    }



}
