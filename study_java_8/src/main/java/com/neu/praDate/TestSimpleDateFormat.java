package com.neu.praDate;

import org.junit.Test;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.*;

/**
 * @description:
 * @author:zyz
 * @time:2021/6/21-21:58
 */
public class TestSimpleDateFormat {
    @Test
    public void test01() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd");
        //Callable<Date> task = () -> simpleDateFormat.parse("20161218");
        Callable<Date> task = () -> DateFormatThreadLocal.convert("20161218");
        ExecutorService pool = Executors.newFixedThreadPool(10);
        List<Future<Date>> results = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            results.add(pool.submit(task));
        }
        results.stream().forEach(result -> {
            try {
                System.out.println(result.get());
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        pool.shutdown();
    }

    @Test
    public void test02(){
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyyMMdd");
        Callable<LocalDate> task = () -> LocalDate.parse("20161218",dtf);
        ExecutorService pool = Executors.newFixedThreadPool(10);
        List<Future<LocalDate>> results = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            results.add(pool.submit(task));
        }
        results.stream().forEach(result -> {
            try {
                System.out.println(result.get());
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        pool.shutdown();
    }
}
