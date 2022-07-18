package array.remove_duplicate_element.leet_code_26;

import java.util.Arrays;

/**
 * @author : dev
 * @version :
 * @Date :  5/30/21 3:33 PM
 * @Desc :
 */
public class Test {
    public static void main(String[] args) {
       // test1();
        test2();
    }

    private static void test1() {
        RemoveDuplicate removeDuplicate = new RemoveDuplicate();
        int[] raws = {2, 3, 3, 4, 4, 5, 6, 7, 7, 8};
        int result = removeDuplicate.removeDuplicate(raws);

        System.out.println("raws   : " + Arrays.toString(raws));
        System.out.println("result : " + result);
    }

    private static void test2() {
        RemoveDuplicate2 removeDuplicate = new RemoveDuplicate2();
        int[] raws = {2, 3, 3, 4, 4, 5, 6, 7, 7, 8};

        System.out.println("没有处理的数组   : " + Arrays.toString(raws));
        int result = removeDuplicate.removeDuplicates(raws);
        System.out.println("处理以后的数组   : " + Arrays.toString(raws));

        System.out.println(" 新数组的长度 : " + result);
    }
}
