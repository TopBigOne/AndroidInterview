package binary_search.leet_code_611;

import java.util.Arrays;

/**
 * @author : dev
 * @version :
 * @Date :  2022/6/8 17:44
 * @Desc :
 */
public class TriangleNumber3 {
    public int triangleNumber(int[] nums) {
        Arrays.sort(nums);
        int len = nums.length;
        int count = 0;
        for (int i = 0; i < len - 2; i++) {
            for (int j = i + 1; j < len - 1; j++) {
                // 找到第 1 个大于等于两边之和的下标

                int left = j + 1;
                int right = len;
                while (left < right) {
                    int mid = (left + right) / 2;
                    if (nums[mid] < nums[i] + nums[j]) {
                        left = mid + 1;
                    } else {
                        right = mid;
                    }
                }
                count += (left - j - 1);
            }
        }
        return count;

    }

    public int triangleNumber2(int[] nums) {
        Arrays.sort(nums);
        int result = 0;
        int len = nums.length;
        for (int i = 0; i < len - 2; i++) {
            for (int j = i + 1; j < len - 1; j++) {
                int left = j + 1;
                int right = len;

                while (left < right) {
                    int mid = (left + right) >>> 1;
                    if (nums[mid] < nums[i] + nums[j]) {
                        left = mid + 1;
                    } else {
                        // 右指针，向左边移动
                        right = mid;
                    }
                }
                result += (left - j - 1);
            }
        }
        return result;

    }
}
