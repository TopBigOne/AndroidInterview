package array.leet_code_1588;

import java.util.Arrays;

/**
 * @author :  dev
 * @version :
 * @Date :   2021/12/26 20:39
 * @Url :
 * @Level :  easy
 * @Desc :
 * @Counter :
 * @Answer : https://leetcode-cn.com/problems/sum-of-all-odd-length-subarrays/submissions/
 */
public class SumOddLengthSubarray {
    public static void main(String[] args) {
        int[] arr = {1, 4, 2, 5, 3};

        SumOddLengthSubarray sumOddLengthSubarray = new SumOddLengthSubarray();
        sumOddLengthSubarray.sumOddLengthSubarrays(arr);

    }

    /**
     * 前缀和
     *
     * @param arr
     * @return
     */
    public int sumOddLengthSubarrays(int[] arr) {
        int length = arr.length;
        int[] sum = new int[length + 1];
        for (int i = 1; i <= length; i++) {
            sum[i] = sum[i - 1] + arr[i - 1];

        }
        System.out.println("sum:" + Arrays.toString(sum));
        int ans = 0;
        for (int partLength = 1; partLength <= length; partLength += 2) {
            for (int l = 0; l + partLength - 1 < length; l++) {
                int r = l + partLength - 1;
                ans += sum[r + 1] - sum[l];
            }
        }
        return ans;
    }

    /**
     * 数学
     *
     * @param arr
     * @return
     */
    public int sumOddLengthSubarrays2(int[] arr) {
        int length = arr.length;
        int ans = 0;
        for (int i = 0; i < length; i++) {
            // 奇数
            int l1 = (i + 1) / 2;
            int r1 = (length - i) / 2;

            // 偶数
            int l2 = i / 2;
            int r2 = (length - i - 1) / 2;
            l2++;
            r2++;
            ans += (l1 * r1 + l2 * r2) * arr[i];
        }

        return ans;


    }


}
