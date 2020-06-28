package cn.neu.his.service;



import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.neu.his.bean.Register;
import cn.neu.his.bean.RegisterExample;
import cn.neu.his.bean.RegisterExample.Criteria;
import cn.neu.his.dao.RegisterMapper;

/**
 * @author zyz1010561415
 *
 */
@Service
public class RegisterService {
	@Autowired
	RegisterMapper registerMapper;
	
	/**
	 * 根据病历号得到病人信息
	 * @author zyz1010561415
	 *
	 */
	public List<Register> getPatient(Integer medrecord) {
		RegisterExample example=new RegisterExample();
		Criteria criteria=example.createCriteria();
		criteria.andMedrecordCodeEqualTo(medrecord);
		example.setOrderByClause("Register_Time desc");
		List<Register> reglist=registerMapper.selectByExample(example);
		return reglist;
	}

	public long getMaxmed() {
		// TODO Auto-generated method stub
		RegisterExample example=new RegisterExample();
		Criteria criteria=example.createCriteria();
		criteria.andMedrecordCodeIsNotNull();
		example.setOrderByClause("MedRecord_Code desc");
		List<Register> reglist=registerMapper.selectByExample(example);
		return reglist.get(0).getMedrecordCode()+1;
	}

	public Boolean start_regist(Integer medrecord_code, String patient_name, String sex, String patient_IDCard,
			String patient_birth, Integer patient_age, String year_type, String patient_Address, String visitdate,
			String noonbreak, Integer dept_Name, Integer doctors, Integer reg_type, Integer jiesuan_type,
			Integer med_book) {
			java.text.SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
			Date birth_date,visit_date;
			try {
				birth_date =formatter.parse(patient_birth);
				visit_date = formatter.parse(visitdate);
				Date reg_date= new java.sql.Timestamp(new java.util.Date().getTime());
				Integer regId=null;
				Register register=new Register(regId, medrecord_code, patient_name, sex, patient_IDCard, birth_date, patient_age, year_type, patient_Address, visit_date, noonbreak, dept_Name, doctors, reg_type, jiesuan_type, med_book, reg_date, 301, 3);
				registerMapper.insert(register);
				return true;
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return false;
		
	}

	public long loadRegnum(String visitdate, String noonbreak, Integer doctors)  {
		// TODO Auto-generated method stub
		java.text.SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		RegisterExample example=new RegisterExample();
		Criteria criteria=example.createCriteria();
		Date visit;
		try {
			visit=formatter.parse(visitdate);
			criteria.andThisVisitDateEqualTo(visit).andNoonBreakEqualTo(noonbreak).andRegisterDoctorIdEqualTo(doctors);
			long num=registerMapper.countByExample(example);
			return num;
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}

	public List<Register> loadReglist(Integer medrecord_code) {
		// TODO Auto-generated method stub
		RegisterExample example=new RegisterExample();
		Criteria criteria=example.createCriteria();
		criteria.andMedrecordCodeEqualTo(medrecord_code);
		example.setOrderByClause("Register_Time desc");
		List<Register> reglist=registerMapper.selectByExample(example);
		return reglist;
	}

	public Boolean Tuihao(Integer reg_id) {
		// TODO Auto-generated method stub
		RegisterExample example=new RegisterExample();
		Criteria criteria=example.createCriteria();
		criteria.andRegisterIdEqualTo(reg_id);
		Register reg=new Register();
		reg.setThisVisitState(2);//表示退号
		registerMapper.updateByExampleSelective(reg, example);
		return true;
	}

	public List<Register> getAllPatient(Integer login_doctorid) {
		Date now_date=new Date();
		java.text.SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		java.text.SimpleDateFormat formatter2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String get_date=formatter.format(now_date);
		String start_date=get_date+" "+"00:00:00";
		String end_date=get_date+" "+"23:59:59";
		try {
			Date startdate=formatter2.parse(start_date);
			Date enddate=formatter2.parse(end_date);
			RegisterExample example=new RegisterExample();
			Criteria criteria=example.createCriteria();
			criteria.andRegisterDoctorIdEqualTo(login_doctorid).andThisVisitDateBetween(startdate, enddate);
			example.setOrderByClause("Register_Time desc");
			List<Register> patientlist=registerMapper.selectByExample(example);
			return patientlist;
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		
	}

	public List<Register> get_docPatient(Integer regnum) {
		RegisterExample example=new RegisterExample();
		Criteria criteria=example.createCriteria();
		criteria.andRegisterIdEqualTo(regnum);
		List<Register> reglist=registerMapper.selectByExample(example);
		return reglist;
	}

	public Boolean done_zhenduan(Integer medrecord, Integer regnum) {
		RegisterExample example=new RegisterExample();
		Criteria criteria=example.createCriteria();
		criteria.andRegisterIdEqualTo(regnum).andMedrecordCodeEqualTo(medrecord);
		List<Register> reglist=registerMapper.selectByExample(example);
		int state=reglist.get(0).getThisVisitState();
		if(state==3) {
			Register reg=new Register();
			reg.setThisVisitState(1);
			registerMapper.updateByExampleSelective(reg, example);
			return true;
		}else if(state==1) {
			return false;
		}
		return false;
	}
	

}
