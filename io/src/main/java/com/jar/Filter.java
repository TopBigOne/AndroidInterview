package com.jar;

import java.util.Set;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Stream;

/**
 * @author : dev
 * @version :
 * @Date :  12/1/20 7:36 PM
 * @Desc :
 */
public class Filter {
    public static void main(String[] args) {
        Filter filter = new Filter();
        filter.filter();
    }

    public void filter() {
        Integer[] sixNum = {1, 2, 3, 4, 5, 6,};
        Stream.of(sixNum).filter(new Predicate<Integer>() {
            @Override
            public boolean test(Integer integer) {
                // 判断奇偶
                return (integer & 1) == 1;
            }
        }).forEach(new Consumer<Integer>() {
            @Override
            public void accept(Integer integer) {
                System.out.println("result:" + integer);
            }
        });

    }
}
