package boss.bes.log.exception.hander;

import boss.bes.log.exception.type.AppException;
import boss.bes.log.util.BuildResponse;
import boss.brs.xtrain.dataconvention.convention.CommonResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @description:用来全局异常处理
 * @author:zyz
 * @time:2020/6/30-21:02
 */
@RestControllerAdvice
@Slf4j
public class GlobalExceptionResolver {

    @ExceptionHandler({AppException.class})
    public CommonResponse<String> exceptionHandler(AppException e) {
        log.error("方法发生异常，异常码:{},异常信息:{}", e.getCode(), e.getMessage());
        return BuildResponse.build(e.getCode(), e.getMessage());
    }


    @ExceptionHandler(Exception.class)
    public CommonResponse<String> systemExceptionHandler(Exception e) {
        String message = e.getMessage() == null ? e.toString() : e.getMessage();
        log.error("方法发生异常，异常信息:{}", message);
        return BuildResponse.build("-1", message);
    }


}
