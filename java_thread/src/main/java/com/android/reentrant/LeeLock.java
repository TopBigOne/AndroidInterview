package com.android.reentrant;

import java.util.concurrent.locks.AbstractQueuedSynchronizer;

/**
 * @author :  dev
 * @version :
 * @Date :   2021/8/4 11:04
 * @Url :
 * @Level :  easy  medium hard
 * @Desc : 利用AQS 自己实现一个同步工具
 * @Counter :
 * @Answer :
 */
public class LeeLock {

    private Sync sync = new Sync();

    public void lock() {
        sync.acquire(1);
    }

    public void release() {
        sync.release(1);
    }

    public static class Sync extends AbstractQueuedSynchronizer {
        @Override
        protected boolean tryAcquire(int arg) {
            return compareAndSetState(0, 1);
        }

        @Override
        protected boolean tryRelease(int arg) {

            setState(0);
            return true;
        }

        @Override
        protected boolean isHeldExclusively() {
            return getState() == 1;
        }
    }



}
