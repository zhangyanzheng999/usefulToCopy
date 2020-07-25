package com.boss.bes.system.manage.controller;

import boss.bes.log.annotation.LogApi;
import boss.bes.log.util.BuildResponse;
import boss.brs.xtrain.dataconvention.convention.CommonRequest;
import boss.brs.xtrain.dataconvention.convention.CommonResponse;
import com.boss.bes.system.manage.api.OrganizationServiceApi;
import com.boss.bes.system.manage.controller.common.BaseCRUDController;
import com.boss.bes.system.manage.mapper.OrganizationMapper;
import com.boss.bes.system.manage.pojo.dto.OrganizationDTO;
import com.boss.bes.system.manage.pojo.dto.common.BaseDeleteDTO;
import com.boss.bes.system.manage.pojo.entity.Organization;
import com.boss.bes.system.manage.pojo.query.common.BasePageQuery;
import com.boss.bes.system.manage.pojo.query.common.BaseQuery;
import com.boss.bes.system.manage.pojo.vo.OrganizationVO;
import com.boss.bes.system.manage.pojo.vo.common.BaseTreeVO;
import com.boss.bes.system.manage.service.OrgService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
 * @description:这个是组织机构的控制器
 * @author:zyz
 * @time:2020/7/4-15:48
 */

@RestController
@RequestMapping("/education/bes/v1/system-manager-center/org")
public class OrganizationController extends BaseCRUDController<Organization, OrganizationDTO, OrganizationVO, BasePageQuery, OrganizationMapper> implements OrganizationServiceApi {
    @Autowired
    OrgService orgService;

    @PostMapping("/queryWithPage")
    @Override
    public CommonResponse<PageInfo<OrganizationVO>> queryWithPage(@RequestBody CommonRequest<BasePageQuery> orgPageQueryCommonRequest) {
        return BuildResponse.build("200", this.baseCRUDService.queryWithPage(orgPageQueryCommonRequest.getBody(), Organization.class, OrganizationVO.class));
    }

    @LogApi
    @Override
    @PostMapping("/delete")
    public CommonResponse<String> delete(@RequestBody CommonRequest<BaseDeleteDTO> orgDeleteDTOCommonRequest) {
        return super.delete(orgDeleteDTOCommonRequest, Organization.class);
    }

    @LogApi
    @Override
    @PostMapping("/query")
    public CommonResponse<OrganizationVO> query(@RequestBody CommonRequest<BaseQuery> commonRequest) {
        return super.query(commonRequest, Organization.class, OrganizationVO.class);
    }

    @LogApi
    @Override
    @PutMapping("/update")
    public CommonResponse<String> update(@RequestBody CommonRequest<OrganizationDTO> organizationDTOCommonRequest) {
        return super.update(organizationDTOCommonRequest);
    }

    @LogApi
    @Override
    @PostMapping("/insert")
    public CommonResponse<String> insert(@RequestBody CommonRequest<OrganizationDTO> organizationDTOCommonRequest) {
        return super.insert(organizationDTOCommonRequest, Organization.class);
    }

    @LogApi
    @Override
    @PostMapping(value = "/multiDelete")
    public CommonResponse<String> multiDelete(@RequestBody CommonRequest<List<OrganizationDTO>> commonRequest) {
        return super.multiDelete(commonRequest, Organization.class);
    }

    @Override
    @PostMapping("/queryAll")
    public CommonResponse<List<OrganizationVO>> queryAll(@RequestBody CommonRequest<Long> commonRequest) {
        return BuildResponse.build("200", orgService.queryAll(commonRequest.getBody()));
    }


    @Override
    @GetMapping("/queryTree")
    public CommonResponse<List<BaseTreeVO>> queryTree() {
        return BuildResponse.build("200", orgService.queryTree());
    }


    @Override
    @GetMapping("/getOrgName")
    public CommonResponse<String> getOrgName(@RequestParam("id") Long id) {
        return BuildResponse.build("200",orgService.getOrgName(id));
    }


    /**
     * 下面两个方法是为了检验的
     */

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
