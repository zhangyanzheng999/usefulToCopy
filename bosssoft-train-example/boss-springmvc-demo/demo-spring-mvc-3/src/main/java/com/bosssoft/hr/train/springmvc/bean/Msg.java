package com.bosssoft.hr.train.springmvc.bean;

/**
 * @description:返回给前端的信息
 * @author:zyz
 * @time:2020/6/6--13:09
 */
public class Msg {
    /**
     * 状态码
     */
    private Integer code;
    /**
     * 错误信息
     */
    private String news;

    public String getMsg() {
        return news;
    }

    public void setMsg(String news) {
        this.news = news;
    }

    public Msg code(Integer code) {
        this.code = code;
        return this;
    }


    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }


    public Msg msg(String news) {
        this.news = news;
        return this;
    }

}
