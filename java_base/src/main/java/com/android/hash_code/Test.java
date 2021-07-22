package com.android.hash_code;

/**
 * @author :  dev
 * @version :
 * @Date :   2021/7/9 17:39
 * @Url :
 * @Level :  easy  medium hard
 * @Desc : 测试HashCode,
 *     -XX:hashCode=2
 * @Counter :
 * @Answer :
 */
public class Test {
    public static void main(String[] args) {
        System.out.println("-------------args : "+ args[0]);
        System.out.println("-------------start");
        System.out.println(new Object());
        System.out.println(new Object());
        System.out.println(new Object());
        System.out.println(new Object());
        System.out.println("-------------end");

    }


}
