package cn.neu.his.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.neu.his.bean.DetailMould;
import cn.neu.his.bean.DetailMouldExample;
import cn.neu.his.bean.DetailMouldExample.Criteria;
import cn.neu.his.dao.DetailMouldMapper;

/**
 * @author zyz1010561415
 */
@Service
public class DetailMouldService {
    @Autowired
    DetailMouldMapper detailmouldMapper;

    public List<DetailMould> load_detailmould(Integer mould_id) {
        DetailMouldExample example = new DetailMouldExample();
        Criteria criteria = example.createCriteria();
        criteria.andReadyMouldIdEqualTo(mould_id);
        List<DetailMould> dmouldlist = detailmouldMapper.selectByExample(example);
        return dmouldlist;

    }

    public void addNewMed(Integer mouldID, Integer drugID, String howUse, String howMuchUse, String howOfenUse) {
        DetailMould detailMould = new DetailMould();
        detailMould.setReadyMouldId(mouldID);
        detailMould.setDrugId(drugID);
        detailMould.setHowUse(howUse);
        detailMould.setHowMuchUse(howMuchUse);
        detailMould.setHowOfenUse(howOfenUse);
        detailmouldMapper.insert(detailMould);

    }

	public void deleteDrug(Integer mouldID, Integer drugID) {
	    DetailMouldExample example=new DetailMouldExample();
	    Criteria criteria=example.createCriteria();
	    criteria.andReadyMouldIdEqualTo(mouldID).andDrugIdEqualTo(drugID);
        detailmouldMapper.deleteByExample(example);
    }

    public void deleteDetailWestMould(String mouldID) {
        DetailMouldExample example=new DetailMouldExample();
        Criteria criteria=example.createCriteria();
        criteria.andReadyMouldIdEqualTo(Integer.parseInt(mouldID));
        detailmouldMapper.deleteByExample(example);
    }
}
