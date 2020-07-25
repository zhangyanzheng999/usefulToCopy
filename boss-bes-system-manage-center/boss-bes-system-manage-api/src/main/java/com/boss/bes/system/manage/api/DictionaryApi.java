package com.boss.bes.system.manage.api;

import boss.brs.xtrain.dataconvention.convention.CommonRequest;
import boss.brs.xtrain.dataconvention.convention.CommonResponse;
import com.boss.bes.system.manage.api.common.CommonCRUDApi;
import com.boss.bes.system.manage.mapper.DictionaryMapper;
import com.boss.bes.system.manage.pojo.dto.DictionaryDTO;
import com.boss.bes.system.manage.pojo.entity.Dictionary;
import com.boss.bes.system.manage.pojo.query.DictionaryPageQuery;
import com.boss.bes.system.manage.pojo.vo.DictionaryVO;
import io.swagger.annotations.ApiOperation;

import java.util.List;

/**
 * @description:数据字典的Api
 * @author:zyz
 * @time:2020/7/14-16:24
 */
public interface DictionaryApi extends CommonCRUDApi<Dictionary, DictionaryDTO, DictionaryVO, DictionaryPageQuery, DictionaryMapper> {
    @ApiOperation("系统参数的所有类型")
    CommonResponse<List<Dictionary>> getParamType();
    @ApiOperation("拿到所有的数据字典--》可以按照组织Id拿")
    CommonResponse<List<DictionaryVO>> getAllDictionary(CommonRequest<Long> commonRequest);
}
