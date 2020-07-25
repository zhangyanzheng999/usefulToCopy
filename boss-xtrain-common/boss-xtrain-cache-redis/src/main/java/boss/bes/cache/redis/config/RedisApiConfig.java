package boss.bes.cache.redis.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @description:用来导入redis操作的组件，但是前提是需要导入RedisAutoConfiguration类 就是要导入redis依赖。
 * @author:zyz
 * @time:2020/6/30-23:03
 */

@ComponentScan(value = "boss.bes.cache.redis")
@Configuration
public class RedisApiConfig {


}
