package com.jar;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author : dev
 * @version :
 * @Date :  12/1/20 6:38 PM
 * @Desc : 测试一下 map
 */
public class MapStream {
    public static void main(String[] args) {
        MapStream mapStream = new MapStream();
        List<String> result = mapStream.map(Stream.of("fds", "dd", "dsfdse", "dsfds").collect(Collectors.toList()));
        // java 1.8 可以直接遍历
        result.forEach(new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println("result: "+s);
            }
        });
    }

    public List<String> map(List<String> wordList) {
        return wordList.stream().map(new Function<String, String>() {
            @Override
            public String apply(String s) {
                return s.toUpperCase();
            }
        }).collect(Collectors.toList());
    }
}
