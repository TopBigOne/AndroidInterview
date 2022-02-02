package com.jar.oom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;


/**
 * @author : Jakarta
 * @version :
 * @Date : 10/17/20 11:45 PM
 * @Desc : -XX:MaxDirectMemorySize
 * <p>
 * -Xmx64m
 * -Xms64m
 * -Xmn32m
 * -XX:+UseConcMarkSweepGC
 * -XX:+PrintGCDetails
 * -XX:+DisableExplicitGC
 * -XX:MaxDirectMemorySize=10M
 */
public class DirectMemoryOOM implements Run {
    int _1MB = 1024 * 1024;

    @Override
    public void execute() {

    }
    public static void main(String[] args) {
        DirectMemoryOOM directMemoryOOM = new DirectMemoryOOM();
        // directMemoryOOM.tt1();
//        directMemoryOOM.tt2();
        directMemoryOOM.tt3();

    }

    /**
     * 第一种:
     * native memory满了，但是young区没满，没有发生young gc回收DirectByteBuffer，
     * 所以堆外OOM（如果去掉DisableExplicitGC参数程序会一直有Full GC的信息输出，因为分配native memory的时候会主动调用System.GC()）
     */
    public void tt1() {
        while (true) {
            ByteBuffer byteBuffer = ByteBuffer.allocateDirect(1024 * 1024);
        }
    }

    /**
     * 第二种:
     * native memory没满，但是young区在native memory满之前提前满了，发生young gc回收DirectByteBuffer，
     * 不会发生OOM 如果代码换成了下面这种(jvm参数一样),一次分配的native memory足够小，会导致在native memory没有分配满的情况下，发生young gc会搜DirectByteBuffer。
     * 同时会回收native memory
     */
    public void tt2() {
        while (true) {
            ByteBuffer byteBuffer = ByteBuffer.allocateDirect(1024 / 2 / 2 / 2 / 2 / 2);
        }

    }

    /**
     *
     -Xmx64m
     -Xms64m
     -Xmn32m
     -XX:+PrintGCDetails
     -XX:MaxTenuringThreshold=1//设置进去old gen的寿命是1，默认是15次才进入old gen
     -XX:MaxDirectMemorySize=10M
     -XX:+DisableExplicitGC//不能显示full gc
     *
     *
     */
    public void tt3() {
        int i = 1;
        List<ByteBuffer> list = new ArrayList<ByteBuffer>();
        while (true) {
            System.out.println("第" + (i++) + "次");
            //分配堆内内存
            ByteBuffer.allocate(1024 * 1024);

            ByteBuffer byteBuffer = ByteBuffer.allocateDirect(1024 / 2 / 2 / 2);
            //保证引用不被younggc
            list.add(byteBuffer);
        }
    }


}
