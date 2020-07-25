package com.boss.bes.system.manage.controller;

import boss.brs.xtrain.dataconvention.convention.CommonRequest;
import boss.brs.xtrain.dataconvention.convention.CommonResponse;
import com.boss.bes.system.manage.api.ResourceServiceApi;
import com.boss.bes.system.manage.controller.common.BaseCRUDController;
import com.boss.bes.system.manage.mapper.ResourceMapper;
import com.boss.bes.system.manage.pojo.dto.ResourceDTO;
import com.boss.bes.system.manage.pojo.dto.common.BaseDeleteDTO;
import com.boss.bes.system.manage.pojo.entity.Resource;
import com.boss.bes.system.manage.pojo.query.ResourcePageQuery;
import com.boss.bes.system.manage.pojo.query.common.BaseQuery;
import com.boss.bes.system.manage.pojo.vo.ResourceTreeVO;
import com.boss.bes.system.manage.pojo.vo.ResourceVO;
import com.boss.bes.system.manage.service.ResourceService;
import com.boss.bes.system.manage.util.BuildResponse;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @description:资源的控制器
 * @author:zyz
 * @time:2020/7/10-14:32
 */
@RestController
@RequestMapping("/education/bes/v1/system-manager-center/resource")
public class ResourceController extends BaseCRUDController<Resource, ResourceDTO, ResourceVO, ResourcePageQuery, ResourceMapper> implements ResourceServiceApi {

    @Autowired
    ResourceService resourceService;


    @Override
    @PostMapping("/queryWithPage")
    public CommonResponse<PageInfo<ResourceVO>> queryWithPage(@RequestBody CommonRequest<ResourcePageQuery> commonRequest) {
        return BuildResponse.build("200", resourceService.queryAllWithPageAndParent(commonRequest.getBody()));
    }

    @Override
    @PostMapping("/delete")
    public CommonResponse<String> delete(@RequestBody CommonRequest<BaseDeleteDTO> commonRequest) {
        return super.delete(commonRequest, Resource.class);
    }


    @Override
    @PostMapping("/multiDelete")
    public CommonResponse<String> multiDelete(@RequestBody CommonRequest<List<ResourceDTO>> commonRequest) {
        return super.multiDelete(commonRequest, Resource.class);
    }


    @Override
    @PostMapping("/query")
    public CommonResponse<ResourceVO> query(@RequestBody CommonRequest<BaseQuery> commonRequest) {
        return super.query(commonRequest);
    }

    @Override
    @GetMapping("/queryTree")
    public CommonResponse<List<ResourceTreeVO>> queryTree() {
        return BuildResponse.build("200", resourceService.queryTree());
    }


    @Override
    @PutMapping("/update")
    public CommonResponse<String> update(@RequestBody CommonRequest<ResourceDTO> commonRequest) {
        return super.update(commonRequest);
    }

    @Override
    @PostMapping("/insert")
    public CommonResponse<String> insert(@RequestBody CommonRequest<ResourceDTO> commonRequest) {
        return super.insert(commonRequest, Resource.class);
    }

    @Override
    @GetMapping("/validateName")
    public CommonResponse<Boolean> validateName(@RequestParam("name") String name) {
        return super.validateName(name);
    }

    @Override
    @GetMapping("/validateCode")
    public CommonResponse<Boolean> validateCode(@RequestParam("code") String code) {
        return super.validateCode(code);
    }
}
