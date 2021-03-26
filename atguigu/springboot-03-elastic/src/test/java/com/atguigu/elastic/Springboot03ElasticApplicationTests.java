package com.atguigu.elastic;

import com.atguigu.elastic.bean.Article;
import com.atguigu.elastic.bean.Book;
import com.atguigu.elastic.repository.BookRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class Springboot03ElasticApplicationTests {
    @Autowired
    BookRepository bookRepository;

    @Test
    void contextLoads() {
        /*Book book = new Book(2, "西游记", "吴承恩");
        bookRepository.save(book);*/
        // 这里模糊只支持最左前缀 例如:西 西游 西游记
        List<Book> books = bookRepository.findByBookNameLike("西");
        System.out.println(books);
    }

}
