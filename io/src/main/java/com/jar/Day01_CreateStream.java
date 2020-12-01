package com.jar;


import java.util.List;
import java.util.stream.Stream;

/**
 * 创建流
 */
public class Day01_CreateStream {

    /**
     * Individual
     *
     * @param a
     * @param b
     * @param c
     * @return
     */
    public Stream<String> createStreamByOf(String a, String b, String c) {
        return Stream.of(a, b, c);
    }

    /**
     * arrays
     *
     * @param strings
     * @return
     */
    public Stream<String> createStreamByArray(String[] strings) {
        return Stream.of(strings);
    }

    /**
     * Collectors
     *
     * @param list
     * @return
     */
    public Stream<String> createStreamByCollectors(List<String> list) {
        return list.stream();
    }

}