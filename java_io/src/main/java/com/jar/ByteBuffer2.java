package com.jar;

import java.lang.reflect.Field;

import sun.misc.Unsafe;

/**
 * @author : dev
 * @version :
 * @Date :  2022/7/4 18:02
 * @Desc :
 */
public class ByteBuffer2 {
    public static void main(String[] args) {
        try {
            Unsafe unsafe = getUnsafeInstance();
            long memoryAddress = unsafe.allocateMemory(1024 * 1024 * 10);
            Thread.sleep(1000);
            unsafe.freeMemory(memoryAddress);


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
