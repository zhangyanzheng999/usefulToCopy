package cn.neu.his.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.neu.his.bean.Medrecord;
import cn.neu.his.bean.MedrecordExample;
import cn.neu.his.bean.MedrecordExample.Criteria;
import cn.neu.his.dao.MedrecordMapper;

/**
 * @author zyz1010561415
 *
 */
@Service
public class MedrecordService {
	@Autowired
	MedrecordMapper medrecordMapper;

	public List<Medrecord> load_patient_med(Integer regnum, Integer medrecord_code) {
		MedrecordExample example=new MedrecordExample();
		Criteria criteria=example.createCriteria();
		criteria.andMedrecordCodeEqualTo(medrecord_code).andRegisterIdEqualTo(regnum);
		List<Medrecord> medlist=medrecordMapper.selectByExample(example);
		return medlist;	
	}

	public Boolean save_med(Integer regnum, Integer medrecord_code, String zs, String xbs, String xbzlqk,
			String jws, String gms, String tgjc,Integer state) {
		// TODO Auto-generated method stub
		MedrecordExample example=new MedrecordExample();
		Criteria criteria=example.createCriteria();
		criteria.andMedrecordCodeEqualTo(medrecord_code).andRegisterIdEqualTo(regnum);
		List<Medrecord> medlist=medrecordMapper.selectByExample(example);
		int med_state=0;
		if(medlist.size()>0) {
			med_state=medlist.get(0).getMedrecordState();
		}
		Medrecord med=new Medrecord();		
		med.setChiefComplaint(zs);
		med.setNowIllness(xbs);
		med.setNowMedicalStatus(xbzlqk);
		med.setPastIllness(jws);
		med.setAllergyHistory(gms);
		med.setPhysicalExamination(tgjc);
		med.setMedrecordState(state);
		if(med_state==2) {
			return false;
		}else if(med_state==1){				
			medrecordMapper.updateByExampleSelective(med, example);
		}else {
			med.setMedrecordCode(medrecord_code);
			med.setRegisterId(regnum);
			med.setMedrecordId(null);
			medrecordMapper.insert(med);
		}
		return true;
		
	}
	
	
	
	
	
	
}
