package com.boss.bes.system.manage.mapper;

import com.boss.bes.system.manage.pojo.entity.Resource;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ResourceMapper extends CommonMapper<Resource> {

    String getResourceName(Long id);

    List<Resource> getResourceWithPage(@Param("name") String name, @Param("parentId") Long parentId);

    Resource getResource(@Param("id") Long id, @Param("version") Long version);

}