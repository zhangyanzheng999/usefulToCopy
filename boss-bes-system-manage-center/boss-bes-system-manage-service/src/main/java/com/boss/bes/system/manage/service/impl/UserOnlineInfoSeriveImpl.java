package com.boss.bes.system.manage.service.impl;

import boss.bes.log.exception.code.enums.BaseCodeEnum;
import boss.bes.log.exception.type.ServiceException;
import com.boss.bes.system.manage.dao.UserOnlineInfoDao;
import com.boss.bes.system.manage.pojo.dto.UserOnlineInfoDTO;
import com.boss.bes.system.manage.pojo.entity.UserOnlineInfo;
import com.boss.bes.system.manage.pojo.query.UserOnlineInfoPageQuery;
import com.boss.bes.system.manage.pojo.vo.UserOnlineInfoVO;
import com.boss.bes.system.manage.service.UserOnlineInfoService;
import com.boss.bes.system.manage.util.BeanUtil;
import com.github.pagehelper.PageInfo;
import com.github.pagehelper.page.PageMethod;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


/**
 * @author 小城大梦
 */
@Service
public class UserOnlineInfoSeriveImpl implements UserOnlineInfoService {
    @Autowired
    UserOnlineInfoDao userOnlineInfoDao;

    /**
     * 在线状态
     */
    private static final Byte ONLINE_STATUS = 0;


    /**
     * 用户上线，将数据插入数据库在线用户表
     *
     * @param userOnlineInfoDTO
     * @return
     * @update lujinshan
     * @date 2019.09.26
     */
    @Override
    public int insert(UserOnlineInfoDTO userOnlineInfoDTO) {
        UserOnlineInfo userOnlineInfo = new UserOnlineInfo();
        BeanUtil.copyData(userOnlineInfoDTO, userOnlineInfo);
        userOnlineInfo.setOnlineTime(new Date());
        //设置状态在线
        userOnlineInfo.setStatus(ONLINE_STATUS);
        if (this.getByPrimaryKey(userOnlineInfoDTO.getId()) != null) {
            userOnlineInfoDao.deleteUserById(userOnlineInfoDTO.getId());
        }

        try {
            userOnlineInfoDao.insert(userOnlineInfo);
        } catch (Exception e) {
            throw new ServiceException(BaseCodeEnum.BASE_DATA_UPDATE_EXCEPTION);
        }
        return 0;
    }

    /**
     * 删除
     *
     * @param userOnlineInfoDTOs
     * @return
     */
    @Override
    @Transactional
    public int delete(List<UserOnlineInfoDTO> userOnlineInfoDTOs) {
        return 0;
    }

    /**
     * 用户下线，将数据库数据修改
     *
     * @param userOnlineInfoDTO
     * @return
     * @update lujinshan
     * @date 2019.09.26
     */
    @Override
    @Transactional
    public int update(UserOnlineInfoDTO userOnlineInfoDTO) {
        UserOnlineInfo userOnlineInfo = new UserOnlineInfo();
        BeanUtil.copyData(userOnlineInfoDTO, userOnlineInfo);
        List<UserOnlineInfo> userOnlineInfoS = new ArrayList<>();
        userOnlineInfoS.add(userOnlineInfo);
        try {
            return userOnlineInfoDao.updateToLogout(userOnlineInfoS);
        } catch (Exception e) {
            throw new ServiceException(BaseCodeEnum.BASE_DATA_UPDATE_EXCEPTION);
        }

    }


    @Override
    @Transactional
    public int updateList(List<UserOnlineInfoDTO> userOnlineInfoDTOS) {
        List<UserOnlineInfo> userOnlineInfoS = new ArrayList<>();
        for (UserOnlineInfoDTO userOnlineInfoDTO : userOnlineInfoDTOS) {
            userOnlineInfoS.add(BeanUtil.copyData(userOnlineInfoDTO, UserOnlineInfo.class));
        }

        return userOnlineInfoDao.updateToLogout(userOnlineInfoS);

    }

    @Override
    public UserOnlineInfoDTO getByPrimaryKey(UserOnlineInfoDTO userOnlineInfoDTO) {
        return null;
    }

    @Override
    public UserOnlineInfoDTO getByPrimaryKey(Long id) {
        UserOnlineInfo userOnlineInfo = userOnlineInfoDao.getByPrimaryKey(id);
        UserOnlineInfoDTO dto = new UserOnlineInfoDTO();
        BeanUtils.copyProperties(userOnlineInfo, dto);
        return dto;
    }

    @Override
    public PageInfo<UserOnlineInfoVO> queryByCondition(UserOnlineInfoPageQuery userOnlineInfoPageQuery) {
        PageMethod.startPage(userOnlineInfoPageQuery.getPageNum(), userOnlineInfoPageQuery.getPageSize());
        UserOnlineInfo userOnlineInfo = new UserOnlineInfo();
        BeanUtil.copyData(userOnlineInfoPageQuery, userOnlineInfo);
        List<UserOnlineInfo> results = userOnlineInfoDao.getUserOnlineInfoByCondition(userOnlineInfo);
        PageInfo<UserOnlineInfo> pageInfo = new PageInfo<>(results, 5);
        return BeanUtil.convertPageInfo(pageInfo, UserOnlineInfoVO.class);
    }

    @Override
    public List<UserOnlineInfoDTO> queryDTO(UserOnlineInfoDTO userOnlineInfoDTO) {
        return new ArrayList<>();
    }

    @Override
    public List<UserOnlineInfoDTO> queryAll() {
        List<UserOnlineInfo> results = userOnlineInfoDao.getAll();

        List<UserOnlineInfoDTO> dtos = new ArrayList<>(results.size());
        if (results != null) {
            for (UserOnlineInfo result : results) {
                dtos.add(BeanUtil.copyData(result, UserOnlineInfoDTO.class));
            }
        }
        return dtos;
    }

    @Override
    public PageInfo<UserOnlineInfoVO> queryWithPage(UserOnlineInfoPageQuery p) {
        PageMethod.startPage(p.getPageNum(), p.getPageSize());
        List<UserOnlineInfo> userOnlineInfoList = userOnlineInfoDao.getAll();
        PageInfo<UserOnlineInfo> pageInfo = new PageInfo<>(userOnlineInfoList, 5);
        return BeanUtil.convertPageInfo(pageInfo, UserOnlineInfoVO.class);
    }


}
