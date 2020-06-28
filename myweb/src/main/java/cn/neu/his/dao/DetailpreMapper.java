package cn.neu.his.dao;

import cn.neu.his.bean.Detailpre;
import cn.neu.his.bean.DetailpreExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DetailpreMapper {
    long countByExample(DetailpreExample example);

    int deleteByExample(DetailpreExample example);

    int deleteByPrimaryKey(Integer detialpreId);

    int insert(Detailpre record);

    int insertSelective(Detailpre record);

    List<Detailpre> selectByExample(DetailpreExample example);

    Detailpre selectByPrimaryKey(Integer detialpreId);

    int updateByExampleSelective(@Param("record") Detailpre record, @Param("example") DetailpreExample example);

    int updateByExample(@Param("record") Detailpre record, @Param("example") DetailpreExample example);

    int updateByPrimaryKeySelective(Detailpre record);

    int updateByPrimaryKey(Detailpre record);
}