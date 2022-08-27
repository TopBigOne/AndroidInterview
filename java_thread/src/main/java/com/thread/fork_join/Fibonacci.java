package com.thread.fork_join;

import java.util.concurrent.RecursiveTask;

/**
 * @author : dev
 * @version :
 * @Date :  2022/6/29 10:13
 * @Desc :
 */


public class Fibonacci extends RecursiveTask<Integer> {
    final int n;
    Fibonacci(int n) {
        this.n = n;

    }

    @Override
    public Integer compute() {
        if (n <= 1) {
            return n;
        }
        Fibonacci f1 = new Fibonacci(n - 1);
        f1.fork();
        Fibonacci f2 = new Fibonacci(n - 2);
        return f2.compute() + f1.join();
    }


    public static void main(String[] args) {
        Fibonacci fibonacci = new Fibonacci(64);
        int  compute = fibonacci.compute();
        System.err.println(compute);

    }
}
