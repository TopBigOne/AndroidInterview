package tan_xin.leet_code_1005;

/**
 * @author :  dev
 * @version :
 * @Date :   2021/11/1 23:20
 * @Url : https://leetcode-cn.com/problems/maximize-sum-of-array-after-k-negations/
 * @Level :  easy
 * @Desc : K 次取反后最大化的数组和
 * @Counter :
 * @Answer :
 */
public class LargestSumAfterKNegations {
    public int largestSumAfterKNegations(int[] nums, int k) {
        int[] number = new int[201];
        for (int t : nums) {
            // 将[-100,100] 映射到[0,200]上去
            number[t + 100]++;
        }
        int i = 0;
        while (k > 0) {
            // 找到A[] 中最小的数字
            while (number[i] == 0) {
                i++;
            }
            // 此数字个数-1
            number[i]--;
            // 其相反数个数+1
            number[200 - i]++;
            // 若原最小数索引>100,则新额最小数，索引应为200-i,
            if (i > 100) {
                i = 200 - i;
            }
            k--;
        }
        int sum = 0;
        for (int j = i; j < number.length; j++) {
            sum += (j - 100) * number[j];
        }
        return sum;
    }

}
