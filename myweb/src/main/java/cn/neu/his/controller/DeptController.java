package cn.neu.his.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.neu.his.bean.Dept;
import cn.neu.his.bean.Msg;
import cn.neu.his.service.DeptService;

/**
 * 部门信息
 * @author zyz1010561415
 * 
 *
 */

@Controller
public class DeptController {
	@Autowired
	private DeptService deptservice;
	/**
	 * 
	 * @author zyz1010561415
	 *
	 */
	
	@RequestMapping("/dept")
	@ResponseBody
	public Msg getDept() {
		//得到所有部门信息	
		List<Dept> list=deptservice.getDept();
		return Msg.success().add("deptlist", list);
		
	}
	/*public static void main(String args[]) {
		System.out.println(1);
	}*/
	@RequestMapping("/turn_to_deptName")
	@ResponseBody
	public Msg turn_to_deptName(@RequestParam("deptName") Integer deptName) {
		//得到所有部门信息	
		List<Dept> dept=deptservice.turn_to_deptName(deptName);
		return Msg.success().add("dept", dept.get(0));
		
	}
	
	@RequestMapping("/load_doc_depart")
	@ResponseBody
	public Msg load_doc_depart(@RequestParam("doc_depart") Integer doc_depart) {
		//得到所有部门信息	
		List<Dept> departlist=deptservice.load_doc_depart(doc_depart);
		return Msg.success().add("departlist", departlist);
		
	}
}
