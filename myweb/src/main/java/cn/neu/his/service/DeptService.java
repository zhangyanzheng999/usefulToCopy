package cn.neu.his.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.neu.his.bean.Dept;
import cn.neu.his.bean.DeptExample;
import cn.neu.his.bean.DeptExample.Criteria;
import cn.neu.his.dao.DeptMapper;
/**
 * @author zyz1010561415
 *
 */
@Service
public class DeptService {
	@Autowired
	private DeptMapper deptMapper;
	
	public List<Dept> getDept() {
		// TODO Auto-generated method stub
		List<Dept> list=deptMapper.selectByExample(null);
		return list;
	}

	public List<Dept> turn_to_deptName(Integer deptName) {
		// TODO Auto-generated method stub
		DeptExample example=new DeptExample();
		Criteria criteria=example.createCriteria();
		criteria.andDeptIdEqualTo(deptName);
		List<Dept> dept= deptMapper.selectByExample(example);
		
		return dept;
	}

	public List<Dept> load_doc_depart(Integer doc_depart) {
		DeptExample example=new DeptExample();
		Criteria criteria=example.createCriteria();
		criteria.andDeptIdEqualTo(doc_depart);
		List<Dept> departlist= deptMapper.selectByExample(example);
		
		return departlist;
	}
	
}
