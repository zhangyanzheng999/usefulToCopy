package cn.neu.his.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.neu.his.bean.Bill;
import cn.neu.his.bean.BillExample;
import cn.neu.his.bean.BillExample.Criteria;
import cn.neu.his.dao.BillMapper;

/**
 * @author zyz1010561415
 *
 */
@Service
public class BillService {
		@Autowired
		BillMapper billMapper;

		public long getMaxmed() {
			// TODO Auto-generated method stub
			
			BillExample example=new BillExample();
			Criteria criteria=example.createCriteria();
			criteria.andBillCodeIsNotNull();
			example.setOrderByClause("Bill_Code desc");
			List<Bill> billlist=billMapper.selectByExample(example);
			return billlist.get(0).getBillCode()+1;
		}

		public boolean Store(Integer bill_code, float need_pay, Integer regnum, Integer payway) {
			// TODO Auto-generated method stub
			Date rettime= new java.sql.Timestamp(new java.util.Date().getTime());
			Integer Kong=null;
	/*		Integer RePerID=8;
			Integer BillState=6;
			Integer RedBillState=0;*/
			Bill bill=new Bill(Kong,bill_code,need_pay,6,rettime,8,regnum,payway,Kong,0);
			billMapper.insert(bill);
			return true;
			
	
		}
		
		
		
}
