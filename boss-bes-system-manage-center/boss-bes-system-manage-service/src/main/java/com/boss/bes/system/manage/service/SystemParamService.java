package com.boss.bes.system.manage.service;

import com.boss.bes.system.manage.pojo.dto.SystemParamImportDTO;
import com.boss.bes.system.manage.pojo.entity.SystemParam;
import com.boss.bes.system.manage.pojo.vo.SystemParamTreeVO;
import com.boss.bes.system.manage.pojo.vo.SystemParamVO;

import java.util.List;

/**
 * @description:系统参数的业务接口
 * @author:zyz
 * @time:2020/7/12-16:03
 */
public interface SystemParamService {

    Integer multiInsert(List<SystemParamImportDTO> systemParamDTOList);

    List<SystemParamTreeVO> queryTree();

    List<SystemParamVO> getAllSystemParam();
}
