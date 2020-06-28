package cn.neu.his.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import cn.neu.his.bean.Prescription;
import cn.neu.his.bean.PrescriptionExample;
import cn.neu.his.bean.PrescriptionExample.Criteria;
import cn.neu.his.dao.PrescriptionMapper;

/**
 * @author zyz1010561415
 *
 */
@Service
public class PreService {
	@Autowired
	PrescriptionMapper preMapper;

	public List<Prescription> getPre(Integer medrecord, Integer regnum) {
		// TODO Auto-generated method stub
		PrescriptionExample example=new PrescriptionExample();
		Criteria criteria=example.createCriteria();
		criteria.andMedrecordIdEqualTo(medrecord).andRegisterIdEqualTo(regnum).andPreStateNotEqualTo(3);//3表示作废
		List<Prescription> prelist=preMapper.selectByExample(example);
		return prelist;
	}
	public List<Prescription> getAllPre(Integer medrecord, String open_date) {
		// TODO Auto-generated method stub

		if(!open_date.equals("null")) {
		java.text.SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date opendate1;
		try {
			String open_date1=open_date+" 00:00:00";
			String open_date2=open_date+" 23:59:59";
			opendate1 = formatter.parse(open_date1);
			Date opendate2=formatter.parse(open_date2);
			PrescriptionExample example=new PrescriptionExample();
			Criteria criteria=example.createCriteria();
			criteria.andMedrecordIdEqualTo(medrecord).andPreOpenTimeBetween(opendate1, opendate2);
			example.setOrderByClause("Pre_Open_time desc");
			List<Prescription> prelist=preMapper.selectByExample(example);
			return prelist;
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}else {
			PrescriptionExample example=new PrescriptionExample();
			Criteria criteria=example.createCriteria();
			criteria.andMedrecordIdEqualTo(medrecord);
			example.setOrderByClause("Pre_Open_time desc");
			List<Prescription> prelist=preMapper.selectByExample(example);
			return prelist;
		}
		return null;
	}
	public Integer store_pre(Integer medrecord, Integer regnum, Integer doctor_id, String pre_name, int prestate) {
		// TODO Auto-generated method stub
		PrescriptionExample example=new PrescriptionExample();
		Criteria criteria=example.createCriteria();
		Date open_date= new java.sql.Timestamp(new java.util.Date().getTime());
		Integer Kong=null;
		Prescription pre=new Prescription(null,medrecord,regnum,doctor_id,pre_name,open_date,prestate);
		preMapper.insert(pre);
		criteria.andPreIdIsNotNull();
		example.setOrderByClause("Pre_ID DESC");
		List<Prescription> prelist=preMapper.selectByExample(example);
		return prelist.get(0).getPreId();
	}
	public void del_pre(Integer mould_id) {
		PrescriptionExample example=new PrescriptionExample();
		Criteria criteria=example.createCriteria();
		criteria.andPreIdEqualTo(mould_id);
		preMapper.deleteByExample(example);
	}
	public void open_pre(Integer pre_id) {
		// TODO Auto-generated method stub
		PrescriptionExample example=new PrescriptionExample();
		Criteria criteria=example.createCriteria();
		criteria.andPreIdEqualTo(pre_id);
		Prescription pre=new Prescription();
		pre.setPreState(2);
		preMapper.updateByExampleSelective(pre, example);
		
	}
	public void give_up_pre(Integer pre_id) {
		// TODO Auto-generated method stub
		PrescriptionExample example=new PrescriptionExample();
		Criteria criteria=example.createCriteria();
		criteria.andPreIdEqualTo(pre_id);
		Prescription pre=new Prescription();
		pre.setPreState(3);
		preMapper.updateByExampleSelective(pre, example);
	}

}
