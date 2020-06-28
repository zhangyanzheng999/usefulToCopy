package cn.neu.his.dao;

import cn.neu.his.bean.DetailMould;
import cn.neu.his.bean.DetailMouldExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DetailMouldMapper {
    long countByExample(DetailMouldExample example);

    int deleteByExample(DetailMouldExample example);

    int deleteByPrimaryKey(Integer readyMouldDetailId);

    int insert(DetailMould record);

    int insertSelective(DetailMould record);

    List<DetailMould> selectByExample(DetailMouldExample example);

    DetailMould selectByPrimaryKey(Integer readyMouldDetailId);

    int updateByExampleSelective(@Param("record") DetailMould record, @Param("example") DetailMouldExample example);

    int updateByExample(@Param("record") DetailMould record, @Param("example") DetailMouldExample example);

    int updateByPrimaryKeySelective(DetailMould record);

    int updateByPrimaryKey(DetailMould record);
}