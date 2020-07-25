package boss.bes.log.exception.code.enums;

import boss.bes.log.exception.code.IExceptionCode;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * @description:用来描述系统管理模块的异常码
 * @author:zyz
 * @time:2020/7/5-17:44
 */
@AllArgsConstructor
@NoArgsConstructor
@Getter
public enum SystemManageCodeEnum implements IExceptionCode {

    SYSTEM_MANAGE_DATA_USED("250101", "系统数据已经被使用,删除失败"),
    SYSTEM_MANAGE_DATA_IMPORT_EXCEPTION("250201", "系统数据导入异常"),
    SYSTEM_MANAGE_DATA_MULTI_DELETE_EXCEPTION("250202", "批量删除失败"),
    SYSTEM_MANAGE_USER_ROLE_UPDATE_EXCEPTION("250301", "用户角色信息更新失败"),
    SYSTEM_MANAGE_USER_CODE_GENERATOR_EXCEPTION("250302", "用户工号生成失败"),
    SYSTEM_MANAGE_ROLE_RESOURCE_UPDATE_EXCEPTION("250401", "角色资源信息更新失败"),
    SYSTEM_MANAGE_ROLE_CODE_GENERATOR_EXCEPTION("250402", "用户工号生成失败"),
    SYSTEM_MANAGE_COMPANY_ROLE_UPDATE_EXCEPTION("250501", "公司角色信息更新失败");


    private String code;
    private String message;
}
