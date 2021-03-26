package com.atguigu.elastic.repository;


import com.atguigu.elastic.bean.Book;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import java.util.List;

/**
 * @description:
 * @author:zyz
 * @time:2021/3/25-17:01
 */
public interface BookRepository extends ElasticsearchRepository<Book, Integer> {
    List<Book>  findByBookNameLike(String bookName);
}
