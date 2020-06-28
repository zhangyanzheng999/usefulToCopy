package com.bosssoft.hr.train.entity;

import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

/**
 * @description:
 * @author:zyz
 * @time:2020/6/13-10:58
 */
@Data
@ToString
public class MessageObject  implements Serializable {

    private static final long serialVersionUID = 5943153777061419755L;
    private Long id;
    private String content;

}
