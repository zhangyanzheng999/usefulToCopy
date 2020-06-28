package cn.neu.his.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.neu.his.bean.RegType;
import cn.neu.his.bean.RegTypeExample;
import cn.neu.his.bean.RegTypeExample.Criteria;

import cn.neu.his.dao.RegTypeMapper;
/**
 * @author zyz1010561415
 *
 */
@Service
public class RegTypeService {
	@Autowired
	RegTypeMapper regTypeMapper;
	
	
	public RegType load_regtype(Integer regtypeid) {
		// TODO Auto-generated method stub
		RegTypeExample example=new RegTypeExample();
		Criteria criteria =example.createCriteria();
		criteria.andRegTypeIdEqualTo(regtypeid);
		List<RegType> regType= regTypeMapper.selectByExample(example);
		return regType.get(0);
	}

}
