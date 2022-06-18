package array.sub_array.leet_code_907;

/**
 * @author : dev
 * @version :
 * @Date :  2022/6/14 16:03
 * @Desc :907. 子数组的最小值之和
 * https://leetcode.cn/problems/sum-of-subarray-minimums/
 * <p>
 * 题解：https://leetcode.cn/problems/sum-of-subarray-minimums/solution/xiao-bai-lang-dong-hua-xiang-jie-bao-zhe-489q/
 */
public class SumSubArrayMin2 {

    public static void main(String[] args) {
        int[] arr = {3, 1, 2, 4};
        SumSubArrayMin2 min = new SumSubArrayMin2();
        int result = min.sumSubarrayMins2(arr);
        System.err.println("result : " + result);
    }

    public int sumSubarrayMins(int[] arr) {
        int result = 0;
        for (int i = 0; i < arr.length; i++) {
            int min = arr[i];
            System.err.println("iValue : " + min);
            for (int j = i; j < arr.length; j++) {
                int jValue = arr[j];
                System.err.println("  -jValue : " + jValue);
                min = Math.min(min, jValue);
                System.err.println("    *使用的累加值 : " + min);
                result += min;
            }
            System.err.println("---------------------");
        }
        return result;
    }

    public int sumSubarrayMins2(int[] arr) {
        int MOD = 1000000007;
        int res = 0;
        for (int i = 0; i < arr.length; i++) {
            int min = arr[i];
            for (int j = i; j < arr.length; j++) {
                min = Math.min(min, arr[j]);
                res+=min;
                res%=MOD;
            }
        }
        return res;
    }


}
