package com.android.base.try_catch;

/**
 * @author :  dev
 * @version :
 * @Date :   2022/2/7 16:07
 * @Url :
 * @Level :    medium
 * @Desc :
 * @Counter :
 * @Answer :
 */
public class TryDemo {
    public static void main(String[] args) {
        int result = test();
        System.out.println("result: " + result);
    }

    private static int test() {
        int result = 0;
        int a = 0;
        int b = 10;
        try {
            result = a + b;
            return result;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            System.out.println(" finally 里的函数....");
        }
        result = 20;
        return result;
    }
}
