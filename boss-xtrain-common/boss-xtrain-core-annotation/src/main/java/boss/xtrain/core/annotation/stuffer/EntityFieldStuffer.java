package boss.xtrain.core.annotation.stuffer;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface EntityFieldStuffer {
    /**
     * 设置保存公共字段的key
     * */
    String key() default "commonFields";
}
