package com.boss.bes.system.manage.pojo.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @description:参数上传的DTO
 * @author:zyz
 * @time:2020/7/13-17:33
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class SystemParamImportDTO {
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long id;
    private String name;
    private String value;
    private String paramType;
    private Boolean status;
}
