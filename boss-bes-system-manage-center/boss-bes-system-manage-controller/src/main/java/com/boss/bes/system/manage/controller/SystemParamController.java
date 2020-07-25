package com.boss.bes.system.manage.controller;


import boss.brs.xtrain.dataconvention.convention.CommonRequest;
import boss.brs.xtrain.dataconvention.convention.CommonResponse;
import com.boss.bes.system.manage.api.SystemParamServiceApi;
import com.boss.bes.system.manage.controller.common.BaseCRUDController;
import com.boss.bes.system.manage.mapper.SystemParamMapper;
import com.boss.bes.system.manage.pojo.dto.SystemParamDTO;
import com.boss.bes.system.manage.pojo.dto.SystemParamImportDTO;
import com.boss.bes.system.manage.pojo.dto.common.BaseDeleteDTO;
import com.boss.bes.system.manage.pojo.entity.SystemParam;
import com.boss.bes.system.manage.pojo.query.SystemParamPageQuery;
import com.boss.bes.system.manage.pojo.query.common.BaseQuery;
import com.boss.bes.system.manage.pojo.vo.SystemParamTreeVO;
import com.boss.bes.system.manage.pojo.vo.SystemParamVO;
import com.boss.bes.system.manage.service.SystemParamService;
import com.boss.bes.system.manage.util.BuildResponse;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @description:系统参数控制器
 * @author:zyz
 * @time:2020/7/12-15:58
 */
@RestController
@RequestMapping("/education/bes/v1/system-manager-center/systemParam")
public class SystemParamController extends BaseCRUDController<SystemParam, SystemParamDTO, SystemParamVO, SystemParamPageQuery, SystemParamMapper> implements SystemParamServiceApi {

    @Autowired
    SystemParamService systemParamService;

    @Override
    @PostMapping("/query")
    public CommonResponse<SystemParamVO> query(@RequestBody CommonRequest<BaseQuery> commonRequest) {
        return super.query(commonRequest, SystemParam.class, SystemParamVO.class);
    }

    @Override
    @PostMapping("/queryWithPage")
    public CommonResponse<PageInfo<SystemParamVO>> queryWithPage(@RequestBody CommonRequest<SystemParamPageQuery> commonRequest) {
        return BuildResponse.build("200", this.baseCRUDService.queryWithPage(commonRequest.getBody()));
    }

    @Override
    @PostMapping("/multiDelete")
    public CommonResponse<String> multiDelete(@RequestBody CommonRequest<List<SystemParamDTO>> commonRequest) {
        return super.multiDelete(commonRequest, SystemParam.class);
    }


    @Override
    @PostMapping("/delete")
    public CommonResponse<String> delete(@RequestBody CommonRequest<BaseDeleteDTO> commonRequest) {
        return super.delete(commonRequest, SystemParam.class);
    }


    @Override
    @PostMapping("/insert")
    public CommonResponse<String> insert(@RequestBody CommonRequest<SystemParamDTO> commonRequest) {
        return super.insert(commonRequest, SystemParam.class);
    }

    @Override
    @PutMapping("/update")
    public CommonResponse<String> update(@RequestBody CommonRequest<SystemParamDTO> commonRequest) {
        return super.update(commonRequest);
    }

    @Override
    @PostMapping("/multiInsert")
    public CommonResponse<String> multiInsert(@RequestBody CommonRequest<List<SystemParamImportDTO>> commonRequest) {
        systemParamService.multiInsert(commonRequest.getBody());
        return BuildResponse.build("200", "导入成功！");
    }


    @Override
    @GetMapping("/queryTree")
    public CommonResponse<List<SystemParamTreeVO>> queryTree() {

        return BuildResponse.build("200",systemParamService.queryTree());
    }
    @GetMapping("/getAllSystemParam")
    public CommonResponse<List<SystemParamVO>> getAllSystemParam(){
        return BuildResponse.build("200",systemParamService.getAllSystemParam());
    }

    @Override
    @GetMapping("/validateName")
    public CommonResponse<Boolean> validateName(@RequestParam("name") String name) {
        return super.validateName(name);
    }

}
