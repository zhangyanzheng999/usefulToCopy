package com.neu.praForkJoin;

import org.junit.Test;

import java.time.Duration;
import java.time.Instant;
import java.util.OptionalLong;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.stream.LongStream;

/**
 * @description:
 * @author:zyz
 * @time:2021/6/20-22:29
 */
public class TestForkJoin {
    @Test
    public void test01() {
        Instant start = Instant.now();
        ForkJoinPool pool = new ForkJoinPool();
        ForkJoinTask<Long> task = new ForkJoinCalculate(0, 10000000000L);
        Long sum = pool.invoke(task);
        System.out.println(sum);

        Instant end = Instant.now();
        System.out.println("耗费时间为:" + Duration.between(start, end).toMillis());

    }

    @Test
    public void test02() {
        Instant start = Instant.now();
        long sum = 0L;
        for (long i = 0; i <= 10000000000L; i++) {
            sum += i;
        }
        System.out.println(sum);

        Instant end = Instant.now();
        System.out.println("耗费时间为:" + Duration.between(start, end).toMillis());
    }

    /**
     * java8并行流
     */
    @Test
    public void test03() {
        Instant start = Instant.now();
        OptionalLong sum = LongStream.rangeClosed(0, 10000000000L)
                .parallel()
                .reduce(Long::sum);
        System.out.println(sum);

        Instant end = Instant.now();
        System.out.println("耗费时间为:" + Duration.between(start, end).toMillis());
    }
}
