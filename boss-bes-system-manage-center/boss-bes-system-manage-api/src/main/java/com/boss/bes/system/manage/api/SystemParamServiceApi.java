package com.boss.bes.system.manage.api;

import boss.brs.xtrain.dataconvention.convention.CommonRequest;
import boss.brs.xtrain.dataconvention.convention.CommonResponse;
import com.boss.bes.system.manage.api.common.CommonCRUDApi;
import com.boss.bes.system.manage.mapper.SystemParamMapper;
import com.boss.bes.system.manage.pojo.dto.SystemParamDTO;
import com.boss.bes.system.manage.pojo.dto.SystemParamImportDTO;
import com.boss.bes.system.manage.pojo.entity.SystemParam;
import com.boss.bes.system.manage.pojo.query.SystemParamPageQuery;
import com.boss.bes.system.manage.pojo.vo.SystemParamTreeVO;
import com.boss.bes.system.manage.pojo.vo.SystemParamVO;
import io.swagger.annotations.ApiOperation;

import java.util.List;

/**
 * @description:系统参数的Api
 * @author:zyz
 * @time:2020/7/12-15:53
 */
public interface SystemParamServiceApi extends CommonCRUDApi<SystemParam, SystemParamDTO, SystemParamVO, SystemParamPageQuery, SystemParamMapper> {

    @ApiOperation("批量导入")
    CommonResponse<String> multiInsert(CommonRequest<List<SystemParamImportDTO>> commonRequest);



    @ApiOperation("查询全部参数组成树")
    CommonResponse<List<SystemParamTreeVO>> queryTree();
}
