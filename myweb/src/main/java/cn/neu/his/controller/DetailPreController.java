package cn.neu.his.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.neu.his.bean.Detailpre;
import cn.neu.his.bean.Msg;
import cn.neu.his.service.DetailpreService;

/**
 * @author zyz1010561415
 *
 */
@Controller
public class DetailPreController {
	@Autowired
	DetailpreService detailpreService;
	
	@RequestMapping("/load_detailpre")
	@ResponseBody
	public Msg getDetailPre(@RequestParam("preID") Integer preID) {
		List<Detailpre> detailprelist=detailpreService.getDetailPre(preID);
		return Msg.success().add("detailprelist", detailprelist);
	}
	@RequestMapping("/del_opende_detail_fromdb")
	@ResponseBody
	public Msg del_opende_detail_fromdb(@RequestParam("detail_id") Integer detail_id) {
		Boolean b =detailpreService.del_opende_detail_fromdb(detail_id);
		if(b)
		return Msg.success();
		else 
			return Msg.fail();
	}
	@RequestMapping("/change_detailstate")
	@ResponseBody
	public void ChangeState(@RequestParam("preID") Integer preID,@RequestParam("itemid") Integer itemid) {
		 detailpreService.ChangeState(preID,itemid);
		 
	}
	@RequestMapping("/done_open_drug")
	@ResponseBody
	public void OpenDrugState(@RequestParam("detailid") Integer detailid) {
		 detailpreService.OpenDrugState(detailid);
		 
	}
	@RequestMapping("/del_detail_fromdb")
	@ResponseBody
	public Msg del_detailpre(@RequestParam("mould_id") Integer mould_id) {
		detailpreService.del_detailpre(mould_id);		
		return Msg.success();
	}
	@RequestMapping("/open_detail_pre")
	@ResponseBody
	public Msg open_detail_pre(@RequestParam("pre_id") Integer pre_id) {
		detailpreService.open_detail_pre(pre_id);		
		return Msg.success();
	}
	@RequestMapping("/give_up_detailpre")
	@ResponseBody
	public Msg give_up_detailpre(@RequestParam("pre_id") Integer pre_id) {
		detailpreService.give_up_detailpre(pre_id);		
		return Msg.success();
	}
	@RequestMapping("/add_drug_todb")
	@ResponseBody
	public Msg add_drug_todb(@RequestParam("pre_id") Integer pre_id,@RequestParam("drug_id") Integer drug_id,@RequestParam("yong_fa") String yong_fa
			,@RequestParam("yong_liang") String yong_liang,@RequestParam("pin_ci") String pin_ci,@RequestParam("num") Integer num) {
		int detail_id=detailpreService.add_drug_todb(pre_id,drug_id,yong_fa,yong_liang,pin_ci,num);		
		return Msg.success().add("detail_id", detail_id);
	}
}
