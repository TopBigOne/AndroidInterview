package thread.leet_code_1114;

/**
 * @author : dev
 * @version :
 * @Date :  2021/3/20 22:55
 * @Desc : 按序打印： https://leetcode-cn.com/problems/print-in-order/solution/javayou-jie-by-no-one-9/
 * 解法一：Synchronized锁和控制变量
 */
public class Foo {
    public Foo() {

    }

    /**
     * 控制变量
     */
    private int flag = 0;
    /**
     * 定义Object对象锁
     */
    private final Object lock = new Object();


    public void first(Runnable printFirst) throws InterruptedException {
        synchronized (lock) {
            while (flag != 0) {
                lock.wait();
            }
            printFirst.run();
            flag = 1;
            lock.notifyAll();
        }

    }

    /**
     * @param printSecond thread
     * @throws InterruptedException 中断
     */
    public void second(Runnable printSecond) throws InterruptedException {
        synchronized (lock) {
            while (flag != 1) {
                lock.wait();
            }
            printSecond.run();
            flag = 2;
            lock.notifyAll();
        }
    }

    public void third(Runnable printThird) throws InterruptedException {
        // printThird.run() outputs "third". Do not change or remove this line.
        synchronized (lock) {
            while (flag != 2) {
                lock.wait();
            }
            printThird.run();
            flag = 0;
            lock.notifyAll();
        }
    }
}
