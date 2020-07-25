package com.boss.bes.system.manage.mapper;


import com.boss.bes.system.manage.pojo.entity.Position;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PositionMapper extends CommonMapper<Position> {

    List<Position> getPositionWithPage(@Param("name") String name, @Param("companyId") Long companyId, @Param("status") Boolean status,@Param("organizationId") Long organizationId);

    Position getPosition(@Param("id") Long id, @Param("version") Long version);

    String getPositionNameById(Long id);
}