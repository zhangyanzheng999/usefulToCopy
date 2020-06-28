package com.bosssoft.hr.train.springboot.basic.example.controller;

import com.bosssoft.hr.train.springboot.basic.example.data.convention.CommonResponse;
import org.springframework.web.bind.annotation.RequestBody;
import javax.validation.Valid;

/**
 * @class CommonCRUDApi
 * @classdesc
 * @author Administrator
 * @date 2020-6-26  22:09
 * @version 1.0.0
 * @see
 * @since
 */
public interface CommonCRUDApi<D,T,Q,M,V>  {
    /**
     * @param: 
     * @return: 
     * @see
     * @since
     */
    public CommonResponse<Integer> create(@RequestBody @Valid D dtoParam);
    /**
     * @param: 
     * @return: 
     * @see
     * @since
     */
    public  CommonResponse<V> query(@RequestBody @Valid Q queryParam);
    /**
     * @param: 
     * @return: 
     * @see
     * @since
     */
    public  CommonResponse update(@RequestBody @Valid D dtoParam);
    /**
     * @param: 
     * @return:
     * @see
     * @since
     */
    public CommonResponse delete(@RequestBody @Valid D dtoParam);
}
