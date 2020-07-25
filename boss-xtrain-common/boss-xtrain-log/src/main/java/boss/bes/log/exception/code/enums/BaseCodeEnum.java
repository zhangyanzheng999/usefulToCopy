package boss.bes.log.exception.code.enums;

import boss.bes.log.exception.code.IExceptionCode;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * @description:这个类存放所有的系统异常码
 * @author:zyz
 * @time:2020/6/30-20:33
 */
@AllArgsConstructor
@NoArgsConstructor
@Getter
public enum BaseCodeEnum implements IExceptionCode {
    UNDEFINED_EXCEPTION("-1", "系统异常"),
    SYSTEM_SUCCESS("0", "处理成功"),
    SERVER_TIMEOUT("000001", "请求超时"),
    BASE_DATA_SQL_EXCEPTION("010101", "SQL语句错误"),
    BASE_DATA_DUPLICATE_EXCEPTION("010102", "数据重复"),
    BASE_DATA_INCOMPLETE_EXCEPTION("010103", "数据不完整"),
    BASE_DATA_SELECT_EXCEPTION("011001", "数据查找异常"),
    BASE_DATA_INSERT_EXCEPTION("011002", "数据插入异常"),
    BASE_DATA_DELETE_EXCEPTION("011003", "数据删除异常"),
    BASE_DATA_UPDATE_EXCEPTION("011004", "数据更新异常"),
    NOT_BASE_CLASS_EXCEPTION("011101","不是基类数据无法通用处理");


    private String code;
    private String message;


}
