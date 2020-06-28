package cn.neu.his.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.neu.his.bean.Detailpre;
import cn.neu.his.bean.DetailpreExample;
import cn.neu.his.bean.DetailpreExample.Criteria;
import cn.neu.his.dao.DetailpreMapper;

/**
 * @author zyz1010561415
 *
 */
@Service
public class DetailpreService {
		@Autowired
		DetailpreMapper detailpreMapper;
		//根据处方号得到具体处方
	public List<Detailpre> getDetailPre(Integer preID) {
		// TODO Auto-generated method stub
		DetailpreExample example=new DetailpreExample();
		Criteria criteria=example.createCriteria();
		criteria.andPreIdEqualTo(preID).andDetailpreStateNotEqualTo(6);
		example.setOrderByClause("DetialPre_ID DESC");
		List<Detailpre> detailprelist=detailpreMapper.selectByExample(example);
		return detailprelist;
	}
	//收费
	public void ChangeState(Integer preID, Integer itemid) {
		// TODO Auto-generated method stub
		DetailpreExample example=new DetailpreExample();
		Criteria criteria=example.createCriteria();
		criteria.andPreIdEqualTo(preID).andDrugsIdEqualTo(itemid);
		Detailpre detail=new Detailpre();
		detail.setDetailpreState(1);
		detailpreMapper.updateByExampleSelective(detail, example);
	}
	//发放药品
	public void OpenDrugState(Integer detailid) {
		// TODO Auto-generated method stub
		DetailpreExample example=new DetailpreExample();
		Criteria criteria=example.createCriteria();
		criteria.andDetialpreIdEqualTo(detailid);
		Detailpre detail=new Detailpre();
		detail.setDetailpreState(4);
		detailpreMapper.updateByExampleSelective(detail, example);
	}
	public void del_detailpre(Integer mould_id) {
		DetailpreExample example=new DetailpreExample();
		Criteria criteria=example.createCriteria();
		criteria.andPreIdEqualTo(mould_id);
		detailpreMapper.deleteByExample(example);
	}
	public int add_drug_todb(Integer pre_id, Integer drug_id, String yong_fa, String yong_liang, String pin_ci,
			Integer num) {
		// TODO Auto-generated method stub
		Integer Kong=null;
		Detailpre detail=new Detailpre(null,pre_id,drug_id,yong_fa,yong_liang,pin_ci,num,1);
		detailpreMapper.insert(detail);
		DetailpreExample example=new DetailpreExample();
		Criteria criteria=example.createCriteria();
		criteria.andDetialpreIdIsNotNull();
		example.setOrderByClause("DetialPre_ID DESC");
		List<Detailpre> list=detailpreMapper.selectByExample(example);
		return list.get(0).getDetialpreId();

	}
	public Boolean del_opende_detail_fromdb(Integer detail_id) {
		DetailpreExample example=new DetailpreExample();
		Criteria criteria=example.createCriteria();
		criteria.andDetialpreIdEqualTo(detail_id);
		detailpreMapper.deleteByExample(example);
		return true;
	}
	//开立处方
	public void open_detail_pre(Integer pre_id) {
		// TODO Auto-generated method stub
		DetailpreExample example=new DetailpreExample();
		Criteria criteria=example.createCriteria();
		criteria.andPreIdEqualTo(pre_id);
		Detailpre detail=new Detailpre();
		detail.setDetailpreState(0);
		detailpreMapper.updateByExampleSelective(detail, example);
	}
	//作废处方
	public void give_up_detailpre(Integer pre_id) {
		// TODO Auto-generated method stub
		DetailpreExample example=new DetailpreExample();
		Criteria criteria=example.createCriteria();
		criteria.andPreIdEqualTo(pre_id);
		Detailpre detail=new Detailpre();
		detail.setDetailpreState(6);
		detailpreMapper.updateByExampleSelective(detail, example);
	}
	

}
