package com.boss.bes.system.manage.controller;

import boss.bes.log.util.BuildResponse;
import boss.brs.xtrain.dataconvention.convention.CommonRequest;
import boss.brs.xtrain.dataconvention.convention.CommonResponse;
import com.boss.bes.system.manage.api.DepartmentServiceApi;
import com.boss.bes.system.manage.controller.common.BaseCRUDController;
import com.boss.bes.system.manage.mapper.DepartmentMapper;
import com.boss.bes.system.manage.pojo.dto.DepartmentDTO;
import com.boss.bes.system.manage.pojo.dto.common.BaseDeleteDTO;
import com.boss.bes.system.manage.pojo.entity.Department;
import com.boss.bes.system.manage.pojo.query.DepartmentPageQuery;
import com.boss.bes.system.manage.pojo.query.common.BaseQuery;
import com.boss.bes.system.manage.pojo.query.common.BaseTreeQuery;
import com.boss.bes.system.manage.pojo.vo.DepartmentTreeVO;
import com.boss.bes.system.manage.pojo.vo.DepartmentVO;
import com.boss.bes.system.manage.service.DepartmentService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @description: 部门信息的控制器
 * @author:zyz
 * @time:2020/7/9-14:40
 */
@RestController
@RequestMapping("/education/bes/v1/system-manager-center/department")
public class DepartmentController extends BaseCRUDController<Department, DepartmentDTO, DepartmentVO, DepartmentPageQuery, DepartmentMapper> implements DepartmentServiceApi {
    @Autowired
    DepartmentService departmentService;


    @Override
    @PostMapping("/queryWithPage")
    public CommonResponse<PageInfo<DepartmentVO>> queryWithPage(@RequestBody CommonRequest<DepartmentPageQuery> commonRequest) {
        return BuildResponse.build("200", departmentService.queryAllWithPageAndCompany(commonRequest.getBody()));
    }

    @Override
    @PostMapping("/delete")
    public CommonResponse<String> delete(@RequestBody CommonRequest<BaseDeleteDTO> commonRequest) {
        return super.delete(commonRequest, Department.class);
    }


    @Override
    @PostMapping("/query")
    public CommonResponse<DepartmentVO> query(@RequestBody CommonRequest<BaseQuery> commonRequest) {
        return super.query(commonRequest);
    }

    @Override
    @PostMapping("/multiDelete")
    public CommonResponse<String> multiDelete(@RequestBody CommonRequest<List<DepartmentDTO>> commonRequest) {
        return super.multiDelete(commonRequest, Department.class);
    }

    @Override
    @GetMapping("/queryDepartmentByCompanyIdWithOutSelf")
    public CommonResponse<List<DepartmentVO>> queryDepartmentByCompanyIdWithOutSelf(@RequestParam("companyId") Long companyId,
                                                                         @RequestParam("departmentId") Long departmentId) {

        return BuildResponse.build("200", departmentService.queryDepartmentByCompanyId(companyId, departmentId));
    }

    @Override
    @PutMapping("/update")
    public CommonResponse<String> update(@RequestBody CommonRequest<DepartmentDTO> commonRequest) {
        return super.update(commonRequest);
    }


    @Override
    @PostMapping("/insert")
    public CommonResponse<String> insert(@RequestBody CommonRequest<DepartmentDTO> commonRequest) {
        return super.insert(commonRequest, Department.class);
    }

    @Override
    @PostMapping("/queryTree")
    public CommonResponse<List<DepartmentTreeVO>> queryTree(@RequestBody CommonRequest<BaseTreeQuery> commonRequest) {
        return BuildResponse.build("200",departmentService.queryTree(commonRequest.getBody()));
    }


    @Override
    @GetMapping("/queryDepartmentByCompanyId")
    public CommonResponse<List<DepartmentVO>> queryDepartmentByCompanyId(@RequestParam("companyId") Long companyId) {
        return BuildResponse.build("200",departmentService.queryDepartmentByCompanyId(companyId));
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
