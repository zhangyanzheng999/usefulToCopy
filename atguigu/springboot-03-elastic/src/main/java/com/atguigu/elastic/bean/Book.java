package com.atguigu.elastic.bean;

import lombok.Data;
import org.springframework.data.elasticsearch.annotations.Document;


/**
 * @description:
 * @author:zyz
 * @time:2021/3/25-17:06
 */
@Data
// ES7中移除了type
@Document(indexName = "book")
public class Book {

    private Integer id;

    private String bookName;

    private String author;

    public Book() {
    }

    public Book(Integer id, String bookName, String author) {
        this.id = id;
        this.bookName = bookName;
        this.author = author;
    }
}
