package com.boss.bes.system.manage.api;

import boss.brs.xtrain.dataconvention.convention.CommonResponse;
import com.boss.bes.system.manage.api.common.CommonCRUDApi;
import com.boss.bes.system.manage.mapper.PositionMapper;
import com.boss.bes.system.manage.pojo.dto.PositionDTO;
import com.boss.bes.system.manage.pojo.entity.Position;
import com.boss.bes.system.manage.pojo.query.PositionPageQuery;
import com.boss.bes.system.manage.pojo.vo.PositionVO;
import io.swagger.annotations.ApiOperation;

import java.util.List;

/**
 * @description:职位的Api
 * @author:zyz
 * @time:2020/7/12-10:14
 */
public interface PositionServiceApi extends CommonCRUDApi<Position, PositionDTO, PositionVO, PositionPageQuery, PositionMapper> {


    @ApiOperation("根据公司Id拿到该公司下的职位")
    CommonResponse<List<PositionVO>> queryPositionByCompanyId(Long companyId);
}
