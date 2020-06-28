package cn.neu.his.service;

import cn.neu.his.bean.fmedItem;
import cn.neu.his.bean.fmedItemExample;
import cn.neu.his.dao.fmedItemMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class fmedItemService {
    @Autowired
    fmedItemMapper fmedItemMapper;

    public List<fmedItem> loadItem(String itemCode) {
        fmedItemExample example = new fmedItemExample();
        fmedItemExample.Criteria criteria = example.createCriteria();
        criteria.andItemCodeEqualTo(itemCode);
        List<fmedItem> items = fmedItemMapper.selectByExample(example);
        return items;
    }

    public List<fmedItem> loadLikeItem(String itemName) {
        fmedItemExample example=new fmedItemExample();
        fmedItemExample.Criteria criteria=example.createCriteria();
        criteria.andItemNameLike("%"+itemName+"%");
        List<fmedItem> list = fmedItemMapper.selectByExample(example);
        return list;
    }
}
