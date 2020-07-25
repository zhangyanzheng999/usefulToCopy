package com.boss.bes.system.manage.pojo.vo;


import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @description:
 * @author:zyz
 * @time:2020/7/3-21:24
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserOnlineInfoVO{
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long id;


    private String code;

    /**
     * 用户姓名
     */
    private String name;


    private String ip;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date onlineTime;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date offlineTime;


    private Integer stopTime;

    private Byte status;
}
