package cn.neu.his.service;


import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.neu.his.bean.MouldExample;
import cn.neu.his.bean.MouldExample.Criteria;
import cn.neu.his.bean.Mould;
import cn.neu.his.dao.MouldMapper;

/**
 * @author zyz1010561415
 */
@Service
public class MouldService {
    @Autowired
    MouldMapper mouldMapper;

    public List<Mould> load_mould(String mouldname) {
        // TODO Auto-generated method stub
        MouldExample example = new MouldExample();
        Criteria criteria = example.createCriteria();
        criteria.andReadyMouldNameLike("%" + mouldname + "%");
        List<Mould> mouldlist = mouldMapper.selectByExample(example);
        return mouldlist;
    }

    public List<Mould> find_mould(String templateName, String templateRange) {
        MouldExample example = new MouldExample();
        Criteria criteria = example.createCriteria();
        if (templateName.trim().length() != 0) {
            criteria.andUseRangeEqualTo(Integer.parseInt(templateRange));
        }
        criteria.andReadyMouldNameLike("%" + templateName + "%");
        List<Mould> moulds = mouldMapper.selectByExample(example);
        return moulds;
    }

	public void addNewMould(String doctorID, String mouldName, String mouldRange) {
        Mould mould=new Mould();
        mould.setDoctorId(Integer.parseInt(doctorID));
        mould.setCreatTime(new Date());
        mould.setReadyMouldName(mouldName);
        mould.setUseRange(Integer.parseInt(mouldRange));
        mould.setRemoveSign(1);
        mouldMapper.insert(mould);
	}

    public void deleteWestMould(String mouldID) {
        mouldMapper.deleteByPrimaryKey(Integer.parseInt(mouldID));
    }

    public void modifyWestMould(String mouldID, String mouldName, String mouldRange) {
        Mould mould=new Mould();
        mould.setUseRange(Integer.parseInt(mouldRange));
        mould.setReadyMouldId(Integer.parseInt(mouldID));
        mould.setReadyMouldName(mouldName);
        mould.setCreatTime(new Date());
        mouldMapper.updateByPrimaryKeySelective(mould);
    }
}
