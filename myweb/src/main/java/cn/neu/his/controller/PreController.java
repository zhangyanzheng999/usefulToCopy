package cn.neu.his.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.neu.his.bean.Msg;
import cn.neu.his.bean.Prescription;
import cn.neu.his.service.PreService;

/**
 * @author zyz1010561415
 *
 */
@Controller
public class PreController {

	@Autowired
	PreService preService;
	
	@RequestMapping("/load_pre")
	@ResponseBody
	public Msg getPre(@RequestParam("medrecord_code") Integer medrecord,@RequestParam("regnum") Integer regnum) {
		List<Prescription> prelist=preService.getPre(medrecord,regnum);		
		return Msg.success().add("prelist", prelist);
	}
	@RequestMapping("/del_mould_fromdb")
	@ResponseBody
	public Msg del_pre(@RequestParam("mould_id") Integer mould_id) {
		preService.del_pre(mould_id);		
		return Msg.success();
	}
	@RequestMapping("/open_pre")
	@ResponseBody
	public Msg open_pre(@RequestParam("pre_id") Integer pre_id) {
		preService.open_pre(pre_id);		
		return Msg.success();
	}
	@RequestMapping("/give_up_pre")
	@ResponseBody
	public Msg give_up_pre(@RequestParam("pre_id") Integer pre_id) {
		preService.give_up_pre(pre_id);		
		return Msg.success();
	}
	@RequestMapping("/load_allpre")
	@ResponseBody
	public Msg getAllPre(@RequestParam("medrecord_code") Integer medrecord,@RequestParam(value = "open_date", defaultValue = "null") String open_date) {
		
		List<Prescription> prelist=preService.getAllPre(medrecord,open_date);		
		return Msg.success().add("prelist", prelist);
	}
	
	@RequestMapping("/store_pre")
	@ResponseBody
	public Msg store_pre(@RequestParam("medrecord_code") Integer medrecord,@RequestParam("regnum") Integer regnum,@RequestParam("doctor_id") Integer doctor_id
			,@RequestParam("pre_name") String pre_name,@RequestParam("state") String state) {
		int prestate=0;
		if(state.equals("暂存")) {
			prestate=1;
		}else if(state.equals("开立")){
			prestate=2;
		}else {
			prestate=3;
		}
		Integer mould_id=preService.store_pre(medrecord,regnum,doctor_id,pre_name,prestate);		
		return Msg.success().add("mould_id", mould_id);
	}
	
	
}
