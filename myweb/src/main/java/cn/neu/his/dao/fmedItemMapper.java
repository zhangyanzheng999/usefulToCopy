package cn.neu.his.dao;

import cn.neu.his.bean.fmedItem;
import cn.neu.his.bean.fmedItemExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface fmedItemMapper {
    long countByExample(fmedItemExample example);

    int deleteByExample(fmedItemExample example);

    int deleteByPrimaryKey(Integer itemId);

    int insert(fmedItem record);

    int insertSelective(fmedItem record);

    List<fmedItem> selectByExample(fmedItemExample example);

    fmedItem selectByPrimaryKey(Integer itemId);

    int updateByExampleSelective(@Param("record") fmedItem record, @Param("example") fmedItemExample example);

    int updateByExample(@Param("record") fmedItem record, @Param("example") fmedItemExample example);

    int updateByPrimaryKeySelective(fmedItem record);

    int updateByPrimaryKey(fmedItem record);
}