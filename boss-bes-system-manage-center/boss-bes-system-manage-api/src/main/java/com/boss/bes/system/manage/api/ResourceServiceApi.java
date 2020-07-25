package com.boss.bes.system.manage.api;

import boss.brs.xtrain.dataconvention.convention.CommonResponse;
import com.boss.bes.system.manage.api.common.CommonCRUDApi;
import com.boss.bes.system.manage.mapper.ResourceMapper;
import com.boss.bes.system.manage.pojo.dto.ResourceDTO;
import com.boss.bes.system.manage.pojo.entity.Resource;
import com.boss.bes.system.manage.pojo.query.ResourcePageQuery;
import com.boss.bes.system.manage.pojo.vo.ResourceTreeVO;
import com.boss.bes.system.manage.pojo.vo.ResourceVO;
import io.swagger.annotations.ApiOperation;

import java.util.List;

/**
 * @description:资源模块
 * @author:zyz
 * @time:2020/7/10-14:31
 */
public interface ResourceServiceApi extends CommonCRUDApi<Resource, ResourceDTO, ResourceVO, ResourcePageQuery, ResourceMapper> {

    @ApiOperation("查询全部资源组成树")
    CommonResponse<List<ResourceTreeVO>> queryTree();
}
