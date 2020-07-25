package com.boss.bes.system.manage.pojo.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
* Created by Mybatis Generator on 2020/07/04
*/
@Table(name = "`tb_user_online_info`")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserOnlineInfo {
    @Id
    @Column(name = "`id`")
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long id;

    @Column(name = "`code`")
    private String code;

    /**
     * 用户姓名
     */
    @Column(name = "`name`")
    private String name;

    @Column(name = "`ip`")
    private String ip;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @Column(name = "`online_time`")
    private Date onlineTime;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @Column(name = "`offline_time`")
    private Date offlineTime;

    @Column(name = "`stop_time`")
    private Integer stopTime;

    @Column(name = "`status`")
    private Byte status;
}