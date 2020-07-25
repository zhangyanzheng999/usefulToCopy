package com.boss.base.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 手机号，邮箱号验证工具类
 * @author : 尚鹏辉
 * @date : 2020/7/1
 * @version : 1.0.0
 */
public class StringUtil {

    /**
     * 用于手机号码验证
     * @param mobile
     * @return
     */
    public static boolean checkMobileIsOk(String mobile) {
        String regex = "^((13[0-9])|(14[5|7])|(15([0-3]|[5-9]))|(17[013678])|(18[0,5-9]))\\d{8}$";
        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(mobile);
        boolean isMatch = m.matches();
        return isMatch;
    }

    /**
     * 用于邮箱号码验证
     * @param email
     * @return
     */
    public static boolean checkEmailIsOk(String email) {
        boolean isMatch = true;
        if (!email.matches("[\\w\\.\\-]+@([\\w\\-]+\\.)+[\\w\\-]+")) {
            isMatch = false;
        }
        return isMatch;
    }
}
