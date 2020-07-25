package boss.brs.xtrain.dataconvention.controller;



import boss.brs.xtrain.dataconvention.convention.CommonResponse;
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
    CommonResponse<Integer> create(@RequestBody @Valid D dtoParam);
    /**
     * @param: 
     * @return: 
     * @see
     * @since
     */
    CommonResponse<V> query(@RequestBody @Valid Q queryParam);
    /**
     * @param: 
     * @return: 
     * @see
     * @since
     */
    CommonResponse update(@RequestBody @Valid D dtoParam);
    /**
     * @param: 
     * @return:
     * @see
     * @since
     */
    CommonResponse delete(@RequestBody @Valid D dtoParam);
}
