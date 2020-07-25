package com.boss.bes.system.manage.controller;

import boss.brs.xtrain.dataconvention.convention.CommonRequest;
import boss.brs.xtrain.dataconvention.convention.CommonResponse;
import com.boss.bes.system.manage.api.RoleServiceApi;
import com.boss.bes.system.manage.controller.common.BaseCRUDController;
import com.boss.bes.system.manage.mapper.RoleMapper;
import com.boss.bes.system.manage.pojo.dto.RoleDTO;
import com.boss.bes.system.manage.pojo.dto.common.BaseDeleteDTO;
import com.boss.bes.system.manage.pojo.entity.Role;
import com.boss.bes.system.manage.pojo.query.RolePageQuery;
import com.boss.bes.system.manage.pojo.query.RoleQuery;
import com.boss.bes.system.manage.pojo.query.RoleTreeQuery;
import com.boss.bes.system.manage.pojo.vo.RoleVO;
import com.boss.bes.system.manage.pojo.vo.common.BaseTreeVO;
import com.boss.bes.system.manage.service.RoleService;
import com.boss.bes.system.manage.util.BuildResponse;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @description:角色控制器
 * @author:zyz
 * @time:2020/7/11-19:51
 */
@RestController
@RequestMapping("/education/bes/v1/system-manager-center/role")
public class RoleController extends BaseCRUDController<Role, RoleDTO, RoleVO, RolePageQuery, RoleMapper> implements RoleServiceApi {

    @Autowired
    RoleService roleService;

    @Override
    @PostMapping("/queryWithPage")
    public CommonResponse<PageInfo<RoleVO>> queryWithPage(@RequestBody CommonRequest<RolePageQuery> commonRequest) {
        return BuildResponse.build("200",roleService.queryAllWithPageAndCompanyAndOrg(commonRequest.getBody()));
    }

    /**
     * 这个参数不能使用BaseQuery因为公司Id会影响
     * @param commonRequest
     * @return
     */
    @PostMapping("/query")
    public CommonResponse<RoleVO> queryForRole(@RequestBody CommonRequest<RoleQuery> commonRequest) {
        return BuildResponse.build("200",roleService.queryForRole(commonRequest.getBody()));
    }

    @Override
    @GetMapping("/queryRoleByByCompanyId")
    public CommonResponse<List<RoleVO>> queryRoleByByCompanyId(@RequestParam("companyId") Long companyId) {
        return BuildResponse.build("200",roleService.queryRoleByByCompanyId(companyId));
    }

    @Override
    @PostMapping("/delete")
    public CommonResponse<String> delete(@RequestBody CommonRequest<BaseDeleteDTO> commonRequest) {
        return super.delete(commonRequest, Role.class);
    }

    @Override
    @PostMapping("/multiDelete")
    public CommonResponse<String> multiDelete(@RequestBody CommonRequest<List<RoleDTO>> commonRequest) {
        return super.multiDelete(commonRequest, Role.class);
    }

    @Override
    @PutMapping("/update")
    public CommonResponse<String> update(@RequestBody CommonRequest<RoleDTO> commonRequest) {
        return super.update(commonRequest);
    }

    @Override
    @PostMapping("/insert")
    public CommonResponse<String> insert(@RequestBody CommonRequest<RoleDTO> commonRequest) {
        return super.insert(commonRequest);
    }


    @Override
    @PostMapping("/queryCompanyForTree")
    public CommonResponse<List<BaseTreeVO>> queryCompanyForTree(@RequestBody CommonRequest<RoleTreeQuery> commonRequest) {
        return BuildResponse.build("200",roleService.queryCompanyForTree(commonRequest.getBody()));
    }


    @Override
    @PostMapping("/generatorCode")
    public CommonResponse<Long> generatorCode() {
        return BuildResponse.build("200",roleService.generatorCode());
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
