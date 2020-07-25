package com.boss.bes.system.manage.service;

import com.boss.bes.system.manage.pojo.dto.OrganizationDTO;
import com.boss.bes.system.manage.pojo.vo.OrganizationVO;
import com.boss.bes.system.manage.pojo.vo.common.BaseTreeVO;

import java.util.List;


/**
 * @description:
 * @author:zyz
 * @time:2020/7/4-15:50
 */
public interface OrgService {


     /**
      * 批量删除
      * @param organizationDTOS
      * @return
      */
     Integer multiDelete(List<OrganizationDTO> organizationDTOS);

     /**
      * 查询全部
      * @return
      */
     List<OrganizationVO> queryAll(Long id);

     /**
      * 查询树
      * @return
      */
     List<BaseTreeVO> queryTree();

     /**
      * 根据Id拿到组织名字
      * @param id
      * @return
      */
     String getOrgName(Long id);
}
