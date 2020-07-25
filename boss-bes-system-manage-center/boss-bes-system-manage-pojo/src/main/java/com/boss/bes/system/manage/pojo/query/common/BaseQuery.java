package com.boss.bes.system.manage.pojo.query.common;


import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


/**
 * @description:
 * @author:zyz
 * @time:2020/7/3-22:07
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class BaseQuery {
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long id;
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long version;
}
