package com.android.base;


import com.sun.org.apache.xpath.internal.operations.String;

import java.util.ArrayList;
import java.util.List;

public class ListNoGeneric {
    public static void main(String[] args) {
      /*  // 第一段
        List a1 = new ArrayList<>();
        a1.add(new String("Jar..."));
        a1.add(new Object());
        a1.add(new Integer(11));

        iteratorData("a1", a1);

        // 第二段，把 a1 引用赋值给 a2，注意 a2 与 a1 的区别是增加了泛型限制<Object>
        List<Object> a2 = a1;
        a2.add(new Object());
        a2.add(new String("Jar 2"));
        a2.add(new Integer(222));

        // 第三段，将a1 引用赋值给 a3，注意 a3 与 a1 的区别是增加了泛型<Integer>
        List<Integer> a3 = a1;
        a1.add(new Integer(333));
        // 下方两行代码编译出错，不允许增加非 Integer 类型进入集合；
      */
    }

    private static void iteratorData(java.lang.String a1, List list) {
        for (Object o : list) {

            System.out.println("a1: " + o);

        }

    }
}
