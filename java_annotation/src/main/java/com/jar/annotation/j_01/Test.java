package com.jar.annotation.j_01;

/**
 * @author : dev
 * @version :
 * @Date :  2021/4/29 17:51
 * @Desc : 测试注解
 *
 * https://www.cnblogs.com/peida/archive/2013/04/26/3038503.html
 */
public class Test {
    public static void main(String[] args) {
        Apple apple = new Apple();
        String appleName = apple.getAppleName();
        String appleColor = apple.getAppleColor();
        System.out.println(appleColor);
        System.out.println(appleName);

        FruitInfoUtil.getFruitInfo(Apple.class);

    }
}
