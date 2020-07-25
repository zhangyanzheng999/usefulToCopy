package boss.bes.log.exception.type;

import boss.bes.log.exception.code.IExceptionCode;

/**
 * @description:中间服务层异常，该层操作引起的异常一般包装成基本 ServiceException
 * @author:zyz
 * @time:2020/6/30-21:01
 */
public class ServiceException extends AppException {
    public ServiceException() {
    }

    public ServiceException(String code, String message, Throwable throwable) {
        super(code, message, throwable);
    }

    public ServiceException(IExceptionCode exceptionCode, Throwable throwable) {
        super(exceptionCode, throwable);
    }

    public ServiceException(IExceptionCode exceptionCode) {
        super(exceptionCode);
    }
}
