package cn.neu.his.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.neu.his.bean.Drug;
import cn.neu.his.bean.Msg;
import cn.neu.his.service.DrugsService;

/**
 * @author zyz1010561415
 *
 */
@Controller
public class DrugsController {

	@Autowired
	DrugsService drugsService;
	
	@RequestMapping("/load_drug")
	@ResponseBody
	public Msg getDrug(@RequestParam("drugID") Integer drugID) {
		List<Drug> druglist=drugsService.getDrug(drugID);	
		return  Msg.success().add("druglist", druglist);
		
	}
	
	@RequestMapping("/load_allopen_drug")
	@ResponseBody
	public Msg load_allopen_drug(@RequestParam("drug_name") String drug_name) {
		List<Drug> druglist=drugsService.load_allopen_drug(drug_name);	
		return  Msg.success().add("druglist", druglist);
		
	}
}
