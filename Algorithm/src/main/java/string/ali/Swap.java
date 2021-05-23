package string.ali;

import java.util.Arrays;

/**
 * @author : dev
 * @version :
 * @Date :  2021/4/8 11:23
 * @Desc :
 * <p>
 * 笔试
 * 输入任意一个大于 1 位的数字，比如 1538567，交换其中任意两个数字（仅限一次），要求得到数字比之前大，
 * 但要小于其他交换方式得到的结果；若找不到这样的数字，或者交换后的数字均小于交换之前，输出原来的数字。
 * <p>
 * 例如：
 * 输入：1538567，输出：1538576
 * 输入：521，输出：521
 */
public class Swap {
    public int sc(int num) {
        char[] chars = String.valueOf(num).toCharArray();
        int len = chars.length;
        int[] nums = new int[len];
        int index = 0;
        for (char aChar : chars) {
            nums[index] = Integer.parseInt(String.valueOf(aChar));
            index++;
        }
        // 当前最左
        int left = len - 2;
        while (left >= 0) {
            // 如果最左边是最大的数，继续往前找
            if (nums[left] >= nums[left + 1]) {
                left -= 1;
                continue;
            }
            // 达到交换条件
            int i = left + 1;
            int d = 0;
            while (i < len) {
                if (nums[left] > nums[i]) {
                    d = i - 1;
                }
                i = i + 1;
            }
            if (d == 0) {
                d = len - 1;
            }
            // 交换两个元素
            int temp = nums[left];
            nums[left] = nums[d];
            nums[d] = temp;
            break;
        }

        System.out.println("nums:" + Arrays.toString(nums));
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < len; i++) {
            result.append(nums[i]);
        }
        return Integer.parseInt(result.toString());
    }

    public static void main(String[] args) {
        Swap swap = new Swap();
        // int result = swap.sc2(1538567);
        int result = swap.sc(521);
        System.out.println("result:" + result);
    }


}
