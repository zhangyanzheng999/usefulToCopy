package com.boss.bes.system.manage.controller.common;

import boss.bes.log.exception.code.enums.BaseCodeEnum;
import boss.bes.log.exception.type.BusinessException;
import boss.bes.log.util.BuildResponse;
import boss.brs.xtrain.dataconvention.convention.CommonRequest;
import boss.brs.xtrain.dataconvention.convention.CommonResponse;
import com.boss.bes.system.manage.api.common.CommonCRUDApi;
import com.boss.bes.system.manage.mapper.CommonMapper;
import com.boss.bes.system.manage.pojo.dto.common.BaseDeleteDTO;
import com.boss.bes.system.manage.pojo.query.common.BasePageQuery;
import com.boss.bes.system.manage.pojo.query.common.BaseQuery;
import com.boss.bes.system.manage.service.BaseCRUDService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;


/**
 * @description:封装基础的CRUD操作
 * @author:zyz
 * @time:2020/7/6-19:51
 */
public abstract class BaseCRUDController<T, D, V, Q extends BasePageQuery, M extends CommonMapper<T>> implements CommonCRUDApi<T, D, V, Q, M> {
    @Autowired
    protected BaseCRUDService<T, D, V, Q, M> baseCRUDService;

    /**
     * 这里子类要自己去实现update
     *
     * @param commonRequest
     * @return
     */
    @Override
    public CommonResponse<String> update(@RequestBody CommonRequest<D> commonRequest) {
        if (baseCRUDService.update(commonRequest.getBody()) > 0) {
            return BuildResponse.build("200", "update success");
        } else {
            throw new BusinessException(BaseCodeEnum.BASE_DATA_UPDATE_EXCEPTION);
        }
    }

    /**
     * 插入
     *
     * @param commonRequest
     * @return
     */
    @Override
    public CommonResponse<String> insert(@RequestBody CommonRequest<D> commonRequest) {
        if (baseCRUDService.save(commonRequest.getBody()) > 0) {
            return BuildResponse.build("200", "insert success");
        } else {
            throw new BusinessException(BaseCodeEnum.BASE_DATA_INSERT_EXCEPTION);
        }

    }

    /**
     * 插入的默认实现会自动生成Id和Version
     *
     * @param commonRequest
     * @return
     */
    public CommonResponse<String> insert(@RequestBody CommonRequest<D> commonRequest, Class<T> clz) {
        if (baseCRUDService.save(commonRequest.getBody(), clz) > 0) {
            return BuildResponse.build("200", "insert success");
        } else {
            throw new BusinessException(BaseCodeEnum.BASE_DATA_INSERT_EXCEPTION);
        }
    }

    /**
     * 进行查询，传入一个Query因为是一个乐观锁
     * @param commonRequest
     * @return
     */
    @Override
    public CommonResponse<V> query(@RequestBody CommonRequest<BaseQuery> commonRequest) {
        V result = baseCRUDService.query(commonRequest.getBody());
        if (result != null) {
            return BuildResponse.build("200", result);
        } else {
            throw new BusinessException(BaseCodeEnum.BASE_DATA_SELECT_EXCEPTION);
        }
    }

    /**
     * 通用查询方法
     *
     * @param commonRequest
     * @param entity
     * @param vo
     * @return
     */
    public CommonResponse<V> query(CommonRequest<BaseQuery> commonRequest, Class<T> entity, Class<V> vo) {
        // 先查询，如果查询为null，抛出异常
        V result = baseCRUDService.query(commonRequest.getBody(), entity, vo);
        if (result != null) {
            return BuildResponse.build("200", result);
        } else {
            throw new BusinessException(BaseCodeEnum.BASE_DATA_SELECT_EXCEPTION);
        }
    }


    @Override
    public CommonResponse<PageInfo<V>> queryWithPage(@RequestBody CommonRequest<Q> commonRequest) {

        return new CommonResponse<>();
    }

    /**
     * 默认实现一下，防止子类不实现报错
     *
     * @param commonRequest
     * @return
     */
    @Override
    public CommonResponse<String> multiDelete(@RequestBody CommonRequest<List<D>> commonRequest) {
        return null;
    }

    /**
     * 实现了BaseDTO的DTO可以使用这个方法
     *
     * @param commonRequest
     * @param clz
     * @return
     */
    public CommonResponse<String> multiDelete(CommonRequest<List<D>> commonRequest, Class<T> clz) {
        baseCRUDService.multiDelete(commonRequest.getBody(), clz);
        return BuildResponse.build("200", "multiDelete success");
    }

    @Override
    public CommonResponse<String> delete(@RequestBody CommonRequest<BaseDeleteDTO> commonRequest) {
        return null;
    }

    /**
     * 一个删除的默认实现
     *
     * @param commonRequest
     * @param clz
     * @return
     */
    public CommonResponse<String> delete(CommonRequest<? extends BaseDeleteDTO> commonRequest, Class<T> clz) {
        if (baseCRUDService.delete(commonRequest.getBody(), clz) > 0) {
            return BuildResponse.build("200", "删除成功");
        } else {
            throw new BusinessException(BaseCodeEnum.BASE_DATA_DELETE_EXCEPTION);
        }

    }

    /**
     * 用来验证Code是否使用过
     *
     * @param code
     * @return
     */
    @Override
    public CommonResponse<Boolean> validateCode(String code) {
        return BuildResponse.build("200", this.baseCRUDService.validateCode(code));
    }

    /**
     * 用来验证名字是否使用过
     *
     * @param name
     * @return
     */
    @Override
    public CommonResponse<Boolean> validateName(String name) {
        return BuildResponse.build("200", this.baseCRUDService.validateName(name));
    }
}
