package cn.neu.his.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import cn.neu.his.bean.Msg;
import cn.neu.his.bean.User;
import cn.neu.his.service.UserService;

/**
 * @author zyz1010561415
 *
 */
@Controller
public class UserController {
	@Autowired
	UserService userService;

	public Msg getUser() {	
		List<User> alluser=userService.getAll();	
		return Msg.success().add("alluser",alluser);
		
	}
	
	@RequestMapping("/checklogin")
	@ResponseBody
	public Msg check(@RequestParam("username") String username,@RequestParam("passward") String passward) {	
		List<User> doclist=userService.check(username,passward);
		if(doclist.size()>0) {
		return Msg.success().add("doclist", doclist);
		}	else {
			return Msg.fail();
		}
		
	}
	@RequestMapping("/load_doctor")
	@ResponseBody
	public Msg load_doctor(@RequestParam("deptId") Integer deptId,@RequestParam("regtypeid") Integer regtypeid) {	
		List<User> doclist=userService.load_doctor(deptId,regtypeid);
	 	return Msg.success().add("doclist", doclist);
				
	}
	@RequestMapping("/load_docname")
	@ResponseBody
	public Msg load_docName(@RequestParam("doctorId") Integer doctorId) {	
		List<User> doclist=userService.load_docName(doctorId);
	 	return Msg.success().add("doclist", doclist);
				
	}

}
