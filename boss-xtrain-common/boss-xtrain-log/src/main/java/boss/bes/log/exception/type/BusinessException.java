package boss.bes.log.exception.type;

import boss.bes.log.exception.code.IExceptionCode;

/**
 * @description:BussinessException 属于基本业务操作异常，所有业务操作异常都继承于该类。
 * 例如，通常 UI 层或 Web 层是由系统最终用户执行业务操作驱动，因此最好抛出业务类异常。
 * @author:zyz
 * @time:2020/6/30-20:28
 */
public class BusinessException extends AppException{

    public BusinessException() {
    }

    public BusinessException(String code, String message, Throwable throwable) {
        super(code, message, throwable);
    }

    public BusinessException(IExceptionCode exceptionCode, Throwable throwable) {
        super(exceptionCode, throwable);
    }

    public BusinessException(IExceptionCode exceptionCode) {
        super(exceptionCode);
    }
}
