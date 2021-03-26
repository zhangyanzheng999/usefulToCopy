package com.atguigu.elastic.bean;

import lombok.Data;


/**
 * @description:
 * @author:zyz
 * @time:2021/3/25-16:36
 */
@Data
public class Article {

    private Integer id;
    private String author;
    private String title;
    private String content;

    public Article() {
    }

    public Article(Integer id, String author, String title, String content) {
        this.id = id;
        this.author = author;
        this.title = title;
        this.content = content;
    }
}
