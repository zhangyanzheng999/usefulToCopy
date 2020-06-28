package cn.neu.his.dao;

import cn.neu.his.bean.TemplateYiji;
import cn.neu.his.bean.TemplateYijiExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TemplateYijiMapper {
    long countByExample(TemplateYijiExample example);

    int deleteByExample(TemplateYijiExample example);

    int deleteByPrimaryKey(Integer templateid);

    int insert(TemplateYiji record);

    int insertSelective(TemplateYiji record);

    List<TemplateYiji> selectByExample(TemplateYijiExample example);

    TemplateYiji selectByPrimaryKey(Integer templateid);

    int updateByExampleSelective(@Param("record") TemplateYiji record, @Param("example") TemplateYijiExample example);

    int updateByExample(@Param("record") TemplateYiji record, @Param("example") TemplateYijiExample example);

    int updateByPrimaryKeySelective(TemplateYiji record);

    int updateByPrimaryKey(TemplateYiji record);
}