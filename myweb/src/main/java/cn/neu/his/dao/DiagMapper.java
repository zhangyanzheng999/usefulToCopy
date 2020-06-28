package cn.neu.his.dao;

import cn.neu.his.bean.Diag;
import cn.neu.his.bean.DiagExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DiagMapper {
    long countByExample(DiagExample example);

    int deleteByExample(DiagExample example);

    int deleteByPrimaryKey(Integer diagId);

    int insert(Diag record);

    int insertSelective(Diag record);

    List<Diag> selectByExample(DiagExample example);

    Diag selectByPrimaryKey(Integer diagId);

    int updateByExampleSelective(@Param("record") Diag record, @Param("example") DiagExample example);

    int updateByExample(@Param("record") Diag record, @Param("example") DiagExample example);

    int updateByPrimaryKeySelective(Diag record);

    int updateByPrimaryKey(Diag record);
}