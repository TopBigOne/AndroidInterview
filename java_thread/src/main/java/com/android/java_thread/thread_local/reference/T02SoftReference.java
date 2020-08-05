package com.android.java_thread.thread_local.reference;

import java.lang.ref.SoftReference;

/**
 * @author : Jakarta
 * @version :
 * @Date : 8/6/20 12:43 AM
 * @Desc : 软引用,注意，heap 的最大为 20M，只有内存不够使用的时候，才会被回收；
 */
public class T02SoftReference {
    public static void main(String[] args) {
        SoftReference<byte[]> m = new SoftReference<>(new byte[1024 * 1024 * 10]);
        System.out.println(m.get());
        System.gc();
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(m.get());
        // 在分配一个字节数组
        byte[] b = new byte[1024 * 1024 * 15];
        System.out.println(m.get());

    }
}
