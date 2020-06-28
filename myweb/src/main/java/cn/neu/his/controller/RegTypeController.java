package cn.neu.his.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.neu.his.bean.Msg;
import cn.neu.his.bean.RegType;
import cn.neu.his.service.RegTypeService;


/**
 * @author zyz1010561415
 *
 */
@Controller
public class RegTypeController {
	@Autowired
	RegTypeService regtypeService;
	
	
	
	
	@RequestMapping("/load_typeid")
	@ResponseBody
	public Msg load_regtype(@RequestParam("regtypeid") Integer regtypeid) {	
		RegType reg=regtypeService.load_regtype(regtypeid);
	 	return Msg.success().add("reg", reg);
				
	}
	
	
}
