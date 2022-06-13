package math.appear_n_time.offer_56_1;

import java.util.Arrays;

/**
 * @author : dev
 * @version :
 * @Date :  2022/6/10 16:32
 * @Desc :剑指 Offer 56 - I. 数组中数字出现的次数
 * https://leetcode.cn/problems/shu-zu-zhong-shu-zi-chu-xian-de-ci-shu-lcof/
 *
 * <p>
 * 一个整型数组 nums 里除两个数字之外，
 * 其他数字都出现了两次。请写程序找出这两个只出现一次的数字。要求时间复杂度是O(n)，空间复杂度是O(1)。
 * <p>
 * 分组：
 * 1：两个独特的 数字分成不同的组；
 * 2：相同的数字分成相同的组；
 */
public class SingleNumbers {
    public static void main(String[] args) {
        int[] nums = {1, 1, 2, 2, 3, 5};
        SingleNumbers singleNumbers = new SingleNumbers();
        int[] result = singleNumbers.singleNumbers(nums);
        System.err.println("result : " + Arrays.toString(result));
    }

    public int[] singleNumbers(int[] nums) {
        // m 和n 异或的结果
        int ret = 0;
        // 求出异或值
        for (int num : nums) {
            ret ^= num;
        }

        System.out.println("ret : " + ret);

        // 找到第一位不是0 的数,
        // 分割的位置
        int div = 1;
        while ((div & ret) == 0) {
            div <<= 1;
        }

        System.out.println(" div : " + div);

        int m = 0;
        int n = 0;
        for (int num : nums) {
            // 根据改为是否为0 ，将其分为两组
            if ((div & num) != 0) {
                m ^= num;
            } else {
                n ^= num;
            }
        }

        return new int[]{m, n};


    }
}
