package boss.xtrain.core.annotation.stuffer;

import boss.brs.xtrain.dataconvention.pojo.dto.BaseDTO;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.lang.reflect.Field;
import java.util.Map;

@Aspect
@Component
public class DefaultEntityFieldStuffer {
    private Logger log = LoggerFactory.getLogger(DefaultEntityFieldStuffer.class);
    private static final String ORG_ID = "org_id";
    private static final String COMPANY_ID = "company_id";
    private static final String CREATED_BY = "created_by";
    private static final String CREATED_TIME = "created_time";
    private static final String UPDATED_BY = "updated_by";
    private static final String UPDATED_TIME = "updated_time";
    private static final String VERSION = "version";
    @Autowired
    RedisTemplate<String, Object> redisTemplate;


    @Pointcut("@annotation(boss.xtrain.core.annotation.stuffer.EntityFieldStuffer)")
    public void fillPointCut() {
        //切入点表达式
    }


    @Around("fillPointCut()")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        //获得需要装配的DTO参数
        Object filledObject = null;
        for (Object arg : joinPoint.getArgs()) {
            if (arg instanceof BaseDTO) {
                filledObject = arg;
                break;
            }
        }
        //如果没有对应的字段，直接返回
        if (filledObject == null) {
            return joinPoint.proceed();
        }

        //拿到方法上的注解的值，用来做查找redis的key
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        EntityFieldStuffer entityFieldStuffer = signature.getMethod().getAnnotation(EntityFieldStuffer.class);
        String key = entityFieldStuffer.key();
        //拿到要填充对象的所有字段信息
        Field[] fields = filledObject.getClass().getDeclaredFields();
        //查找缓存
        Map<String, Object> publicField = (Map) this.redisTemplate.opsForValue().get(key);
        //遍历出对应的属性
        for (int i = 0; i < fields.length; ++i) {
            Field field = fields[i];
            field.setAccessible(true);
            String fieldName = field.getName();
            //进行判断，对符合要求的字段赋值
            if (ORG_ID.equals(fieldName) ||
                    COMPANY_ID.equals(fieldName) ||
                    CREATED_BY.equals(fieldName) ||
                    CREATED_TIME.equals(fieldName) ||
                    UPDATED_BY.equals(fieldName) ||
                    UPDATED_TIME.equals(fieldName) ||
                    VERSION.equals(fieldName)) {
                field.set(filledObject, publicField.get(fieldName));
            }
        }

        return joinPoint.proceed();
    }


}
