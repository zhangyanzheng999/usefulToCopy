package com.boss.bes.system.manage.pojo.query;


import com.boss.bes.system.manage.pojo.query.common.BasePageQuery;
import lombok.*;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class UserOnlineInfoPageQuery extends BasePageQuery {

    private String code;
    private Date onlineTime;
    private Date offlineTime;



}
