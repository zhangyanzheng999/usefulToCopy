package com.neu.praForkJoin;

import org.junit.Test;

import java.util.concurrent.RecursiveAction;
import java.util.concurrent.RecursiveTask;
import java.util.stream.Collectors;
import java.util.stream.LongStream;
import java.util.stream.Stream;

/**
 * @description:
 * @author:zyz
 * @time:2021/6/20-21:34
 */
public class ForkJoinCalculate extends RecursiveTask<Long> {


    private static final long serialVersionUID = 3399295015609716445L;
    private long start;
    private long end;

    private static final long THRESHOLD = 10000;

    public ForkJoinCalculate() {
    }

    public ForkJoinCalculate(long start, long end) {
        this.start = start;
        this.end = end;
    }

    @Override
    protected Long compute() {
        long length = end - start;
        if (length < THRESHOLD) {
//            long sum = Stream.iterate(start, x -> x + 1)
//                    .limit(length)
//                    .reduce(Long::sum)
//                    .get();
            long sum = 0;
            for (long i = start; i <= end; i++) {
                sum += i;
            }
            return sum;
        } else {
            long middle = (start + end) / 2;
            ForkJoinCalculate left = new ForkJoinCalculate(start, middle);
            left.fork(); //拆分子任务，同时压入线程队列

            ForkJoinCalculate right = new ForkJoinCalculate(middle + 1, end);
            right.fork();

            return left.join() + right.join();
        }
    }


}
