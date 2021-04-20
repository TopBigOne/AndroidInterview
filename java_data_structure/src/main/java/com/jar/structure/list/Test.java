package com.jar.structure.list;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * @author : dev
 * @version :
 * @Date :  2021/4/20 15:15
 * @Desc :
 */
public class Test {

    public static void main(String[] args) {
        testFilter();
    }



    public  static void testFilter() {
        List<String> listOne = new ArrayList<>();
        List<String> listTwo = new ArrayList<>();
        listOne.add("李");
        listOne.add("1994");
        listOne.add("12");
        listOne.add("世");
        listOne.add("佳");

        listTwo.add("1994");
        listTwo.add("12");

        System.out.println("filter result : " + listOne);
        System.out.println("filter result : " + listTwo);

        List<String> result = listOne.stream().filter(new Predicate<String>() {
            @Override
            public boolean test(String s) {

                return !listTwo.contains(s);
            }
        }).collect(Collectors.toList());


        System.out.println("filter result : " + result);

    }
}
