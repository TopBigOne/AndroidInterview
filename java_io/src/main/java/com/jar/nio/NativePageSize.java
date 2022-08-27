package com.jar.nio;

import java.lang.reflect.Field;

import sun.misc.Unsafe;

/**
 * @author : dev
 * @version :
 * @Date :  2022/7/4 17:45
 * @Desc :
 */
public class NativePageSize {

    static class Person {
        int age;
        String name;

    }

    public static void main(String[] args) {
        try {
            Unsafe unsafe = getUnsafeInstance();
            int pageSize = unsafe.pageSize();
            System.err.println("pageSize    : " + pageSize);

            int addressSize = unsafe.addressSize();
            System.err.println("addressSize : " + addressSize);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public static Unsafe getUnsafeInstance() throws Exception {
        // 通过反射获取rt.jar下的Unsafe类
        Field theUnsafeInstance = Unsafe.class.getDeclaredField("theUnsafe");
        theUnsafeInstance.setAccessible(true);
        // 是等价的
        // return (Unsafe) theUnsafeInstance.get(null);
        return (Unsafe) theUnsafeInstance.get(Unsafe.class);
    }


}
