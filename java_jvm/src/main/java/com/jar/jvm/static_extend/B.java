package com.jar.jvm.static_extend;

/**
 * @author : dev
 * @version :
 * @Date :  3/11/21 2:14 PM
 * @Desc :
 */
public class B extends A {
    public static String staticStr = "B改写后的静态属性";
    public String nonStaticStr = "B改写后的非静态属性";

    public static void staticMethod() {
        System.out.println("B改写后的静态方法");
    }
}
