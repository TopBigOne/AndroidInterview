package com.jar.oom;

import java.util.concurrent.Callable;

/**
 * @author : dev
 * @version :
 * @Date :  1/19/21 11:19 AM
 * @Desc :运行时常量池导致的 OOM
 */
public class RuntimeConstantPoolOOM {
    public static void main(String[] args) {
        String str1 = new StringBuilder("计算机").append("软件").toString();
        System.out.println(str1.intern() == str1);
        String str2 = new StringBuilder("ja").append("va").toString();
        System.out.println(str2.intern() == str2);
        int a = 10;

    }
}
