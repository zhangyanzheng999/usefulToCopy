package cn.neu.his.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.neu.his.bean.Diag;
import cn.neu.his.bean.Msg;
import cn.neu.his.service.DiagService;

/**
 * @author zyz1010561415
 *
 */
@Controller
public class DiagController {
	@Autowired
	DiagService diagService;
	
	
	@RequestMapping("/load_patient_diag")
	@ResponseBody
	public Msg load_patient_diag(@RequestParam("regnum") Integer regnum,@RequestParam("medrecord_code") Integer medrecord_code) {
		
		List<Diag> diaglist=diagService.load_patient_diag(regnum,medrecord_code);
		
		return Msg.success().add("diaglist", diaglist);
		
	}
	
	@RequestMapping("/save_diag")
	@ResponseBody
	public Msg save_diag(@RequestParam("regnum") Integer regnum,@RequestParam("medrecord_code") Integer medrecord_code,
				@RequestParam("state") Integer state,@RequestParam("doctor_id") Integer doctor_id,
				@RequestParam("fabing_date") String fabing_date,@RequestParam("zhongxi") Integer zhongxi,
				@RequestParam("dise_id") Integer dis_id) {

		diagService.save_diag(regnum,medrecord_code,state,doctor_id,fabing_date,zhongxi,dis_id);		
		return Msg.success();
	}
	@RequestMapping("/del_diag")
	@ResponseBody
	public Msg del_diag(@RequestParam("regnum") Integer regnum,@RequestParam("medrecord_code") Integer medrecord_code) {
		
		Boolean b=diagService.del_diag(regnum,medrecord_code);
		if(b)
			return Msg.success();
		else
			return Msg.fail();
	}
	
	
}
