package string.leet_code_670;

import java.util.Arrays;

/**
 * @author : dev
 * @version :
 * @Date :  2021/4/8 20:46
 * @Desc : 字节：3次 : 最大交换
 * 题解：https://leetcode-cn.com/problems/maximum-swap/solution/0ms-100-bu-miao-da-wo-by-wang-xue-lei-2-iyz9/
 * <p>
 * 这题我们的想法肯定是，尽量交换前面的大数位，并且和它交换的数还得是在它后面大于它的最大数
 * <p>
 * 倒序使用数组存储下来每个位置，在它及它以后的最大数的索引
 * 然后再正序从一个数开始遍历，如果它及它以后的最大数不是它本身，那么这个数就是我们需要交换的。
 * <p>
 * https://www.youtube.com/watch?v=Ffknd1F9AOc
 */
public class MaximumSwap {
    /**
     * 解题思路:
     * 1：将数组转为字符串数组方便遍历每一个数字
     * 2：从后往前遍历，避免1993交换后出现9193而不是9913
     * 3：用一个数组记录从后往前的每一个数对应的最大值的索引比如1993，从3开始遍历，最大值是3，3的索引是3，遍历到1时，在已经遍历过的元素中最大是9，所以maxArr[0]是9的索引2，最后maxArr =[2,2,2,3]
     * 4：再从头遍历原数组，比如chars[0] = 1,和他应该对应的最大值chars[maxArr[0]] = chars[2] = 9不相等 则交换
     * 再举个例子98368，maxArr = [0,4,4,4,4],chars[0] = chars[maxArr[0]] = 9 跳过
     * chars[1] = 8, chars[maxArr[1]] = chars[4] = 8 相等 继续跳过
     * chars[2] = 3, chars[maxArr[3]] = chars[4] = 8 不相等，交换
     * 只要交换完成则跳出循环
     * @param num
     * @return
     */
    public int maximumSwap(int num) {
        char[] chars = Integer.toString(num).toCharArray();
        int length = chars.length;

        int maxIndex = length - 1;

        int[] maxArr = new int[length];

        for (int i = length - 1; i >= 0  ; i--) {
            if (chars[i] > chars[maxIndex]) {
                // maxIndex 的值可以是：3，2，1，0
                maxIndex = i;
            }
            maxArr[i] = maxIndex;
            System.out.println(Arrays.toString(maxArr));
        }

        for (int i = 0; i < length; i++) {
            if (chars[maxArr[i]] != chars[i]) {
                char temp = chars[maxArr[i]];
                chars[maxArr[i]] = chars[i];
                chars[i] = temp;
                break;
            }
        }
        return Integer.parseInt(new String(chars));



    }

}
