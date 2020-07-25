package boss.bes.log.exception.type;

import boss.bes.log.exception.code.IExceptionCode;

/**
 * @description:数据访问相关的基本异常
 * @author:zyz
 * @time:2020/6/30-21:00
 */
public class DaoException extends AppException {
    public DaoException() {
    }

    public DaoException(String code, String message, Throwable throwable) {
        super(code, message, throwable);
    }

    public DaoException(IExceptionCode exceptionCode, Throwable throwable) {
        super(exceptionCode, throwable);
    }

    public DaoException(IExceptionCode exceptionCode) {
        super(exceptionCode);
    }
}
