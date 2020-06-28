package cn.neu.his.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.neu.his.bean.Drug;
import cn.neu.his.bean.DrugExample;
import cn.neu.his.bean.DrugExample.Criteria;
import cn.neu.his.dao.DrugMapper;

/**
 * @author zyz1010561415
 *
 */
@Service
public class DrugsService {
	@Autowired
	DrugMapper drugMapper;
	public List<Drug> getDrug(Integer drugID) {
		// TODO Auto-generated method stub
		DrugExample example=new DrugExample();
		Criteria criteria=example.createCriteria();
		criteria.andDrugsIdEqualTo(drugID);
		List<Drug> drugs=drugMapper.selectByExample(example);
		
		return drugs;
	}
	public List<Drug> load_allopen_drug(String drug_name) {
		// TODO Auto-generated method stub
		DrugExample example=new DrugExample();
		Criteria criteria=example.createCriteria();
		criteria.andDrugsNameLike("%"+drug_name+"%");
		example.or().andMnemoniccodeLike("%"+drug_name+"%");
		example.or().andDrugsCodeLike("%"+drug_name+"%");
		List<Drug> druglist=drugMapper.selectByExample(example);
		return druglist;
	}

}
