package cn.neu.his.controller;


import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import cn.neu.his.bean.Msg;
import cn.neu.his.bean.Register;
import cn.neu.his.service.RegisterService;

/**
 * @author zyz1010561415
 *
 */
@Controller
public class RegisterController {
	@Autowired
	RegisterService registerService;
	
	@RequestMapping("/load_medrecord")
	@ResponseBody
	public Msg getPatient(@RequestParam("medrecord_code") Integer medrecord) {
		List<Register> reglist=registerService.getPatient(medrecord);
		
		return Msg.success().add("reglist", reglist);
	}
	
	@RequestMapping("/done_all_zhenduan")
	@ResponseBody
	public Msg done_zhenduan(@RequestParam("medrecord_code") Integer medrecord,@RequestParam("regnum") Integer regnum) {
		Boolean b=registerService.done_zhenduan(medrecord,regnum);
		if(b)
		return Msg.success();
		else
		return Msg.fail();
	}
	@RequestMapping("/doc_load_patient")
	@ResponseBody
	public Msg get_docPatient(@RequestParam("regnum") Integer regnum) {
		List<Register> reglist=registerService.get_docPatient(regnum);	
		return Msg.success().add("reglist", reglist);
	}
	@RequestMapping("/load_patientlist")
	@ResponseBody
	public Msg getAllPatient(@RequestParam("login_doctorid") Integer login_doctorid) {
		List<Register> patientlist=registerService.getAllPatient(login_doctorid);
		
		return Msg.success().add("patientlist", patientlist);
	}
	
	
	@RequestMapping("/load_maxmedrecord")
	@ResponseBody
	public Msg getMaxmed() {
		long maxmed=registerService.getMaxmed();
		return Msg.success().add("maxmed", maxmed);
	}
	@RequestMapping("/start_regist")
	@ResponseBody
	public Msg start_regist(@RequestParam("medrecord_code") Integer medrecord_code,@RequestParam("patient_name") String patient_name,
							@RequestParam("sex") String sex,@RequestParam("patient_IDCard") String patient_IDCard,
							@RequestParam("patient_birth") String patient_birth,@RequestParam("patient_age") Integer patient_age,
							@RequestParam("year_type") String year_type,@RequestParam("patient_Address") String patient_Address,
							@RequestParam("noonbreak") String noonbreak,@RequestParam("dept_Name") Integer dept_Name,
							@RequestParam("doctors") Integer doctors,@RequestParam("reg_type") Integer reg_type,
							@RequestParam("jiasuan_type") Integer jiasuan_type,@RequestParam("visitdate") String visitdate,
							@RequestParam("med_book") Integer med_book){													
								Boolean b=registerService.start_regist(medrecord_code,patient_name,sex,patient_IDCard,patient_birth,patient_age
										,year_type,patient_Address,visitdate,noonbreak,dept_Name,doctors,reg_type,jiasuan_type,med_book);
									if(b) {
										return Msg.success();
									}else {
										return Msg.fail();
									}
							
	}
	@RequestMapping("/load_regnum")
	@ResponseBody
	public Msg loadRegnum(@RequestParam("visitdate") String visitdate,@RequestParam("noonbreak") String noonbreak,@RequestParam("doctors") Integer doctors) {
		long num=registerService.loadRegnum(visitdate,noonbreak,doctors);
		return Msg.success().add("num", num);
	}	
	
	@RequestMapping("/load_reglist")
	@ResponseBody
	public Msg loadReglist(@RequestParam(value = "pageNumber", defaultValue = "1") Integer pageNumber,@RequestParam("medrecord_code") Integer medrecord_code) {
				// 引入分页插件PageHleper
				// 在查询之前调用即可
				PageHelper.startPage(pageNumber, 5);
				// startPage之后紧跟着的查询就是分页查询
				// 用PageInfo对结果进行包装
				// 将pagaInfo交给页面就可以了，封装了详细的分页信息，包括有我们的查询数据
				// 传入连续显示的页数
				List<Register> reglist=registerService.loadReglist(medrecord_code);
				PageInfo<Register>  page = new PageInfo<Register>(reglist, 5);
				//System.out.println(page.getSize());
				return Msg.success().add("pageInfo", page);
	}
	
	@RequestMapping("/tuihao")
	@ResponseBody
	public Msg Tuihao(@RequestParam("reg_id") Integer reg_id) {
		
		Boolean b=registerService.Tuihao(reg_id);
		if(b)
		return Msg.success();
		else
			return Msg.fail();
	}
}
