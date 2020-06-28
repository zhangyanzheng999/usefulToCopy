package cn.neu.his.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.neu.his.bean.Mould;
import cn.neu.his.bean.Msg;
import cn.neu.his.service.MouldService;

/**
 * @author zyz1010561415
 *
 */
@Controller
public class MouldController {
	@Autowired
	MouldService realmouldService;
	
	@RequestMapping("/load_mould")
	@ResponseBody
	public Msg load_mould(@RequestParam("mouldname") String mouldname) {
		List<Mould> mouldlist=realmouldService.load_mould(mouldname);
		
		return Msg.success().add("mouldlist", mouldlist);
	}

	@ResponseBody
	@RequestMapping("/find_west_mould")
	public Msg find_mould(@RequestParam("templateName") String templateName,@RequestParam("templateRange") String templateRange){
		return Msg.success().add("list",realmouldService.find_mould(templateName,templateRange));
	}

	@ResponseBody
	@RequestMapping("/add_new_west_mould")
	public Msg add_new_mould(@RequestParam("doctorID") String doctorID,@RequestParam("mouldName") String mouldName,@RequestParam("mouldRange") String mouldRange){

		realmouldService.addNewMould(doctorID,mouldName,mouldRange);
		return  Msg.success();
	}

	@ResponseBody
	@RequestMapping("/delete_west_mould")
	public Msg deleteWestMould(@RequestParam("mouldID") String mouldID){
		realmouldService.deleteWestMould(mouldID);
		return  Msg.success();
	}

	@ResponseBody
	@RequestMapping("/modifyWestMould")
	public  Msg modifyWestMould(@RequestParam("mouldID") String mouldID,@RequestParam("mouldName") String mouldName,@RequestParam("mouldRange") String mouldRange){
		realmouldService.modifyWestMould(mouldID,mouldName,mouldRange);
		return Msg.success();
	}
}
