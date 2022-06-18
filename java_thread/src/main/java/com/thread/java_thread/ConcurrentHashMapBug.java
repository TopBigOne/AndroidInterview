package com.thread.java_thread;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.BiFunction;
import java.util.function.Function;

/**
 * @author : Jakarta
 * @version :
 * @Date : 2020-06-15 14:05
 * @Desc :
 */
public class ConcurrentHashMapBug {
    public static void main(String[] args) {
        System.out.println(" 方法开始....");
//        Map<String, Integer> map = new ConcurrentHashMap<>(16);
//        map.computeIfAbsent("AaAa",
//                s -> map.computeIfAbsent("BBBB",
//                        s1 -> 42));


        System.out.println("方法结束...");


        test2();
    }

    private static void test2() {
        List<String> list;
        Map<String, List> map = new HashMap<>(100);

        list = map.computeIfAbsent("list", new Function<String, List>() {
            @Override
            public List apply(String s) {
                if (s == null || "".equals(s)) {
                    System.out.println("key is null");
                }
                System.out.println("s:" + s);
                return new ArrayList();
            }
        });

        list.add("dsfdsa");

        for (String s : list) {
            System.out.println("s :" + s);
        }

        map.merge("list", new ArrayList(12), new BiFunction<List, List, List>() {
            @Override
            public List apply(List list, List list2) {
                for (Object o : list) {
                    System.out.println("o: " + o);
                }

                return null;
            }
        });

    }
}
