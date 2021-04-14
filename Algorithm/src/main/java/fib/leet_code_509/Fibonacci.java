package fib.leet_code_509;

import java.util.concurrent.RecursiveTask;

/**
 * For a classic example, here is a task computing Fibonacci numbers:
 */
public class Fibonacci extends RecursiveTask<Integer> {
    final int n;

    public Fibonacci(int n) {
        this.n = n;
    }

    @Override
    protected Integer compute() {
        if (n <= 1) {
            return n;
        }
        Fibonacci f1 = new Fibonacci(n - 1);
        f1.fork();
        Fibonacci f2 = new Fibonacci(n - 2);
        return f2.compute() + f1.join();
    }

    public static void main(String[] args) {
        Fibonacci fibonacci= new Fibonacci(10);
        Integer compute = fibonacci.compute();
        System.out.println("result :"+compute);


    }
}
