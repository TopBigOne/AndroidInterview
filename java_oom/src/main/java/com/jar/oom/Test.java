package com.jar.oom;


import com.jar.oom.utils.LogUtils;

/**
 * java 的 oom 主要发生以下区域：
 * 1: heap oom;
 * 2: methord area /Metaspace;
 * 3: stack over flow error;
 * 4: direct memory;
 */
public class Test {
    public static void main(String[] args)  throws IllegalAccessException{

        // testHeapOOM();
       // testMetaspaceOOM();
      // testStackOverFlow();
        testDirectMemoryOOM();
    }

    private static void testDirectMemoryOOM() throws IllegalAccessException {
        DirectMemoryOOM memoryOOM = new DirectMemoryOOM();
        memoryOOM.execute();
    }

    private static void testStackOverFlow() {
        StackOverflowError stackOverflowError = new StackOverflowError();
        try {
            stackOverflowError.execute();
        } catch (Exception e) {
            LogUtils.i("stack length :"+StackOverflowError.stackLenght);
            e.printStackTrace();
        }
    }

    private static void testMetaspaceOOM() {
        MethordAreaOOM methordAreaOOM = new MethordAreaOOM();

        methordAreaOOM.execute();
    }

    private static void testHeapOOM() {
        Heap heap = new Heap();
        heap.execute();
    }

}