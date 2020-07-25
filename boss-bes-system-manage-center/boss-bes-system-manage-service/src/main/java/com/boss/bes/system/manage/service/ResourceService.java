package com.boss.bes.system.manage.service;


import com.boss.bes.system.manage.pojo.query.ResourcePageQuery;
import com.boss.bes.system.manage.pojo.vo.ResourceTreeVO;
import com.boss.bes.system.manage.pojo.vo.ResourceVO;
import com.github.pagehelper.PageInfo;

import java.util.List;

/**
 * @description:资源的业务层
 * @author:zyz
 * @time:2020/7/10-14:35
 */
public interface ResourceService {
    PageInfo<ResourceVO> queryAllWithPageAndParent(ResourcePageQuery resourcePageQuery);



    /**
     * 查询树
     * @return
     */
    List<ResourceTreeVO> queryTree();
}
