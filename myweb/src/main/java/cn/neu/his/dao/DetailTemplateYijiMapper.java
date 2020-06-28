package cn.neu.his.dao;

import cn.neu.his.bean.DetailTemplateYiji;
import cn.neu.his.bean.DetailTemplateYijiExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DetailTemplateYijiMapper {
    long countByExample(DetailTemplateYijiExample example);

    int deleteByExample(DetailTemplateYijiExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(DetailTemplateYiji record);

    int insertSelective(DetailTemplateYiji record);

    List<DetailTemplateYiji> selectByExample(DetailTemplateYijiExample example);

    DetailTemplateYiji selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") DetailTemplateYiji record, @Param("example") DetailTemplateYijiExample example);

    int updateByExample(@Param("record") DetailTemplateYiji record, @Param("example") DetailTemplateYijiExample example);

    int updateByPrimaryKeySelective(DetailTemplateYiji record);

    int updateByPrimaryKey(DetailTemplateYiji record);
}