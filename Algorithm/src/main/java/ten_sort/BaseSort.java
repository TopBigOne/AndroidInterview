package ten_sort;

import java.util.Arrays;

/**
 * @author : Jakarta
 * @version :
 * @Date : 7/1/20 8:04 PM
 * @Desc :
 */
public class BaseSort {
    protected static int[] arr = {2, 1, 6, 4, 5, 9, 0, 6};
    public static void printResult(int[] arr) {
        System.out.println("sort result:" + Arrays.toString(arr));
    }
 public static void printResult(String methordName,int[] arr) {
        System.out.println(methordName + Arrays.toString(arr));
    }

}
