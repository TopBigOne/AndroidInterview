package com.example.java_reflect;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class MyClass {

    public static void main(String[] args) {
        MyClass myClass = new MyClass();
        myClass.test();
        myClass.test2();
        myClass.test3();
    }

    /**
     * 泛型只在编译期间生效
     */
    public void test() {
        // 1、检验泛型擦除
        List list1 = new ArrayList();
        List<String> list2 = new ArrayList<>();
        System.out.println(list1.getClass() == list2.getClass());
        // 2、集合泛型是为了类型检查，避免错误输入
    }

    /**
     * 3、可以通过反射绕过泛型的检查，添加不同类型的元素
     */
    public void test2() {
        try {
            List<String> stringList = new ArrayList<>();
            stringList.add("1234");
            Class<?> aClass = stringList.getClass();
            Method method = aClass.getDeclaredMethod("add", Object.class);
            method.invoke(stringList, 24);
            System.out.println("list size :" + stringList.size());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void test3() {
        List list = new ArrayList();
        list.add(454);
        list.add("奥特曼");
        System.out.println("list content: " + list);
    }
}