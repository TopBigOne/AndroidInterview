package com.thread.java_thread;


import org.openjdk.jol.info.ClassLayout;

import java.util.concurrent.Phaser;
import java.util.concurrent.locks.ReentrantLock;

public class PhaserDemo {
    Phaser mPhaser = new Phaser();

    public static void main(String[] args) {
        Object o = new Object();
        System.out.println(ClassLayout.parseInstance(o).toPrintable());

        int i= 1;
        int result = (++i)+(++i) ;
        System.out.println("result :"+result);


    }
}
