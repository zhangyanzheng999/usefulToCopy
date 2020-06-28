package cn.neu.his.service;


import cn.neu.his.bean.DetailTemplateYiji;
import cn.neu.his.bean.DetailTemplateYijiExample;

import cn.neu.his.dao.DetailTemplateYijiMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class DetailTemplateYijiService {
    @Autowired
    DetailTemplateYijiMapper detailTemplateYijiMapper;

    public List<DetailTemplateYiji> loadTemplate(String templateID) {
        DetailTemplateYijiExample example = new DetailTemplateYijiExample();
        DetailTemplateYijiExample.Criteria criteria = example.createCriteria();
        criteria.andTemplateidEqualTo(Integer.parseInt(templateID));
        List<DetailTemplateYiji> detailTemplateYijis = detailTemplateYijiMapper.selectByExample(example);
        return detailTemplateYijis;
    }

    public void deleteTemplateItem(String itemCode, String templateID) {
        DetailTemplateYijiExample example = new DetailTemplateYijiExample();
        DetailTemplateYijiExample.Criteria criteria = example.createCriteria();
        criteria.andTemplateidEqualTo(Integer.parseInt(templateID)).andItemCodeEqualTo(itemCode);
        detailTemplateYijiMapper.deleteByExample(example);
    }

    public void addTemplateItem(String templateID, String itemCode) {
        DetailTemplateYiji detailTemplateYiji = new DetailTemplateYiji();
        detailTemplateYiji.setTemplateid(Integer.parseInt(templateID));
        detailTemplateYiji.setItemCode(itemCode);
        detailTemplateYijiMapper.insert(detailTemplateYiji);
    }


    public void deleteDetailTemplate(String templateID) {
        DetailTemplateYijiExample example = new DetailTemplateYijiExample();
        DetailTemplateYijiExample.Criteria criteria = example.createCriteria();
        criteria.andTemplateidEqualTo(Integer.parseInt(templateID));
        detailTemplateYijiMapper.deleteByExample(example);
    }
}
