package com.android.java_thread;


import org.openjdk.jol.info.ClassLayout;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Phaser;

public class PhaserDemo {
    Phaser mPhaser = new Phaser();

    public static void main(String[] args) {
        Object o = new Object();
        System.out.println(ClassLayout.parseInstance(o).toPrintable());


    }
}
