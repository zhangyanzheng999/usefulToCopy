package cn.neu.his.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.neu.his.bean.Medrecord;
import cn.neu.his.bean.Msg;
import cn.neu.his.service.MedrecordService;

/**
 * @author zyz1010561415
 *
 */
@Controller
public class MedrecordController {
	@Autowired
	MedrecordService medrecordService;
	
	
	@RequestMapping("/load_patient_med")
	@ResponseBody
	public Msg load_patient_med(@RequestParam("regnum") Integer regnum,@RequestParam("medrecord_code") Integer medrecord_code) {
		
		List<Medrecord> medlist=medrecordService.load_patient_med(regnum,medrecord_code);
		
		return Msg.success().add("medlist", medlist);
		
	}
	
	@RequestMapping("/save_med")
	@ResponseBody
	public Msg save_med(@RequestParam("regnum") Integer regnum,@RequestParam("medrecord_code") Integer medrecord_code,
						@RequestParam("zs") String zs,@RequestParam("xbs") String xbs,@RequestParam("xbzlqk") String xbzlqk,
						@RequestParam("jws") String jws,@RequestParam("gms") String gms,@RequestParam("tgjc") String tgjc,
						@RequestParam("state") Integer state) {
		Boolean b=medrecordService.save_med(regnum,medrecord_code,zs,xbs,xbzlqk,jws,gms,tgjc,state);
		if(b)
			return Msg.success();
		else
			return Msg.fail();
	}
	
	
}
