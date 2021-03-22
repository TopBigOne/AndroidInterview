package thread.leet_code_1114;

import java.util.concurrent.Semaphore;

/**
 * @author : dev
 * @version :
 * @Date :  2021/3/21 00:52
 * @Desc : 利用信号量：Semaphore 来做这个事情
 * https://leetcode-cn.com/problems/print-in-order/solution/javayou-jie-by-no-one-9/
 */
public class Foo4_Semaphore {
    private final Semaphore semaphore01;
    private final Semaphore semaphore02;

    public Foo4_Semaphore() {
        semaphore01 = new Semaphore(0);
        semaphore02 = new Semaphore(0);
    }

    public void first(Runnable runnable) {
        runnable.run();
        semaphore01.release();
    }

    public void second(Runnable runnable) throws InterruptedException {
        semaphore01.acquire();
        runnable.run();
        semaphore02.release();
    }

    public void third(Runnable runnable) throws InterruptedException {
        semaphore02.acquire();
        runnable.run();
    }


}
