package com.top.jar.chapter_001.t_05;

import java.util.Arrays;
import java.util.Stack;
import java.util.function.Consumer;

/**
 * @author : Jakarta
 * @version :
 * @Date : 2020-06-20 23:49
 * @Desc : 用一个栈实现另一个栈的排序;
 */
public class SortStack {
    public static void main(String[] args) {
        Stack<Integer> rawData = new Stack<>();
        rawData.push(8);
        rawData.push(3);
        rawData.push(6);
        rawData.push(4);
        rawData.push(2);
        rawData.push(5);
        rawData.push(7);

        printStack("raw   data: ", rawData);
        Stack<Integer> resultStack = sortStack(rawData);
        printStack("after sort: ", resultStack);

    }

    private static Stack<Integer> sortStack(Stack<Integer> rawData) {
        Stack<Integer> help = new Stack<>();
        while (!rawData.isEmpty()) {
            int temp = rawData.pop();
            while (!help.isEmpty() && help.peek() < temp) {
                rawData.push(help.pop());
            }
            help.push(temp);
        }
       /* while (!help.isEmpty()) {
            rawData.push(help.pop());
        }*/
        System.out.println("help size: " + help.size());
        return help;

    }

    private static void printStack(String tips, Stack<Integer> rawData) {
        System.out.println(tips);

        rawData.forEach(new Consumer<Integer>() {
            @Override
            public void accept(Integer integer) {
                System.out.println(integer);
            }
        });


    }


}
