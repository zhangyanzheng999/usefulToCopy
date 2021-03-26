package com.atguigu.amqp.bean;

import lombok.Data;

/**
 * @description:
 * @author:zyz
 * @time:2021/3/24-15:39
 */
@Data
public class Book {
    private String bookName;
    private String author;

    public Book() {

    }

    public Book(String bookName, String author) {
        this.bookName = bookName;
        this.author = author;
    }
}
