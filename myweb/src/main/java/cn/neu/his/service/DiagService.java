package cn.neu.his.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.neu.his.bean.Diag;
import cn.neu.his.bean.DiagExample;
import cn.neu.his.bean.DiagExample.Criteria;
import cn.neu.his.dao.DiagMapper;

/**
 * @author zyz1010561415
 *
 */
@Service
public class DiagService {
	@Autowired
	DiagMapper diagMapper;

	public List<Diag> load_patient_diag(Integer regnum, Integer medrecord_code) {
		DiagExample example=new DiagExample();
		Criteria criteria=example.createCriteria();
		criteria.andRegisterIdEqualTo(regnum).andMedrecordCodeEqualTo(medrecord_code);
		List<Diag> diaglist=diagMapper.selectByExample(example);
		return diaglist;
	}

	
	
	public void save_diag(Integer regnum, Integer medrecord_code, Integer state, Integer doctor_id,
			String fabing_date, Integer zhongxi,Integer dis_id) {
		// TODO Auto-generated method stub
		java.text.SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date fadate;
		try {
			fadate = formatter.parse(fabing_date);
			DiagExample example=new DiagExample();
			Criteria criteria=example.createCriteria();
			criteria.andRegisterIdEqualTo(regnum).andMedrecordCodeEqualTo(medrecord_code);
			Integer Kong=null;
			Diag diag=new Diag(Kong,medrecord_code,regnum,dis_id,zhongxi,fadate,state);
			diagMapper.insert(diag);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}



	public boolean del_diag(Integer regnum, Integer medrecord_code) {
		// TODO Auto-generated method stub
		DiagExample example=new DiagExample();
		Criteria criteria=example.createCriteria();
		criteria.andRegisterIdEqualTo(regnum).andMedrecordCodeEqualTo(medrecord_code).andChuZhongEqualTo(1);
		DiagExample example1=new DiagExample();
		Criteria criteria1=example1.createCriteria();
		criteria1.andRegisterIdEqualTo(regnum).andMedrecordCodeEqualTo(medrecord_code).andChuZhongEqualTo(2);
		long z=diagMapper.countByExample(example);
		long t=diagMapper.countByExample(example1);
		if(z>0&t==0)
			diagMapper.deleteByExample(example);
		else if(t>0)
			return false;
		
			return true;
	}
}
