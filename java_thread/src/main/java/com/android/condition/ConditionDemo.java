package com.android.condition;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author : Jakarta
 * @version :
 * @Date : 10/5/20 9:14 PM
 * @Desc :
 */
class ConditionDemo {
    public static final int COUNT  = 10;
    public static void main(String[] args) {
        ReentrantLock lock = new ReentrantLock(true);
        Condition conditionOne = lock.newCondition();
        test(lock, conditionOne);
    }

    private static void test(ReentrantLock lock, Condition conditionOne) {
        lock.lock();
        try {
            int i = 100;
            while (i < COUNT) {
                conditionOne.await();

            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }


}
