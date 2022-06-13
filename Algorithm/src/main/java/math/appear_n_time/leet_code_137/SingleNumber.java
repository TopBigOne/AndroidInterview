package math.appear_n_time.leet_code_137;

/**
 * @author : dev
 * @version :
 * @Date :  2022/6/10 17:54
 * @Desc : https://leetcode.cn/problems/single-number-ii/
 * <p>
 * 给你一个整数数组 nums ，除某个元素仅出现 一次 外，
 * 其余每个元素都恰出现 三次 。请你找出并返回那个只出现了一次的元素。
 */
public class SingleNumber {
    public int singleNumber(int[] nums) {
        int[] counts = new int[32];
        for (int num : nums) {
            for (int j = 0; j < 32; j++) {
                counts[j] += num & 1;
                num >>>= 1;
            }
        }
        int res = 0, m = 3;
        for (int i = 0; i < 32; i++) {
            res <<= 1;
            res |= counts[31 - i] % m;
        }
        return res;


    }
}
