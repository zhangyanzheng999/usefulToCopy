package cn.neu.his.dao;

import cn.neu.his.bean.RegType;
import cn.neu.his.bean.RegTypeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RegTypeMapper {
    long countByExample(RegTypeExample example);

    int deleteByExample(RegTypeExample example);

    int deleteByPrimaryKey(Integer regTypeId);

    int insert(RegType record);

    int insertSelective(RegType record);

    List<RegType> selectByExample(RegTypeExample example);

    RegType selectByPrimaryKey(Integer regTypeId);

    int updateByExampleSelective(@Param("record") RegType record, @Param("example") RegTypeExample example);

    int updateByExample(@Param("record") RegType record, @Param("example") RegTypeExample example);

    int updateByPrimaryKeySelective(RegType record);

    int updateByPrimaryKey(RegType record);
}