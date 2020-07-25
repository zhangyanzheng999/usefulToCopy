package com.boss.bes.system.manage.api.common;

import boss.brs.xtrain.dataconvention.convention.CommonRequest;
import boss.brs.xtrain.dataconvention.convention.CommonResponse;
import com.boss.bes.system.manage.pojo.dto.common.BaseDeleteDTO;
import com.boss.bes.system.manage.pojo.query.common.BaseQuery;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @description: 封装基础的crudAPI, 用来服务间调用
 * @author:zyz
 * @time:2020/7/6-19:54
 */
public interface CommonCRUDApi<T, D, V, Q, M> {

    /**
     * 批量查询
     *
     * @param commonRequest
     * @return
     */
    @ApiOperation("用来分页查询信息 ")
    CommonResponse<PageInfo<V>> queryWithPage(@RequestBody CommonRequest<Q> commonRequest);

    @ApiOperation("用来查询信息进行展示")
    CommonResponse<V> query(@RequestBody CommonRequest<BaseQuery> commonRequest);
    /**
     * 更新信息
     *
     * @param commonRequest
     * @return
     */
    @ApiOperation("用来更新")
    CommonResponse<String> update(@RequestBody CommonRequest<D> commonRequest);

    /**
     * 插入信息
     *
     * @param commonRequest
     * @return
     */
    @ApiOperation("用来插入")
    CommonResponse<String> insert(@RequestBody CommonRequest<D> commonRequest);

    /**
     * 通过id和version进行删除
     *
     * @param commonRequest
     * @return
     */
    @ApiOperation("用来删除")
    CommonResponse<String> delete(@RequestBody CommonRequest<BaseDeleteDTO> commonRequest);

    /**
     * 批量删除
     *
     * @param commonRequest
     * @return
     */
    @ApiOperation("用来批量删除")
    CommonResponse<String> multiDelete(@RequestBody CommonRequest<List<D>> commonRequest);

    @ApiOperation("用来验证code是否使用过")
    CommonResponse<Boolean> validateCode(@RequestParam("code") String code);


    @ApiOperation("用来验证name是否使用过")
    CommonResponse<Boolean> validateName(@RequestParam("name") String name);
}
