package thread.leet_code_1114;

import java.nio.ByteBuffer;

/**
 * @author :  dev
 * @version :
 * @Date :   2022/5/17 23:25
 * @Url :
 * @Level :  easy  medium hard
 * @Desc :
 * @Counter :
 * @Answer :
 */
public class Foo5 {
    public static void main(String[] args) {
//
//        for (; ; ) {
//            System.out.println("陈筱雅----》");
//            try {
//                Thread.sleep(1500);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }

        Thread thread = new Thread(new TestThread(), "周广亚的线程");
        thread.start();
    }

    static class TestThread implements Runnable {
        @Override
        public void run() {
            int i = 0;
            for (; ; ) {
                i++;

                String a = new String("陈筱雅" + i);
                ByteBuffer byteBuffer = ByteBuffer.allocateDirect(1024);

                ByteBuffer allocate = ByteBuffer.allocate(1024);


                System.out.println(a);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }


            }
        }
    }
}
