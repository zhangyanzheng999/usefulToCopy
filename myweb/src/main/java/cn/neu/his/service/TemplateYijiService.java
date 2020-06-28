package cn.neu.his.service;

import cn.neu.his.bean.TemplateYiji;
import cn.neu.his.bean.TemplateYijiExample;
import cn.neu.his.dao.TemplateYijiMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class TemplateYijiService {
    @Autowired
    TemplateYijiMapper templateYijiMapper;


    public List<TemplateYiji> findTemplate(String templateName, String templateRange, String templateType) {
        TemplateYijiExample example = new TemplateYijiExample();
        TemplateYijiExample.Criteria criteria = example.createCriteria();
        criteria.andTemplatenameLike("%" + templateName + "%");
        //空值的话查询所有
        if (templateName.trim().length() > 0) {
            criteria.andTemplaterangeEqualTo(Integer.parseInt(templateRange));
            int type = Integer.parseInt(templateType);
            if (type != 0) {
                criteria.andTemplatetypeEqualTo(type);
            }
        }
        List<TemplateYiji> templateYijis = templateYijiMapper.selectByExample(example);
        return templateYijis;
    }

    public void addNewTemplate(String templateName, String templateRange, String templateType) {
        TemplateYiji templateYiji = new TemplateYiji();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm");
        String date = format.format(new Date());
        templateYiji.setTemplatename(templateName);
        templateYiji.setTemplaterange(Integer.parseInt(templateRange));
        templateYiji.setTemplatetype(Integer.parseInt(templateType));
        templateYiji.setTemplatecreatetime(date);
        templateYijiMapper.insert(templateYiji);
    }

    public void deleteTemplate(String templateID) {
        templateYijiMapper.deleteByPrimaryKey(Integer.parseInt(templateID));
    }

    public void modifyTemplate(String templateID, String templateName, String templateRange, String templateType) {
        TemplateYiji record = new TemplateYiji();
        record.setTemplateid(Integer.parseInt(templateID));
        record.setTemplatename(templateName);
        record.setTemplaterange(Integer.parseInt(templateRange));
        record.setTemplatetype(Integer.parseInt(templateType));
        record.setTemplatecreatetime(new SimpleDateFormat("yyyy-MM-dd HH:mm").format(new Date()));
        templateYijiMapper.updateByPrimaryKey(record);
    }
}
