package binary_search.offer_11;

import java.util.Arrays;

/**
 * @author : dev
 * @version :
 * @Date :  2022/5/27 16:12
 * @Desc : 旋转数组的最小值
 * 题解：https://leetcode.cn/problems/xuan-zhuan-shu-zu-de-zui-xiao-shu-zi-lcof/solution/er-fen-jian-zhi-si-xiang-fen-zhi-si-xiang-by-liwei/
 * 视频题解：https://leetcode.cn/problems/xuan-zhuan-shu-zu-de-zui-xiao-shu-zi-lcof/solution/pei-yang-suan-fa-si-wei-cong-bao-li-dao-37iuz/
 */
public class MinArray2 extends Base {
    public static void main(String[] args) {
        testLeftTarget();
        printDivider();
        testRightTarget();

    }

    /**
     * 目标值 ：1
     * 测试：目标值在最左边：{ 10, 1, 2,3, 4, 5, 6, 7, 9};
     */
    private static void testLeftTarget() {
        printString("目标值在左边");
        MinArray2 minArray = new MinArray2();
        int[] nums = {10, 1, 2, 3, 4, 5, 6, 7, 9};
        System.err.println(Arrays.toString(nums));
        int minValue = minArray.minArray(nums);
        System.err.println("min value : " + minValue);
    }

    /**
     * 目标值 ：1
     * 测试：目标值在最右边：{3, 4, 5, 6, 7, 9, 10, 1, 2};
     */
    private static void testRightTarget() {
        printString("目标值在右边");
        MinArray2 minArray = new MinArray2();
        int[] nums = {3, 4, 5, 6, 7, 9, 10, 1, 2};
        System.err.println(Arrays.toString(nums));
        int minValue = minArray.minArray(nums);
        System.err.println("min value : " + minValue);
    }

    public int minArray(int[] nums) {
        int len = nums.length;
        if (len == 0) {
            return 0;
        }
        int left = 0;
        int right = len - 1;

        while (left < right) {
            int mid = (left + right) >>> 1;
            int midValue = nums[mid];
            System.err.println("midValue : " + midValue);
            // 最小的元素，一定还在右边
            if (midValue > nums[right]) {
                left = mid + 1;
            } else if (midValue == nums[right]) {
                // 只能把 right 排除掉，下一轮搜索区间[left, right-1]
                right = right - 1;
            } else {
                // 最小的元素一定在左边
                // 此时，mid value < num[right>
                // mid 的 右边一定不是最小数字，mid 有可能是，下一轮搜索区间是[left,mid]
                right = mid;
            }

        }
        return nums[left];
    }

    public int minArray2(int[] nums) {
        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            int mid = (right + left) >>> 1;

            int midValue = nums[mid];

            if (midValue > nums[right]) {
                left = mid + 1;
            } else if (midValue == nums[right]) {
                right = right - 1;
            } else {
                right = mid;
            }
        }
        return nums[left];

    }

    public int minArray3(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int mid = (right + left) >>> 1;
            int midValue = nums[mid];
            int rightValue = nums[right];
            if (midValue > nums[right]) {
                left = mid + 1;
            } else if (midValue == rightValue) {
                right = right - 1;
            } else {
                right = mid;
            }
        }
        return nums[left];


    }

    public int minArray4(int[] numbers) {
        int left = 0;
        int right = numbers.length - 1;

        while (left < right) {

            int mid = (right + left) >>> 1;

            int midValue = numbers[mid];
            int rightValue = numbers[right];

            if (midValue > rightValue) {
                left = mid + 1;
                continue;
            }
            if (midValue == rightValue) {
                right = right - 1;
                continue;
            }
            if (midValue < rightValue) {
                right = mid;
                continue;
            }
        }

        return numbers[left];

    }


}
