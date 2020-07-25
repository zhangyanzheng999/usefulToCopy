package com.boss.bes.system.manage.dao.impl;

import com.boss.bes.system.manage.dao.UserOnlineInfoDao;

import com.boss.bes.system.manage.mapper.UserOnlineInfoMapper;
import com.boss.bes.system.manage.pojo.entity.UserOnlineInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserOnlineInfoDaoImpl implements UserOnlineInfoDao {
    @Autowired
    UserOnlineInfoMapper userOnlineInfoMapper;

    /**
     * 按条件查询
     * @param userOnlineInfo
     * @return
     */
    @Override
    public List<UserOnlineInfo> getUserOnlineInfoByCondition(UserOnlineInfo userOnlineInfo) {
        return userOnlineInfoMapper.getUserOnlineInfoByCondition(userOnlineInfo);
    }

    /**
     * 用户批量下线
     * @param userOnlineInfos
     * @return
     */
    @Override
    public Integer updateToLogout(List<UserOnlineInfo> userOnlineInfos) {
        return userOnlineInfoMapper.updateToLogout(userOnlineInfos);
    }

    @Override
    public Integer updateByPrimaryKeySelective(UserOnlineInfo userOnlineInfo){
        return userOnlineInfoMapper.updateByPrimaryKeySelective(userOnlineInfo);
    }

    /**
     * 加入新的在线用户
     * @param userOnlineInfo
     * @return
     */
    @Override
    public Integer insert(UserOnlineInfo userOnlineInfo) {
        return userOnlineInfoMapper.insert(userOnlineInfo);
    }

    /**
     * 通过id查询用户
     * @param id
     * @return
     */
    @Override
    public UserOnlineInfo getByPrimaryKey(Long id) {
        return userOnlineInfoMapper.getByPrimaryKey(id);
    }

    @Override
    public Integer deleteUserById(Long id) {
        return userOnlineInfoMapper.deleteUserById(id);

    }

    /**
     * 获得所有的在线用户
     * @return
     */
    @Override
    public List<UserOnlineInfo> getAll(){

        return userOnlineInfoMapper.getAll();
    }

}
