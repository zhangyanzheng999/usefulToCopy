package com.neu.praDate;

import org.junit.Test;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.Temporal;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalAdjusters;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/**
 * @description: LocalDate LocalTime LocalDateTime
 * @author:zyz
 * @time:2021/6/21-22:37
 */
public class TestLocalDateTime {


    @Test
    public void test01() {
        LocalDateTime ldt = LocalDateTime.now();
        System.out.println(ldt);

        LocalDateTime ldt2 = LocalDateTime.of(2021, 6, 21, 22, 43, 50);
        System.out.println(ldt2);

        LocalDateTime ldt3 = ldt.plusYears(1);
        System.out.println(ldt3);
        LocalDateTime ldt4 = ldt.minusYears(1);
        System.out.println(ldt4);
    }

    // Instant:时间戳(以Unix元年：1970年1月1日00:00:00到某个事件之前的毫秒值)
    // 默认是UTC时区，比北京时间少了8小时
    @Test
    public void test02() {
        Instant instant1 = Instant.now();
        System.out.println(instant1);
        System.out.println(instant1.toEpochMilli());
        System.out.println(Instant.ofEpochSecond(1000L));
        OffsetDateTime dateTime = instant1.atOffset(ZoneOffset.ofHours(8));
        System.out.println(dateTime);
    }


    //3.Duration:计算时间间隔
    // Period:计算日期间隔
    @Test
    public void test03() {
        Instant start = Instant.now();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Instant end = Instant.now();
        Duration duration = Duration.between(start, end);
        System.out.println(duration.toMillis());
    }

    @Test
    public void test04() {
        LocalTime t1 = LocalTime.now();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        LocalTime t2 = LocalTime.now();
        Duration duration = Duration.between(t1, t2);
        System.out.println(duration.toMillis());
    }

    @Test
    public void test05() {
        LocalDate start = LocalDate.of(2015, 1, 1);
        LocalDate end = LocalDate.now();
        System.out.println(Period.between(start, end).toTotalMonths());
        System.out.println(Period.between(start, end).getDays());
    }


    //TemporalAdjuster：时间校正器
    @Test
    public void test06() {
        LocalDateTime ldt = LocalDateTime.now();
        System.out.println(ldt);

        LocalDateTime ldt2 = ldt.withDayOfMonth(10);
        System.out.println(ldt2);


        LocalDateTime ldt3 = ldt.with(TemporalAdjusters.next(DayOfWeek.SUNDAY));
        System.out.println(ldt3);


        //自定义:下一个工作日
        LocalDateTime ldt5 = ldt.with(temporal -> {
            System.out.println("temporal:"+temporal);
            LocalDateTime ldt4 = LocalDateTime.from(temporal);
            DayOfWeek now = ldt4.getDayOfWeek();
            switch (now) {
                case FRIDAY:
                    return ldt4.plusDays(3);
                case SATURDAY:
                    return ldt4.plusDays(2);
                default:
                    return ldt4.plusDays(1);
            }
        });
        System.out.println(ldt5);
    }

    // DateTimeFormatter:格式化时间/日期
    @Test
    public void test07(){
        DateTimeFormatter dtf = DateTimeFormatter.ISO_DATE;
        LocalDateTime ldt = LocalDateTime.now();
        System.out.println(ldt.format(dtf));


        DateTimeFormatter dtf2 = DateTimeFormatter.ofPattern("yyyy年MM月dd日 HH:mm:ss");
        System.out.println(ldt.format(dtf2));
        String strDate2 = dtf2.format(ldt);
        System.out.println(strDate2);

        System.out.println(ldt.parse(strDate2, dtf2));
    }

    //ZoneTime ZoneDate ZoneDateTime
    @Test
    public void test08(){
        LocalDateTime ldt = LocalDateTime.now(ZoneId.of("Europe/Tallinn"));
        System.out.println(ldt);

        LocalDateTime ldt2 = LocalDateTime.now();
        ZonedDateTime zonedDateTime = ldt2.atZone(ZoneId.of("Europe/Tallinn"));
        System.out.println(zonedDateTime);
    }
}
