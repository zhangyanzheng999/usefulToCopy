package boss.xtrain.core.annotation;

import com.boss.config.RedisInit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//自动导入redisTemplate
@RedisInit
public class AnnotionApplication {

    public static void main(String[] args) {
        SpringApplication.run(AnnotionApplication.class, args);
    }

}
