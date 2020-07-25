package boss.brs.xtrain.dataconvention.controller;


import boss.brs.xtrain.dataconvention.convention.CommonResponse;
import boss.brs.xtrain.dataconvention.convention.head.ResponseHead;
import boss.brs.xtrain.dataconvention.service.BaseCURDService;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;

/**
 * @class BaseCRUDController
 * @classdesc
 * @author Xiong
 * @date 2020-07-01 21:05
 * @version 1.0.0
 * @see
 * @since
 */
public abstract class BaseCRUDController<D,T,Q,M,V> extends AbstractController implements CommonCRUDApi<D,T,Q,M,V>{
    protected BaseCURDService<D,T,Q,M> service;

    /**
     *
     * @param dtoParam
     * 需要对参数的头部信息进行提取，并设置为commonResponse
     * @return CommonResponse
     */
    @Override
    public CommonResponse<Integer> create(@RequestBody @Valid D dtoParam){
         Integer ret=this.service.save(dtoParam);
         return   new CommonResponse<>(ret, new ResponseHead());
    }

    /**
     *
     * @param queryParam
     * 需要对参数的头部信息进行提取，并设置为commonResponse,还要提取查询分页参数
     * @return CommonResponse
     */
    @Override
    public  CommonResponse<V> query(@RequestBody @Valid Q queryParam){
        this.doBeforePagination(1, 1);
        Object returnDto= service.query(queryParam);
        V vo=doObjectTransf(returnDto);
       return  new CommonResponse<>(vo, new ResponseHead());

    }

    /**
     * @param: service 层返回的dto对象
     * @return: dto转化为controller 层需要的VO对象
     * @see
     * @since
     */

    protected  abstract V doObjectTransf(Object returnDto);

    @Override
    public  CommonResponse update(@RequestBody @Valid D dtoParam){
        Integer ret=this.service.update(dtoParam);
        return   new CommonResponse<>(ret, new ResponseHead());
    }

    /**
     *
     * @param dtoParam
     * 需要对参数的头部信息进行提取，并设置为commonResponse
     * @return CommonResponse
     */
    @Override
    public CommonResponse delete(@RequestBody @Valid D dtoParam){
        Integer ret=this.service.update(dtoParam);
        return   new CommonResponse<>(ret, new ResponseHead());
    }



}
