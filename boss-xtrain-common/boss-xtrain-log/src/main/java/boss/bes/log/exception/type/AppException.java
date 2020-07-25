package boss.bes.log.exception.type;

import boss.bes.log.exception.code.IExceptionCode;

/**
 * @description:自定义异常
 * @author:zyz
 * @time:2020/6/30-20:22
 */
public class AppException extends RuntimeException {

    private final String code;

    public AppException() {
        code = null;
    }

    public AppException(String code, String message, Throwable throwable) {
        super(message, throwable);
        this.code = code;
    }

    /**
     * 通过异常码来获取异常,但是需要传递系统异常
     *
     * @param exceptionCode
     * @param throwable
     */
    public AppException(IExceptionCode exceptionCode, Throwable throwable) {
        super(exceptionCode.getMessage(), throwable);
        this.code = exceptionCode.getCode();
    }

    /**
     * 通过异常码来获取异常,适用于业务校验不合格
     *
     * @param exceptionCode
     */
    public AppException(IExceptionCode exceptionCode) {
        super(exceptionCode.getMessage());
        this.code = exceptionCode.getCode();
    }

    public String getCode() {
        return code;
    }
}
