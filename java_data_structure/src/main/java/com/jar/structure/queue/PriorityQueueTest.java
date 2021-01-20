package com.jar.structure.queue;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Random;

/**
 * @author : dev
 * @version :
 * @Date :  1/20/21 2:27 PM
 * @Desc : 优先级队列
 */
public class PriorityQueueTest {
    public static void main(String[] args) {
        test();
    }

    private static void test() {
        PriorityQueue priorityQueue = new PriorityQueue<People>(11, new Comparator<People>() {
            @Override
            public int compare(People o1, People o2) {
                return o1.getAge() - o2.getAge();
            }
        });

        for (int i = 0; i < 10; i++) {
            People people = new People("李世佳 ： " + i, (new Random().nextInt(100)));
            System.out.println("add:" + people);
            priorityQueue.add(people);
        }

        System.out.println("\n----------------------------------------------------\n");
        while (!priorityQueue.isEmpty()) {
            System.out.println(priorityQueue.poll().toString());
        }
    }


}
