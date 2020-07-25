package com.boss.bes.system.manage.controller;

import boss.bes.log.annotation.LogApi;
import boss.bes.log.util.BuildResponse;
import boss.brs.xtrain.dataconvention.convention.CommonRequest;
import boss.brs.xtrain.dataconvention.convention.CommonResponse;
import com.boss.bes.system.manage.api.CompanyServiceApi;
import com.boss.bes.system.manage.controller.common.BaseCRUDController;
import com.boss.bes.system.manage.mapper.CompanyMapper;
import com.boss.bes.system.manage.pojo.dto.CompanyDTO;
import com.boss.bes.system.manage.pojo.dto.common.BaseDeleteDTO;
import com.boss.bes.system.manage.pojo.entity.Company;
import com.boss.bes.system.manage.pojo.query.CompanyPageQuery;
import com.boss.bes.system.manage.pojo.query.common.BaseQuery;
import com.boss.bes.system.manage.pojo.query.common.BaseTreeQuery;
import com.boss.bes.system.manage.pojo.vo.CompanyTreeVO;
import com.boss.bes.system.manage.pojo.vo.CompanyVO;
import com.boss.bes.system.manage.service.CompanyService;
import com.boss.bes.system.manage.util.BeanUtil;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @description: 公司的控制器
 * @author:zyz
 * @time:2020/7/6-19:43
 */
@RestController
@RequestMapping("/education/bes/v1/system-manager-center/company")
public class CompanyController extends BaseCRUDController<Company, CompanyDTO, CompanyVO, CompanyPageQuery, CompanyMapper> implements CompanyServiceApi {


    @Autowired
    CompanyService companyService;


    @Override
    @PostMapping("/queryWithPage")
    public CommonResponse<PageInfo<CompanyVO>> queryWithPage(@RequestBody CommonRequest<CompanyPageQuery> commonRequest) {
        return BuildResponse.build("200", companyService.queryAllWithPageAndOrg(commonRequest.getBody()));
    }

    @LogApi
    @Override
    @PostMapping("/delete")
    public CommonResponse<String> delete(@RequestBody CommonRequest<BaseDeleteDTO> companyDeleteDTOCommonRequest) {
        return super.delete(companyDeleteDTOCommonRequest, Company.class);
    }

    @Override
    @PostMapping("/query")
    public CommonResponse<CompanyVO> query(@RequestBody CommonRequest<BaseQuery> commonRequest) {
        return super.query(commonRequest);
    }


    @Override
    @PutMapping("/update")
    public CommonResponse<String> update(@RequestBody CommonRequest<CompanyDTO> commonRequest) {
        return super.update(commonRequest);
    }


    @Override
    @PostMapping("/insert")
    public CommonResponse<String> insert(@RequestBody CommonRequest<CompanyDTO> commonRequest) {
        return super.insert(commonRequest, Company.class);
    }

    @Override
    @PostMapping("/multiDelete")
    public CommonResponse<String> multiDelete(@RequestBody CommonRequest<List<CompanyDTO>> commonRequest) {
        return super.multiDelete(commonRequest, Company.class);
    }

    @Override
    @GetMapping("/queryAll")
    public CommonResponse<List<CompanyVO>> queryAll() {
        return BuildResponse.build("200", companyService.queryAll());
    }


    @Override
    @PostMapping("/queryTree")
    public CommonResponse<List<CompanyTreeVO>> queryTree(@RequestBody CommonRequest<BaseTreeQuery> commonRequest) {
        return BuildResponse.build("200", companyService.queryTree(commonRequest.getBody()));
    }


    @Override
    @PostMapping("/queryCompanyByOrgId")
    public CommonResponse<List<CompanyVO>> queryCompanyByOrgId(@RequestBody CommonRequest<BaseTreeQuery> commonRequest){
        return BuildResponse.build("200", companyService.queryCompanyByOrgId(commonRequest.getBody()));
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


    @Override
    @GetMapping("/getCompanyNameById")
    public String getCompanyNameById(@RequestParam("id") Long id) {
        return companyService.getCompanyNameById(id);
    }


    @Override
    @PostMapping("/queryCompanyById")
    public CommonResponse<CompanyVO> queryCompanyById(@RequestBody CommonRequest<Long> commonRequest) {
        return BuildResponse.build("200", BeanUtil.copyData(companyService.getCompanyById(commonRequest.getBody()),CompanyVO.class));
    }
}
