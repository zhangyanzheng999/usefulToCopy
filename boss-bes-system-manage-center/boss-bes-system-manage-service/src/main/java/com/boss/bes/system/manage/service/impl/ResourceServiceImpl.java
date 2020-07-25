package com.boss.bes.system.manage.service.impl;

import com.boss.bes.system.manage.dao.ResourceDao;
import com.boss.bes.system.manage.mapper.ResourceMapper;
import com.boss.bes.system.manage.pojo.dto.ResourceDTO;
import com.boss.bes.system.manage.pojo.entity.Resource;
import com.boss.bes.system.manage.pojo.query.ResourcePageQuery;
import com.boss.bes.system.manage.pojo.query.common.BaseQuery;
import com.boss.bes.system.manage.pojo.vo.ResourceTreeVO;
import com.boss.bes.system.manage.pojo.vo.ResourceVO;
import com.boss.bes.system.manage.service.BaseCRUDService;
import com.boss.bes.system.manage.service.ResourceService;
import com.boss.bes.system.manage.util.BeanUtil;
import com.github.pagehelper.PageInfo;
import com.github.pagehelper.page.PageMethod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * @description:资源业务类的实现层
 * @author:zyz
 * @time:2020/7/10-14:35
 */
@Service
public class ResourceServiceImpl extends BaseCRUDService<Resource, ResourceDTO, ResourceVO, ResourcePageQuery, ResourceMapper> implements ResourceService {

    @Autowired
    ResourceDao resourceDao;

    /**
     * 查询资源，并且查询出父节点的名字
     * @param resourcePageQuery
     * @return
     */
    @Override
    public PageInfo<ResourceVO> queryAllWithPageAndParent(ResourcePageQuery resourcePageQuery) {
        PageMethod.startPage(resourcePageQuery.getPageNum(), resourcePageQuery.getPageSize());
        List<Resource> resources = resourceDao.queryAllWithPageAndParent("%" + resourcePageQuery.getName() + "%", resourcePageQuery.getParentId());
        PageInfo<Resource> pageInfo = new PageInfo<>(resources, 5);
        return BeanUtil.convertPageInfo(pageInfo, ResourceVO.class);
    }


    @Override
    public ResourceVO query(BaseQuery query) {
        Resource resource = resourceDao.query(query.getId(), query.getVersion());
        return BeanUtil.copyData(resource, ResourceVO.class);
    }

    /**
     * 构建资源树
     *
     * @return
     */
    @Override
    public List<ResourceTreeVO> queryTree() {
        Example example = new Example(Resource.class);
        //查出所有的顶级资源 父节点为null,不是叶子结点
        example.createCriteria().andIsNull("parentId").andEqualTo("leaf", false);
        List<ResourceTreeVO> resourceTreeVOS = BeanUtil.convertListToList(this.myDao.getListByExample(example), ResourceTreeVO.class);
        for (ResourceTreeVO resourceTreeVO : resourceTreeVOS) {
            buildTree(resourceTreeVO);
        }
        return resourceTreeVOS;
    }

    /**
     * 用来构造树
     */
    public void buildTree(ResourceTreeVO resourceTreeVO) {
        //如果是叶子结点或者为null时返回，但是注意判断一下叶子结点是否为null，否则会报错
        if (resourceTreeVO == null || resourceTreeVO.getLeaf() == null || resourceTreeVO.getLeaf()) return;
        //查询所有子节点
        Example example = new Example(Resource.class);
        example.createCriteria().andEqualTo("parentId", resourceTreeVO.getId());
        //所有孩子结点,为空结束
        List<ResourceTreeVO> childList = BeanUtil.convertListToList(this.myDao.getListByExample(example), ResourceTreeVO.class);
        if (childList.isEmpty()) return;
        //给孩子结点赋值
        resourceTreeVO.setChildren(childList);
        //递归去构造资源树
        for (ResourceTreeVO treeVO : resourceTreeVO.getChildren()) {
            buildTree(treeVO);
        }
    }

    /**
     * 更新，返回是否成功
     *
     * @param dto
     * @return
     */
    @Override
    public Integer update(ResourceDTO dto) {
        Example example = new Example(Resource.class);
        example.createCriteria().andEqualTo("id", dto.getId()).andEqualTo("version", dto.getVersion());
        return myDao.update(BeanUtil.copyData(dto, Resource.class), example);
    }

    /**
     * 用来验证code是有使用过
     * 如果结果集不为空就是使用过
     *
     * @param code
     * @return
     */
    @Override
    public Boolean validateCode(String code) {
        Example example = new Example(Resource.class);
        example.createCriteria().andEqualTo("code", code);
        return myDao.getListByExample(example).isEmpty();
    }

    /**
     * 用来验证name是有使用过
     * 如果结果集不为空就是使用过
     *
     * @param name
     * @return
     */
    @Override
    public Boolean validateName(String name) {
        Example example = new Example(Resource.class);
        example.createCriteria().andEqualTo("name", name);
        return myDao.getListByExample(example).isEmpty();
    }
}
