package cn.neu.his.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import cn.neu.his.bean.User;
import cn.neu.his.bean.UserExample;
import cn.neu.his.bean.UserExample.Criteria;
import cn.neu.his.dao.UserMapper;
/**
 * @author zyz1010561415
 *
 */
@Service
public class UserService {
	@Autowired
	UserMapper usermapper;
	//得到所有人员信息
	public List<User> getAll() {
		// TODO Auto-generated method stub
		return usermapper.selectByExample(null);
	}
	/**
	 * 检查登陆
	 * @author zyz1010561415
	 *
	 */
	public List<User> check(String username, String passward) {
		// TODO Auto-generated method stub
		UserExample example=new UserExample();
		Criteria criteria=example.createCriteria();
		criteria.andUserNameEqualTo(username).andUserPasswardEqualTo(passward);
		List<User> doclist=usermapper.selectByExample(example);
		return doclist;
	}
	public List<User> load_doctor(int deptId,int regtypeid) {
		UserExample example=new UserExample();
		Criteria criteria=example.createCriteria();
		criteria.andDeptIdEqualTo(deptId).andRegisterTypeIdEqualTo(regtypeid);
		List<User> doclist=usermapper.selectByExample(example);
		// TODO Auto-generated method stub
		return doclist;
	}
	public List<User> load_docName(Integer doctorId) {
		// TODO Auto-generated method stub
		UserExample example=new UserExample();
		Criteria criteria=example.createCriteria();
		criteria.andUserIdEqualTo(doctorId);
		List<User> doclist=usermapper.selectByExample(example);
		return doclist;
	}

}
