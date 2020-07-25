package com.boss.bes.system.manage.dao;



import com.boss.bes.system.manage.pojo.entity.UserOnlineInfo;

import java.util.List;

/**
 * @description: 在线用户
 * @author:xjc
 * @time:2020/7/10-19:30
 */

public interface UserOnlineInfoDao {



    /**
     * 条件查询
     * @param userOnlineInfoDTO
     * @return
     */
    List<UserOnlineInfo> getUserOnlineInfoByCondition(UserOnlineInfo userOnlineInfoDTO);


    /**
     * 获取全部在线用户信息并进行分页
     * @return
     */
    List<UserOnlineInfo> getAll();
    /**
     * 强制下线
     * @param userOnlineInfos
     * @return
     */
    Integer updateToLogout(List<UserOnlineInfo> userOnlineInfos);


    Integer updateByPrimaryKeySelective(UserOnlineInfo userOnlineInfo);

    Integer insert(UserOnlineInfo userOnlineInfo);

    UserOnlineInfo getByPrimaryKey(Long id);

    Integer deleteUserById(Long id);
}
