package com.jar;

import java.util.function.IntConsumer;
import java.util.stream.IntStream;

/**
 * @author : dev
 * @version :
 * @Date :  12/1/20 6:14 PM
 * @Desc : 数值stream
 */
public class ValueStream {
    public static void main(String[] args) {
        ValueStream valueStream = new ValueStream();
        valueStream.exe();
    }


    public void exe(){
        IntStream.of(1,2,3,4,53,3).forEach(new IntConsumer() {
            @Override
            public void accept(int value) {
                System.out.println("value :"+ value);
            }
        });

        System.out.println("------------------------------------");
    }



}
