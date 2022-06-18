package com.thread.fork_join;

import java.util.HashSet;
import java.util.Set;

public class TestSumTask {
    private static final String TAG = "TestSumTask: ";

    public static void main(String[] args) {
        Long[] original;

        if ((original = generateLongArray()) != null) {
            int start = 0;
            int end = 100_0000;

            SumTask sumTask = new SumTask(original, start, end - 1);
            long result = sumTask.compute();
            System.out.println(TAG + " result : " + result);
        }
    }


    private static Long[] generateLongArray() {
        Set<Long> hashSet = new HashSet<>();
        for (int i = 0; ; i++) {
            hashSet.add(1 + (long) (Math.random() * 10000000));
            if (hashSet.size() == 100_0000) {
                break;
            }

        }
        return hashSet.toArray(new Long[100_0000]);
    }
}
