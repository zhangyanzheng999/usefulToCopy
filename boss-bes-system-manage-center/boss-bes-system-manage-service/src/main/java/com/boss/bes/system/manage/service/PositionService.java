package com.boss.bes.system.manage.service;


import com.boss.bes.system.manage.pojo.query.PositionPageQuery;
import com.boss.bes.system.manage.pojo.vo.PositionVO;
import com.github.pagehelper.PageInfo;

import java.util.List;

/**
 * @description:职位的业务层
 * @author:zyz
 * @time:2020/7/12-10:25
 */
public interface PositionService {
    PageInfo<PositionVO> queryAllWithPageAndCompany(PositionPageQuery pageQuery);

    List<PositionVO> queryPositionByCompanyId(Long companyId);
}
