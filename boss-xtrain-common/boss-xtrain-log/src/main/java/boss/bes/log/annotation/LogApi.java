package boss.bes.log.annotation;

import java.lang.annotation.*;

/**
 * 标注注解到类上、或者方法上就可以生成日志
 */
@Target({ElementType.METHOD,ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface LogApi {
}
