package thread.leet_code_1114;

/**
 * @author : dev
 * @version :
 * @Date :  2021/3/21 00:07
 * @Desc :
 *
 *  利用synchronized
 * 视频：https://www.bilibili.com/video/BV16U4y1H77n?from=search&seid=6016529244648439794
 */
public class Foo2 {
    private int flag = 0;
    private final Object lock = new Object();

    public void first(Runnable first) throws InterruptedException {
        synchronized (lock) {
            while (flag!=0){
                lock.wait();
            }
            first.run();
            flag = 1;
            lock.notifyAll();
        }
    }

    public void second(Runnable runnable) throws InterruptedException {
        synchronized (lock) {
            while (flag != 1) {
                lock.wait();
            }
            runnable.run();
            flag=2;
            lock.notifyAll();
        }

    }

    public void third(Runnable runnable) throws InterruptedException {
        synchronized (lock) {
            while (flag != 2) {
                lock.wait();
            }
            runnable.run();
            flag=0;
            lock.notifyAll();
        }
    }



}
