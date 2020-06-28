package cn.neu.his.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.neu.his.bean.Charge;
import cn.neu.his.bean.ChargeExample;
import cn.neu.his.bean.ChargeExample.Criteria;
import cn.neu.his.dao.ChargeMapper;

/**
 * @author zyz1010561415
 *
 */
@Service
public class ChargeService {
@Autowired
ChargeMapper chargeMapper;

public List<Charge> getCharge(Integer regnum) {
	// TODO Auto-generated method stub
	ChargeExample example=new ChargeExample();
	Criteria criteria=example.createCriteria();
	criteria.andRegisterIdEqualTo(regnum);
	List<Charge> chargelist=chargeMapper.selectByExample(example);
	return chargelist;
}

public boolean Store(Integer medrecord_code, String patientName, String itemname, float itemprice, Integer itemnum,
		String opentime, Integer state, Integer regnum, Integer payway, Integer doctorId, Integer bill_code) {
	// TODO Auto-generated method stub
	Integer Kong=null;
	
	Date retdate= new java.sql.Timestamp(new java.util.Date().getTime());
	java.text.SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	Date Opendate;
	try {
		Opendate=formatter.parse(opentime);
/*		System.out.println(retdate);
		System.out.println(Opendate);*/
		Charge charge=new Charge(Kong,regnum,bill_code,1,1,itemname,itemprice,itemnum,1,Opendate,doctorId,retdate,8,payway,1);
		chargeMapper.insert(charge);
		return true;
	} catch (ParseException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return false;

}

public List<Charge> load_alldrug(Integer medrecord_code, String open_date) {
	// TODO Auto-generated method stub
	java.text.SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
	try {
		Date opendate=formatter.parse(open_date);
		ChargeExample example=new ChargeExample();
		Criteria criteria=example.createCriteria();
	} catch (ParseException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return null;
}



}
