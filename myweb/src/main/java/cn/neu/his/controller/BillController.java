package cn.neu.his.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.neu.his.bean.Msg;
import cn.neu.his.service.BillService;

/**
 * @author zyz1010561415
 *
 */
@Controller
public class BillController {
	@Autowired
	BillService billService;
	
	@RequestMapping("/load_billcode")
	@ResponseBody
	public Msg getMaxmed() {
		long billcode=billService.getMaxmed();
		return Msg.success().add("billcode", billcode);
	}
	
	@RequestMapping("/store_bill")
	@ResponseBody
	public Msg Store(@RequestParam("bill_code") Integer bill_code,@RequestParam("need_pay") float need_pay,
			@RequestParam("regnum") Integer regnum,@RequestParam("payway") Integer payway) {
		boolean b=billService.Store(bill_code,need_pay,regnum,payway);
		if(b)
		return Msg.success();
		else
			return Msg.fail();
	}
	
}
