package com.thread.fork_join;

import java.util.concurrent.RecursiveTask;

/**
 * 当我们需要执行大量的小任务时，有经验的Java开发人员都会采用线程池来高效执行这些小任务。
 * 然而，有一种任务，例如，对超过1000万个元素的数组进行排序，这种任务本身可以并发执行，
 * 但如何拆解成小任务需要在任务执行的过程中动态拆分。这样，大任务可以拆成小任务，小任务还可以继续拆成更小的任务，
 * 最后把任务的结果汇总合并，得到最终结果，这种模型就是Fork/Join模型。
 * <p>
 * Java7引入了Fork/Join框架，我们通过RecursiveTask这个类就可以方便地实现Fork/Join模式。
 * <p>
 * 例如，对一个大数组进行并行求和的RecursiveTask，就可以这样编写：
 */
public class SumTask extends RecursiveTask<Long> {

    static final int THRESHOLD = 100;
    Long[] array;
    int start, end;

    public SumTask(Long[] array, int start, int end) {
        this.array = array;
        this.start = start;
        this.end = end;
    }


    @Override
    protected Long compute() {
        if (end - start <= THRESHOLD) {
            // 如果任务足够小，直接计算
            long sum = 0;
            for (int i = start; i < end; i++) {
                sum += array[i];
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(String.format("computer %d ~ %d = %d ", start, end, sum));
            return sum;
        }
        // 任务太大，一分为二；
        int middle = (end + start) >> 1;
        System.out.println(String.format("split %d ~ %d====> %d~%d ,%d~%d", start, end, start, middle, middle, end));

        SumTask sumTask1 = new SumTask(this.array, start, middle);
        SumTask sumTask2 = new SumTask(this.array, middle, end);
        invokeAll(sumTask1, sumTask2);
        long subResult1 = sumTask1.join();
        long subResult2 = sumTask2.join();
        long result = subResult1 + subResult2;
        System.out.println("result = " + subResult1 + " + " + subResult2 + " ====> " + result);

        return result;
    }
}
