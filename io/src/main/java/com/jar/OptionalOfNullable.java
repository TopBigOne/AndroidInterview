package com.jar;

import java.util.Optional;
import java.util.function.Consumer;

/**
 * @author : dev
 * @version :
 * @Date :  12/1/20 8:46 PM
 * @Desc :
 */
public class OptionalOfNullable {
    public static void main(String[] args) {
        OptionalOfNullable optionalOfNullable = new OptionalOfNullable();
        optionalOfNullable.print("佳佳....我钟意你...");
        optionalOfNullable.print(null);
    }

    /**
     *
     * @param text 字符串为空的话，就不打印;
     */
    private void print(String text) {
        Optional.ofNullable(text).ifPresent(new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println("result: "+s);
            }
        });

    }
}
