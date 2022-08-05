package sort.quick_sort.leet_code_179;

/**
 * @author : dev
 * @version :
 * @Date :  2022/6/7 18:47
 * @Desc : 179： 最大数  https://leetcode.cn/problems/largest-number/
 * <p>
 *
 *
 * 题解：https://leetcode-cn.com/problems/largest-number/solution/chao-guo-100-java-shou-xie-kuai-pai-by-w-gb2w/
 */
public class LargestNumber {

    public String largestNumber(int[] nums) {

        quickSort(nums, 0, nums.length - 1);

        if (nums[0] == 0) {
            return "0";
        }
        StringBuilder ans = new StringBuilder();
        for (int num : nums) {
            ans.append(num);
        }
        return ans.toString();
    }

    private void quickSort(int[] nums, int start, int end) {
        if (start >= end) {
            return;
        }
        int pivot = nums[start];
        int index = start;

        for (int i = start + 1; i <= end; i++) {
            long x = 10;
            long y = 10;
            while (nums[i] >= x) {
                x *= 10;
            }
            while (pivot >= y) {
                y *= 10;
            }
            if (nums[i] * y + pivot > nums[i] + pivot * x) {
                index += 1;
                swap(nums, index, i);
            }
        }

        swap(nums, index, start);
        quickSort(nums, start, index - 1);
        quickSort(nums, index + 1, end);
    }

    private void swap(int[] nums, int l, int r) {
        int temp = nums[l];
        nums[l] = nums[r];
        nums[r] = temp;
    }

}
