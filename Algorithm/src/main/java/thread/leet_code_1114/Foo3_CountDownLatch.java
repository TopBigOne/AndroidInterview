package thread.leet_code_1114;

import java.util.concurrent.CountDownLatch;

/**
 * @author : dev
 * @version :
 * @Date :  2021/3/21 00:42
 * @Desc :利用CountDownLatch
 *
 * https://leetcode-cn.com/problems/print-in-order/solution/javayou-jie-by-no-one-9/
 */
public class Foo3_CountDownLatch {
    private CountDownLatch countDownLatch01;
    private CountDownLatch countDownLatch02;

    public Foo3_CountDownLatch() {
        countDownLatch01 = new CountDownLatch(1);
        countDownLatch02 = new CountDownLatch(1);
    }

    public void first(Runnable runnable) {
        runnable.run();
        countDownLatch01.countDown();
    }

    public void second(Runnable runnable) throws InterruptedException {
        // 在这里阻塞住
        countDownLatch01.await();
        runnable.run();
        countDownLatch02.countDown();
    }

    public void third(Runnable runnable) throws InterruptedException {
        countDownLatch02.await();
        runnable.run();
    }
}
