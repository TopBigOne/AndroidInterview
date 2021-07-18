package com.android.synchronize;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : dev
 * @version :
 * @Date :  7/18/21 3:32 PM
 * @Desc :
 */
public class Demo_2 {
    // 竞争变量
    private static final List<Integer> temp = new ArrayList<>();
    public static int COUNT = 0;

    public static List<Integer> getTemp() {
        return temp;
    }

    /**
     * 静态方法
     */
    public static void testStaticMethod() {
        synchronized (Demo_2.class) {
            for (int i = 0; i < 5; i++) {
                COUNT++;
                try {
                    temp.add(COUNT);
                    System.out.println(Thread.currentThread().getName()+" : 静态函数在被调用...COUNT : " + COUNT);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * 非静态方法
     */
    public void testNonStaticMethod() {
        synchronized (this) {
            for (int i = 0; i < 5; i++) {
                COUNT++;
                try {
                    temp.add(COUNT);
                    System.out.println(Thread.currentThread().getName()+" : 非静态函数在被调用...COUNT : " + COUNT);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * 测试非静态方法
     */
    static class TaskOne implements Runnable {
        private Demo_2 demo_2;

        public TaskOne(Demo_2 demo_2) {
            this.demo_2 = demo_2;
        }

        @Override
        public void run() {
            demo_2.testNonStaticMethod();
        }
    }

    /**
     * 测试静态方法
     */
    static class TaskTwo implements Runnable {
        @Override
        public void run() {
            Demo_2.testStaticMethod();
        }
    }

    public static void main(String[] args) {
        Demo_2 demo_2 = new Demo_2();
        TaskOne taskOne = new TaskOne(demo_2);
        TaskTwo taskTwo = new TaskTwo();
        Thread one = new Thread(taskOne,"taskOne");
        Thread two = new Thread(taskTwo,"taskTwo");

        // 启动线程
        two.start();
        one.start();

        Thread.State threadOneStatus = one.getState();
        Thread.State threadTwoStatus = two.getState();

        // 忙等，直到  Thread  one 和  Thread two 全部 运行结束，然后打印结果
        while (threadOneStatus != Thread.State.TERMINATED || threadTwoStatus != Thread.State.TERMINATED) {
            // 再次获取 ，为了print线程状态
            threadOneStatus = one.getState();
            threadTwoStatus = two.getState();
            System.out.println("taskOne 状态 : " + threadOneStatus.name());
            System.out.println("taskTwo 状态 : " + threadTwoStatus.name());
        }

        List<Integer> result = Demo_2.getTemp();
        System.out.println("result : " + result);
    }

}
