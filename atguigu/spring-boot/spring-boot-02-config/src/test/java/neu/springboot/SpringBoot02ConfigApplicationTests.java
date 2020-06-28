package neu.springboot;
/**
 * Spring Boot 单元测试
 *
 * 可以在测试期间很方便地类似编码一样的自动注入
 */

import neu.springboot.bean.Person;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

@SpringBootTest
class SpringBoot02ConfigApplicationTests {

    @Autowired
    Person person;

    @Autowired
    ApplicationContext aoc;

    @Test
    public void testHelloService(){
        boolean b = aoc.containsBean("helloService");
        System.out.println(b);
    }


    @Test
    void contextLoads() {
        System.out.println(person);
    }

}
