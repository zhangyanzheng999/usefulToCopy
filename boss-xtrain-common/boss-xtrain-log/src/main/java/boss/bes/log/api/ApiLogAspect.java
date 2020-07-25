package boss.bes.log.api;

import boss.bes.log.exception.code.enums.BaseCodeEnum;
import boss.bes.log.exception.type.AppException;
import boss.brs.xtrain.dataconvention.convention.CommonResponse;
import boss.brs.xtrain.dataconvention.convention.head.ResponseHead;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;

/**
 * @description:日志切面处理
 * @author:zyz
 * @time:2020/6/30-18:19
 */
@Component
@Aspect
@Slf4j
public class ApiLogAspect {
    /**
     * 标注了注解的方法或者类都进行拦截
     */
    @Pointcut("@annotation(boss.bes.log.annotation.LogApi) || @within(boss.bes.log.annotation.LogApi)")
    public void pointCut() {
        //切入点
    }

    /**
     * 打印日志
     * 请求报文： Ip#业务发生时间#报文信息
     * 应答报文：业务发生时间#耗时s#报文信息
     *
     * @param joinPoint
     * @return
     */
    @Around("pointCut()")
    public Object saveApiLog(ProceedingJoinPoint joinPoint) {
        //开始的毫秒数
        long startTime = System.currentTimeMillis();
        //进行日期格式转换
        LocalDateTime ldt = LocalDateTime.now();
        String nowTime = ldt.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        //获取request进而获取ip
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        String ip = request.getRemoteAddr();
        //拿到方法名
        String methodName = joinPoint.getSignature().getDeclaringType() + "." + joinPoint.getSignature().getName();
        Object[] args = joinPoint.getArgs();
        log.info("业务发生时间:{},方法：{},请求ip:{},参数信息:{}", nowTime, methodName, ip, Arrays.asList(args));
        //执行结果
        Object result = null;
        CommonResponse<String> response = new CommonResponse<>();
        ResponseHead responseHead = new ResponseHead();
        try {
            result = joinPoint.proceed();
        } catch (AppException e) {
            responseHead.setCode(e.getCode());
            response.setBody(e.getMessage());
            response.setHead(responseHead);
            log.error("方法发生异常，异常码:{},异常信息:{}", e.getCode(), e.getMessage());
            return response;
        } catch (Throwable throwable) {
            responseHead.setCode("-1");
            response.setHead(responseHead);
            String message = throwable.getMessage() == null ? throwable.toString() : throwable.getMessage();
            response.setBody(message);
            log.error("方法发生异常，异常信息:{}", message);
            return response;
        }
        //响应时间
        long respTime = System.currentTimeMillis() - startTime;
        log.info("业务发生时间:{},耗时:{},结果:{}", nowTime, respTime, result);
        return result;
    }

    /**
     * 在这里统一抛出异常，然后交给GlobalExceptionResolver抛出
     *
     * @param joinPoint
     * @param e
     */
/*    @AfterThrowing(pointcut = "pointCut()", throwing = "e")
    public void throwing(JoinPoint joinPoint, Exception e) {
        if (e instanceof AppException) {
            throw (AppException) e;
        } else {
            throw new AppException(BaseCodeEnum.UNDEFINED);
        }
    }*/

}
