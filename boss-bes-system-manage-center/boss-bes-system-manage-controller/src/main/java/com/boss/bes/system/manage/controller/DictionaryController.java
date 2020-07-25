package com.boss.bes.system.manage.controller;

import boss.brs.xtrain.dataconvention.convention.CommonRequest;
import boss.brs.xtrain.dataconvention.convention.CommonResponse;
import com.boss.bes.system.manage.api.DictionaryApi;
import com.boss.bes.system.manage.controller.common.BaseCRUDController;
import com.boss.bes.system.manage.mapper.DictionaryMapper;
import com.boss.bes.system.manage.pojo.dto.DictionaryDTO;
import com.boss.bes.system.manage.pojo.dto.common.BaseDeleteDTO;
import com.boss.bes.system.manage.pojo.entity.Dictionary;
import com.boss.bes.system.manage.pojo.query.DictionaryPageQuery;
import com.boss.bes.system.manage.pojo.query.common.BaseQuery;
import com.boss.bes.system.manage.pojo.vo.DictionaryVO;
import com.boss.bes.system.manage.service.DictionaryService;
import com.boss.bes.system.manage.util.BuildResponse;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @description:数据字典的控制器
 * @author:zyz
 * @time:2020/7/14-16:53
 */
@RestController
@RequestMapping("/education/bes/v1/system-manager-center/dictionary")
public class DictionaryController extends BaseCRUDController<Dictionary, DictionaryDTO, DictionaryVO, DictionaryPageQuery, DictionaryMapper> implements DictionaryApi {

    @Autowired
    DictionaryService dictionaryService;

    @Override
    @PostMapping("/query")
    public CommonResponse<DictionaryVO> query(@RequestBody CommonRequest<BaseQuery> commonRequest) {
        return super.query(commonRequest, Dictionary.class, DictionaryVO.class);
    }

    @Override
    @PutMapping("/update")
    public CommonResponse<String> update(@RequestBody CommonRequest<DictionaryDTO> commonRequest) {
        return super.update(commonRequest);
    }

    @Override
    @PostMapping("/insert")
    public CommonResponse<String> insert(@RequestBody CommonRequest<DictionaryDTO> commonRequest) {
        return super.insert(commonRequest, Dictionary.class);
    }

    @Override
    @PostMapping("/delete")
    public CommonResponse<String> delete(@RequestBody CommonRequest<BaseDeleteDTO> commonRequest) {
        return super.delete(commonRequest, Dictionary.class);
    }


    @Override
    @PostMapping("/multiDelete")
    public CommonResponse<String> multiDelete(@RequestBody CommonRequest<List<DictionaryDTO>> commonRequest) {
        return super.multiDelete(commonRequest, Dictionary.class);
    }


    @PostMapping("/multiInsert")
    public CommonResponse<String> multiInsert(@RequestBody CommonRequest<List<DictionaryDTO>> commonRequest) {
        dictionaryService.multiInsert(commonRequest.getBody());
        return BuildResponse.build("200", "导入成功！！");
    }

    @Override
    @PostMapping("/queryWithPage")
    public CommonResponse<PageInfo<DictionaryVO>> queryWithPage(@RequestBody CommonRequest<DictionaryPageQuery> commonRequest) {
        return BuildResponse.build("200", dictionaryService.queryAllWithPageGroupByOrg(commonRequest.getBody()));
    }


    @Override
    @GetMapping("/getParamType")
    public CommonResponse<List<Dictionary>> getParamType() {
        return BuildResponse.build("200", dictionaryService.getDictionaryForType("系统参数"));
    }

    @Override
    @PostMapping("/getAllDictionary")
    public CommonResponse<List<DictionaryVO>> getAllDictionary(@RequestBody CommonRequest<Long> commonRequest) {
        return BuildResponse.build("200", dictionaryService.getAllDictionary(commonRequest.getBody()));
    }


    @Override
    @GetMapping("/validateName")
    public CommonResponse<Boolean> validateName(@RequestParam("name") String name) {
        return super.validateName(name);
    }


}
