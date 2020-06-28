package cn.neu.his.dao;

import cn.neu.his.bean.Medrecord;
import cn.neu.his.bean.MedrecordExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MedrecordMapper {
    long countByExample(MedrecordExample example);

    int deleteByExample(MedrecordExample example);

    int deleteByPrimaryKey(Integer medrecordId);

    int insert(Medrecord record);

    int insertSelective(Medrecord record);

    List<Medrecord> selectByExample(MedrecordExample example);

    Medrecord selectByPrimaryKey(Integer medrecordId);

    int updateByExampleSelective(@Param("record") Medrecord record, @Param("example") MedrecordExample example);

    int updateByExample(@Param("record") Medrecord record, @Param("example") MedrecordExample example);

    int updateByPrimaryKeySelective(Medrecord record);

    int updateByPrimaryKey(Medrecord record);
}