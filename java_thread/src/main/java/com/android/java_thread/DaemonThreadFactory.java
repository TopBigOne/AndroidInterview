package com.android.java_thread;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author : Jakarta
 * @version :
 * @Date : 7/13/20 1:43 AM
 * @Desc :
 */


public class DaemonThreadFactory implements ThreadFactory {
    final        ThreadGroup   group;
    final        AtomicInteger threadNumber = new AtomicInteger(1);
    final        String        namePrefix;
    static final String        nameSuffix   = "]";

    public DaemonThreadFactory(String poolName) {
        SecurityManager s = System.getSecurityManager();
        group = (s != null) ? s.getThreadGroup() :
                Thread.currentThread().getThreadGroup();
        namePrefix = "JMX Monitor " + poolName + " Pool [Thread-";
    }

    public DaemonThreadFactory(String poolName, ThreadGroup threadGroup) {
        group = threadGroup;
        namePrefix = "JMX Monitor " + poolName + " Pool [Thread-";
    }

    public ThreadGroup getThreadGroup() {
        return group;
    }

    @Override
    public Thread newThread(Runnable r) {
        Thread t = new Thread(group,
                r,
                namePrefix +
                        threadNumber.getAndIncrement() +
                        nameSuffix,
                0);
        t.setDaemon(true);
        if (t.getPriority() != Thread.NORM_PRIORITY)
            t.setPriority(Thread.NORM_PRIORITY);
        return t;
    }
}