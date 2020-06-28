package cn.neu.his.dao;

import cn.neu.his.bean.Mould;
import cn.neu.his.bean.MouldExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MouldMapper {
    long countByExample(MouldExample example);

    int deleteByExample(MouldExample example);

    int deleteByPrimaryKey(Integer readyMouldId);

    int insert(Mould record);

    int insertSelective(Mould record);

    List<Mould> selectByExample(MouldExample example);

    Mould selectByPrimaryKey(Integer readyMouldId);

    int updateByExampleSelective(@Param("record") Mould record, @Param("example") MouldExample example);

    int updateByExample(@Param("record") Mould record, @Param("example") MouldExample example);

    int updateByPrimaryKeySelective(Mould record);

    int updateByPrimaryKey(Mould record);
}