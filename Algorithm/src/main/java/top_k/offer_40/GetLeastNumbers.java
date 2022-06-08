package top_k.offer_40;

import java.util.Arrays;

/**
 * @author : dev
 * @version :
 * @Date :  2/12/22 3:45 PM
 * @Desc :   最小的 k 个数： https://leetcode-cn.com/problems/zui-xiao-de-kge-shu-lcof/
 */
public class GetLeastNumbers {

    public int[] getLeastNumbers(int[] arr, int k) {
        Arrays.sort(arr);
        int[] res = new int[k];

        System.arraycopy(arr, 0, res, 0, k);

        return res;

    }

    public int[] getLeastNumbers2(int[] arr, int k) {
        Arrays.sort(arr);
        int[] res = new int[k];

        if (k >= 0) System.arraycopy(arr, 0, res, 0, k);

        return res;

    }

    public int[] getLeastNumbers3(int[] arr, int k) {
        Arrays.sort(arr);
        int[] result = new int[k];

        System.arraycopy(arr, 0, result, 0, k);
        return result;

    }
}
