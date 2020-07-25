package boss.bes;

import com.boss.config.RedisInit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@RedisInit
public class BossXtrainCacheRedisApplication {

    public static void main(String[] args) {
        SpringApplication.run(BossXtrainCacheRedisApplication.class, args);
    }

}
