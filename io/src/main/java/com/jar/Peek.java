package com.jar;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.xml.transform.Source;

/**
 * @author : dev
 * @version :
 * @Date :  12/1/20 8:25 PM
 * @Desc :
 */
public class Peek {
    public static void main(String[] args) {
        Peek peek = new Peek();
        peek.peek();
    }

    private void peek() {
        Stream.of("one", "two", "three", "four")
                .filter(new Predicate<String>() {
                    @Override
                    public boolean test(String s) {
                        return s.length() > 3;
                    }
                }).peek(new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println("Filtered value :" + s);
            }
        }).map(new Function<String, String>() {
            @Override
            public String apply(String s) {
                return s.toLowerCase();
            }
        }).peek(new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println("Mapped value: " + s);
            }
        }).collect(Collectors.toList());
    }
}
