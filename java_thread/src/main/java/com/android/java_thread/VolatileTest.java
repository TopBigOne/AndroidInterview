package com.android.java_thread;


public class VolatileTest {
    int a = 1;
    int b = 2;

    public void change() {
        a = 3;
        b = a;
    }

    public static void main(String[] args) {
        while (true) {
            final VolatileTest test = new VolatileTest();
            new Thread() {
                @Override
                public void run() {
                    try {
                        Thread.sleep(10);
                        test.change();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }.start();

            new Thread() {
                @Override
                public void run() {

                    try {
                        Thread.sleep(10);
                        test.print();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }.start();

        }
    }

    private void print() {
        System.out.println("a:" + a + " b : " + b);
        if (a == 1 && b == 2) {
            //  System.out.println("a:" + a + " b : " + b);
            return;
        }
        if (a == 1 && b == 3) {
            //  System.out.println("a:" + a + " b : " + b);
            return;
        }
        if (a == 3 && b == 2) {
            //  System.out.println("a:" + a + "; b : " + b);
            return;
        }
        if (a == 3 && b == 3) {
            //   System.out.println("a:" + a + " b : " + b);
        }

    }


}


    




