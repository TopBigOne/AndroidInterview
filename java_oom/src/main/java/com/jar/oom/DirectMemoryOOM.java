package com.jar.oom;

import java.lang.reflect.Field;

import sun.misc.Unsafe;

/**
 * @author : Jakarta
 * @version :
 * @Date : 10/17/20 11:45 PM
 * @Desc :
 */
public class DirectMemoryOOM  implements Run{
    int _1MB = 1024 * 1024;
    @Override
    public void execute() throws IllegalAccessException {
        Field declaredField = Unsafe.class.getDeclaredFields()[0];
        declaredField.setAccessible(true);
        Unsafe unsafe = (Unsafe) declaredField.get(null);


        while (true){
            unsafe.allocateMemory(_1MB);
        }

    }
}
