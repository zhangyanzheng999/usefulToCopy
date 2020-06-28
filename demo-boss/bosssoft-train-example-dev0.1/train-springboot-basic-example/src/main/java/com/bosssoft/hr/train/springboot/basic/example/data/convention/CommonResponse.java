package com.bosssoft.hr.train.springboot.basic.example.data.convention;

import com.bosssoft.hr.train.springboot.basic.example.pojo.vo.BaseVO;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @param
 * @author: Administrator
 * @create: 2020-06-19 00:30
 * @since
 **/
@Data
@AllArgsConstructor
public class CommonResponse<T> {
    private String code;
    private String message;
    private T body;
}
