package cn.neu.his.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.neu.his.bean.Disease;
import cn.neu.his.bean.Msg;
import cn.neu.his.service.DiseaseService;

/**
 * @author zyz1010561415
 *
 */
@Controller
public class DiseaseController {
	@Autowired
	DiseaseService diseaseService;
	
	
	@RequestMapping("/load_xiyi_disease")
	@ResponseBody
	public Msg load_xiyi(@RequestParam("disease_name") String xiyi_disease) {
		
		List<Disease> dislist=diseaseService.load_xiyi(xiyi_disease);
		
		return Msg.success().add("dislist", dislist);
		
	}
	@RequestMapping("/load_detail_xiyi_disease")
	@ResponseBody
	public Msg load_detail_xiyi(@RequestParam("disease_id") Integer disease_id) {
		
		List<Disease> dislist=diseaseService.load_detail_xiyi(disease_id);
		
		return Msg.success().add("dislist", dislist);
		
	}
	
}
