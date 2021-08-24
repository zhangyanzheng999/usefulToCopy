package com.neu.praDate;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @description:
 * @author:zyz
 * @time:2021/6/21-22:22
 */
public class DateFormatThreadLocal {
    private static final ThreadLocal<DateFormat> df = new ThreadLocal<DateFormat>() {
        @Override
        protected DateFormat initialValue() {
            return new SimpleDateFormat("yyyyMMdd");
        }
    };

    public static Date convert(String source) {
        try {
            return df.get().parse(source);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }
}
