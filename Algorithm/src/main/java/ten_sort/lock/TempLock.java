package ten_sort.lock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;


/**
 * @author : Jakarta
 * @version :
 * @Date : 2020-06-29 10:21
 * @Desc :  这就是 lock
 */
public class TempLock implements Lock {
    @Override
    public void lock() {

    }

    @Override
    public void lockInterruptibly() throws InterruptedException {

    }

    @Override
    public boolean tryLock() {
        return false;
    }

    @Override
    public boolean tryLock(long time, TimeUnit unit) throws InterruptedException {
        return false;
    }

    @Override
    public void unlock() {

    }

    @Override
    public Condition newCondition() {
        return null;
    }


    public int tt(int n) {
        int temp = 0;
        int pre = 1;
        int res = 2;
        if (n == 0) {
            return 0;
        }
        if (n == 1 || n == 2) {// /Users/dev/Downloads/android_frameworks_base-quartz/media/jni/android_media_MediaScanner.cpp
            return res;
        }
        for (int i = 3; i < n; i++) {
            temp = res;
            res += pre;
            pre = temp;
        }
        return res;


    }


}
