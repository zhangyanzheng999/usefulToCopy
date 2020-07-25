package com.boss.bes.system.manage.service;



import com.boss.bes.system.manage.pojo.dto.UserOnlineInfoDTO;
import com.boss.bes.system.manage.pojo.query.UserOnlineInfoPageQuery;
import com.boss.bes.system.manage.pojo.vo.UserOnlineInfoVO;
import com.github.pagehelper.PageInfo;

import java.util.List;


/**
 * @author 小城大梦
 */
public interface UserOnlineInfoService {



    /**
     * 增加记录
     * @return
     */
    int insert(UserOnlineInfoDTO userOnlineInfoDTO);

    /**
     * 根据删除记录
     * @return
     */
    int delete(List<UserOnlineInfoDTO> userOnlineInfoDTOs);

    /**
     * 更新记录
     * @return
     */
    int update(UserOnlineInfoDTO userOnlineInfoDTO);

    /**
     * 批量更新记录
     * @return
     */
    int updateList(List<UserOnlineInfoDTO> userOnlineInfoDTOS);

    /**
     * 根据主键查询记录
     * @return
     */
    UserOnlineInfoDTO getByPrimaryKey(Long id);
    /**
     * 根据主键查询记录
     * @return
     */
    UserOnlineInfoDTO getByPrimaryKey(UserOnlineInfoDTO userOnlineInfoDTO);

    /**
     * 根据条件查询记录，当Condition为空时，返回所有
     * @return
     */
    PageInfo<UserOnlineInfoVO> queryByCondition(UserOnlineInfoPageQuery userOnlineInfoPageQuery);

    /**
     * 查询dto
     * @return
     */
    List<UserOnlineInfoDTO> queryDTO(UserOnlineInfoDTO userOnlineInfoDTO);

    /**
     * @return
     */
    List<UserOnlineInfoDTO> queryAll();

    PageInfo<UserOnlineInfoVO> queryWithPage(UserOnlineInfoPageQuery p);

}
