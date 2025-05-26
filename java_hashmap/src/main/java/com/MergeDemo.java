package com;

import java.util.HashMap;
import java.util.function.BiFunction;

/**
 * @author : dev
 * @version :
 * @Date :  7/25/21 7:42 PM
 * @Desc : 测试 Hash 的 merge 功能
 */
public class MergeDemo {
    public static void main(String[] args) {
        // test_One();
//        test_two();
        testThree();

    }

    private static void testThree() {
        int a = 10;
        int b = 20;
        if (a == 10) {
            System.err.println("return   ------1");
            return;
        } else {

            System.err.println("listener.onSuccess(); ---2");
        }

        System.err.println(" SharedPerferencesDataUtils.getInstance().putLocalInstallPlugin(pluginId, pluginInfo)---3");

    }

    private static void test_One() {
        HashMap<String, Integer> prices = new HashMap<>();
        prices.put("Shoes", 100);
        prices.put("Bag", 230);
        prices.put("Pant", 330);

        System.out.println("old prices : " + prices);
        Integer shirt = prices.merge("shirt", 90, new BiFunction<Integer, Integer, Integer>() {
            @Override
            public Integer apply(Integer integer, Integer integer2) {
                return integer + integer2;
            }
        });
        System.out.println(" shirt : " + shirt);
        System.out.println(" update 以后的 prices：" + prices);
    }


    private static void test_two() {
        HashMap<String, Integer> prices = new HashMap<>();
        prices.put("Shoes", 100);
        prices.put("Bag", 230);
        prices.put("Pant", 330);
        System.out.println(" old prices : " + prices);
        Integer newPant = prices.merge("Pant", 90, new BiFunction<Integer, Integer, Integer>() {
            @Override
            public Integer apply(Integer integer, Integer integer2) {
                System.out.println("         integer : " + integer + ", integer2 : " + integer2);
                return integer + integer2;
            }
        });
        System.out.println(" newPant : " + newPant);
        System.out.println(" updated prices：" + prices);
    }


}
