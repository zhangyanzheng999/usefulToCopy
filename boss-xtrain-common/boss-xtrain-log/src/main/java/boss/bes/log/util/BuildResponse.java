package boss.bes.log.util;

import boss.bes.log.exception.code.IExceptionCode;
import boss.brs.xtrain.dataconvention.convention.CommonResponse;
import boss.brs.xtrain.dataconvention.convention.head.ResponseHead;

/**
 * @description:用来异常的构建Response
 * @author:zyz
 * @time:2020/7/7-14:58
 */
public final class BuildResponse {
    private BuildResponse() {

    }

    /**
     * 简便构造
     *
     * @param code
     * @param message
     * @param <T>
     * @return
     */
    public static <T> CommonResponse<T> build(String code, T message) {
        CommonResponse<T> commonResponse = new CommonResponse<>();
        ResponseHead responseHead = new ResponseHead();
        responseHead.setCode(code);
        commonResponse.setHead(responseHead);
        commonResponse.setBody(message);

        return commonResponse;
    }

    /**
     * 传入head和body
     *
     * @param head
     * @param body
     * @param <T>
     * @return
     */
    public static <T> CommonResponse<T> build(ResponseHead head, T body) {
        CommonResponse<T> commonResponse = new CommonResponse<>();
        commonResponse.setHead(head);
        commonResponse.setBody(body);
        return commonResponse;
    }

    /**
     * 传入枚举
     * @param exceptionCode
     * @return
     */
    public static  CommonResponse<String> build(IExceptionCode exceptionCode) {

        return build(exceptionCode.getCode(), exceptionCode.getMessage());
    }

}
