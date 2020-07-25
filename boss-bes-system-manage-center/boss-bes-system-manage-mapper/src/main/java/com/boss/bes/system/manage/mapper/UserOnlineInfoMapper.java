package com.boss.bes.system.manage.mapper;




import com.boss.bes.system.manage.pojo.entity.UserOnlineInfo;

import java.util.List;

public interface UserOnlineInfoMapper extends CommonMapper<UserOnlineInfo> {


    /**
     * 条件查询
     * @param userOnlineInfo
     * @return
     */
    List<UserOnlineInfo> getUserOnlineInfoByCondition(UserOnlineInfo userOnlineInfo);

    /**
     * @return
     */
    List<UserOnlineInfo> getAll();
    /**
     * 强制下线
     * @param userOnlineInfos
     * @return
     */
    Integer updateToLogout(List<UserOnlineInfo> userOnlineInfos);

    /**
     * @param id
     * @return
     */
    UserOnlineInfo getByPrimaryKey(Long id);

    Integer deleteUserById(Long id);
}