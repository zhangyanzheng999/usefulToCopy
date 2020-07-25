package com.boss.bes.system.manage.controller;

import boss.brs.xtrain.dataconvention.convention.CommonRequest;
import boss.brs.xtrain.dataconvention.convention.CommonResponse;
import com.boss.bes.system.manage.api.PositionServiceApi;
import com.boss.bes.system.manage.controller.common.BaseCRUDController;
import com.boss.bes.system.manage.mapper.PositionMapper;
import com.boss.bes.system.manage.pojo.dto.PositionDTO;
import com.boss.bes.system.manage.pojo.dto.common.BaseDeleteDTO;
import com.boss.bes.system.manage.pojo.entity.Position;
import com.boss.bes.system.manage.pojo.query.PositionPageQuery;
import com.boss.bes.system.manage.pojo.query.common.BaseQuery;
import com.boss.bes.system.manage.pojo.vo.PositionVO;
import com.boss.bes.system.manage.service.PositionService;
import com.boss.bes.system.manage.util.BuildResponse;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @description:职位的控制器
 * @author:zyz
 * @time:2020/7/12-10:16
 */
@RestController
@RequestMapping("/education/bes/v1/system-manager-center/position")
public class PositionController extends BaseCRUDController<Position, PositionDTO, PositionVO, PositionPageQuery, PositionMapper> implements PositionServiceApi {
    @Autowired
    PositionService positionService;

    @Override
    @PostMapping("/queryWithPage")
    public CommonResponse<PageInfo<PositionVO>> queryWithPage(@RequestBody CommonRequest<PositionPageQuery> commonRequest) {
        return BuildResponse.build("200", positionService.queryAllWithPageAndCompany(commonRequest.getBody()));
    }

    @Override
    @PostMapping("/delete")
    public CommonResponse<String> delete(@RequestBody CommonRequest<BaseDeleteDTO> commonRequest) {
        return super.delete(commonRequest, Position.class);
    }

    @Override
    @PostMapping("/multiDelete")
    public CommonResponse<String> multiDelete(@RequestBody CommonRequest<List<PositionDTO>> commonRequest) {
        return super.multiDelete(commonRequest, Position.class);
    }

    @Override
    @PostMapping("/insert")
    public CommonResponse<String> insert(@RequestBody CommonRequest<PositionDTO> commonRequest) {
        return super.insert(commonRequest, Position.class);
    }

    @Override
    @PutMapping("/update")
    public CommonResponse<String> update(@RequestBody CommonRequest<PositionDTO> commonRequest) {
        return super.update(commonRequest);
    }

    @Override
    @PostMapping("/query")
    public CommonResponse<PositionVO> query(@RequestBody CommonRequest<BaseQuery> commonRequest) {
        return super.query(commonRequest);
    }


    @Override
    @GetMapping("/queryPositionByCompanyId")
    public CommonResponse<List<PositionVO>> queryPositionByCompanyId(@RequestParam("companyId") Long companyId) {

        return BuildResponse.build("200",positionService.queryPositionByCompanyId(companyId));
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
