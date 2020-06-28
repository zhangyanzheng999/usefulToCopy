package cn.neu.his.controller;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.neu.his.bean.Charge;
import cn.neu.his.bean.Msg;
import cn.neu.his.service.ChargeService;

/**
 * @author zyz1010561415
 *
 */
@Controller
public class ChargeController {
 @Autowired
 ChargeService chargeService;


 	@RequestMapping("/load_charge")
	@ResponseBody
 public Msg getCharge(@RequestParam("regnum") Integer regnum) {
	 List<Charge> chargelist=chargeService.getCharge(regnum);
	 
	 return Msg.success().add("chargelist", chargelist);
 }
 	@RequestMapping("/store_charge")
	@ResponseBody
 	public Msg Store(@RequestParam("medrecord_code") Integer medrecord_code,@RequestParam("patientName") String patientName,
 			@RequestParam("itemname") String itemname,@RequestParam("itemprice") float itemprice,
 			@RequestParam("itemnum") Integer itemnum,@RequestParam("opentime") String opentime,
 			@RequestParam("state") Integer state,@RequestParam("regnum") Integer regnum,
 			@RequestParam("payway") Integer payway,@RequestParam("doctorId") Integer doctorId,
 			@RequestParam("bill_code") Integer bill_code) {
 			
 			boolean b=chargeService.Store(medrecord_code,patientName,itemname,itemprice,itemnum,opentime,state,regnum,payway,doctorId,bill_code);
 			if(b) return Msg.success(); else return Msg.fail();
 	}
 	
 	
}
