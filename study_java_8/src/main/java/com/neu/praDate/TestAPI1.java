package com.neu.praDate;

import org.junit.Test;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @description:
 * @author:zyz
 * @time:2021/6/21-21:52
 */
public class TestAPI1 {
    @Test
    public void test01() {
        Instant instant = Instant.now();
        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println(localDateTime.format(DateTimeFormatter.ISO_LOCAL_DATE_TIME));

    }
}
