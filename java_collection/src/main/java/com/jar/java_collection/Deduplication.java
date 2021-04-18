package com.jar.java_collection;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;


/**
 * 集合去重
 */
public class Deduplication {
    public static void main(String[] args) {
        System.out.println("--------------------------");
        Deduplication deduplication = new Deduplication();
        deduplication.fun1();
        deduplication.fun2();


    }

    private void fun2() {
        int[] list ={1, 1, 2, 3, 3, 3, 4, 5, 6, 6, 6, 7, 8};
        System.out.println("原始数据: "+ Arrays.toString(list));
        List<Integer> rawList = Arrays.stream(list).boxed().collect(toList());

        List<Integer> collect = rawList.stream().distinct().collect(toList());

        System.out.println("去重以后的数据 : "+collect);
        System.out.println("--------------------------");





    }

    private void fun1(){
        int[] list ={1, 1, 2, 3, 3, 3, 4, 5, 6, 6, 6, 7, 8};
        System.out.println("原始数据: "+ Arrays.toString(list));
        LinkedHashSet<Integer> hashSet = new LinkedHashSet<>();
        for (int i : list) {
            hashSet.add(i);
        }

        System.out.println("去重以后的数据 : "+hashSet);

        System.out.println("--------------------------");



    }
}