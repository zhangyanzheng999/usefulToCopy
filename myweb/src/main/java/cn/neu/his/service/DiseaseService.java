package cn.neu.his.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.neu.his.bean.Disease;
import cn.neu.his.bean.DiseaseExample;
import cn.neu.his.bean.DiseaseExample.Criteria;
import cn.neu.his.dao.DiseaseMapper;

/**
 * @author zyz1010561415
 *
 */
@Service
public class DiseaseService {
	@Autowired
	DiseaseMapper diseaseMapper;

	public List<Disease> load_xiyi(String xiyi_disease) {
		// TODO Auto-generated method stub
		DiseaseExample example=new DiseaseExample();
		Criteria criteria=example.createCriteria();
		criteria.andDiseaseNameLike("%"+xiyi_disease+"%");
		List<Disease> dislist=diseaseMapper.selectByExample(example);
		return dislist;
	}

	public List<Disease> load_detail_xiyi(Integer disease_id) {
		DiseaseExample example=new DiseaseExample();
		Criteria criteria=example.createCriteria();
		criteria.andDiseaseIdEqualTo(disease_id);
		List<Disease> dislist=diseaseMapper.selectByExample(example);
		return dislist;
	}
	
	
	
	
	
	
	
}
