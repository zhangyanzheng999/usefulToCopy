package com.bosssoft.hr.train.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @description:
 * @author:zyz
 * @time:2020/6/16-14:45
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class HouseInfo {
    private Long id;
    private String city;
    private String region;
    private String name;
}
