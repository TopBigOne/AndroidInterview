package com.jar;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Stream;

/**
 * @author : dev
 * @version :
 * @Date :  12/1/20 6:52 PM
 * @Desc :flatMap 把 Input Stream 中的层级结构扁平化，就是将底层元素抽出来，放到一去，最终 output 的新的 Stream 里面已经没有 List 了，都是直接的数字
 */
public class FlatMap {
    public static void main(String[] args) {
        FlatMap flatMap = new FlatMap();
        flatMap.flat();
    }

    private void flat() {
        Stream<List<Integer>> instream = Stream.of(Collections.singletonList(1),
                Arrays.asList(2, 3),
                Arrays.asList(4, 5, 6));
        Stream<Integer> integerStream = instream.flatMap(new Function<List<Integer>, Stream<Integer>>() {
            @Override
            public Stream<Integer> apply(List<Integer> integers) {
                return integers.stream();
            }
        });

        integerStream.forEach(new Consumer<Integer>() {
            @Override
            public void accept(Integer integer) {
                System.out.println("result: " + integer);
            }
        });

    }
}
