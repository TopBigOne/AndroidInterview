package single_invoke_queue.leet_code_239;

import java.util.Arrays;

/**
 * @author : dev
 * @version :
 * @Date :  5/23/21 7:04 PM
 * @Desc :
 */
public class Test {
    public static void main(String[] args) {
        //test1();
        test2();
    }

    private static void test1() {
        int[] raw = {1, 3, -1, -3, 5, 3, 6, 7};
        int k = 3;
        MaxSlidingWindow minWindow = new MaxSlidingWindow();
        int[] result = minWindow.maxSlidingWindow(raw, k);
        System.out.println("result : " + Arrays.toString(result));
    }
    private static void test2() {
        int[] raw = {1, 3, -1, -3, 5, 3, 6, 7};
        int k = 3;
        MaxSlidingWindow3 minWindow = new MaxSlidingWindow3();
        int[] result = minWindow.maxSlidingWindow(raw, k);
        System.out.println("result : " + Arrays.toString(result));
    }




}
