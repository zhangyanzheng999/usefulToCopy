package com.boss.bes.system.manage.pojo.dto.common;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @description:
 * @author:zyz
 * @time:2020/7/4-21:03
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BaseDeleteDTO {
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long id;
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long version;
}
