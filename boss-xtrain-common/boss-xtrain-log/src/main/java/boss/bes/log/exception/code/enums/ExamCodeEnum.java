package boss.bes.log.exception.code.enums;

import boss.bes.log.exception.code.IExceptionCode;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * @description:考试系统的异常码
 * @author:zyz
 * @time:2020/7/15-14:39
 */
@AllArgsConstructor
@NoArgsConstructor
@Getter
public enum ExamCodeEnum implements IExceptionCode {

    EXAM_PUBLISH_INSERT_EXCEPTION("240101","考试发布记录新增异常"),
    EXAM_PUBLISH_DELETE_EXCEPTION("240102","考试发布记录删除异常"),
    EXAM_PUBLISH_UPDATE_EXCEPTION("240103","考试发布记录更新异常"),
    EXAM_PUBLISH_QUERY_EXCEPTION("240104","考试发布记录查询异常"),

    EXAM_PHONE_LOGIN_EXCEPTION("240201","手机端登录异常"),
    EXAM_PHONE_REGISTER_EXCEPTION("240202","手机端注册异常"),
    EXAM_RECORD_INSERT_EXCEPTION("240203","考试记录新增异常"),
    EXAM_RECORD_QUERY_EXCEPTION("240204","考试记录查询异常"),
    EXAM_RECORD_UPDATE_EXCEPTION("240205","考试记录更新异常"),
    EXAM_ANSWER_INSERT_EXCEPTION("240206","考生答案新增异常"),
    EXAM_ANSWER_QUERY_EXCEPTION("240207","考生答案查询异常"),
    EXAM_ANSWER_UPDATE_EXCEPTION("240208","考生答案更新异常"),
    EXAM_MARK_QUERY_EXCEPTION("240301","查询考试记录等信息出现异常"),
    EXAM_MARK_UPDATE_EXCEPTION("240302","批改结果更新异常"),
    EXAM_REPORT_PUBLISH_QUERY_EXCEPTION("240401","报表所需考试发布记录信息查询失败"),
    EXAM_REPORT_RESULT_QUERY_EXCEPTION("240402","考生考试结果信息查询失败")
            ;



    private String code;
    private String message;
}
