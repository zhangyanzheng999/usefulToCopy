package com.boss.bes.system.manage.mapper;


import com.boss.bes.system.manage.pojo.dto.OrganizationDTO;
import com.boss.bes.system.manage.pojo.entity.Organization;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface OrganizationMapper extends CommonMapper<Organization> {

    String getOrgName(Long id);


    Integer multiDelete(@Param("orgs") List<OrganizationDTO> organizationDTOs);





}