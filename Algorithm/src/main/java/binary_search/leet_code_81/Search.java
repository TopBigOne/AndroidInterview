package binary_search.leet_code_81;

import com.sun.media.sound.ModelChannelMixer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

import binary_search.Base;

/**
 * @author : dev
 * @version :
 * @Date :  2022/7/1 21:52
 * @Desc : 81. 搜索旋转排序数组 II
 * https://leetcode.cn/problems/search-in-rotated-sorted-array-ii/
 * <p>
 * 题解：https://leetcode.cn/problems/search-in-rotated-sorted-array-ii/solution/zai-javazhong-ji-bai-liao-100de-yong-hu-by-reedfan/
 */
public class Search extends Base {
    public static void main(String[] args) {
    }


    public boolean search(int[] nums, int target) {
        int len;
        if (nums == null || (len = nums.length) == 0) {
            return false;
        }

        int left = 0;
        int right = len - 1;
        while (left <= right) {
            int mid = (left + right) >>> 1;

            int midValue = nums[mid];


            // case 1:
            if (midValue == target) {
                return true;
            }

            if (nums[left] == midValue) {
                left++;
                continue;
            }


            // case 2:
            if (nums[left] < nums[mid]) {
                // 在左侧找
                if (midValue > target && nums[left] <= target) {
                    right = mid - 1;

                } else {
                    // 在右侧找
                    left = mid + 1;
                }

                continue;
            }

            if (nums[left] >= nums[mid]) {
                if (midValue < target && nums[right] >= target) {
                    left = mid + 1;

                } else {
                    right = mid - 1;
                }
            }

        }

        return false;


    }

    public boolean search2(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return false;
        }

        int start = 0;
        int end = nums.length - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] == target) {
                return true;
            }

            // 数组为：1 0 1 1 1
            // case 1：
            if (nums[start] == nums[mid]) {
                start++;
                continue;
            }

            // case 2： 前半部分有序
            if (nums[start] < nums[mid]) {
                // target在前半部分
                //  大约这个样子：nums[start] <= target < nums[mid]
                if (nums[mid] > target && nums[start] <= target) {
                    end = mid - 1;
                } else {  //否则，去后半部分找
                    start = mid + 1;
                }
                continue;
            }

            //case 3：后半部分有序
            if (nums[start] > nums[mid]) {
                //target在后半部分
                // nums[mid] < target<=nums[end]
                if (nums[mid] < target && nums[end] >= target) {
                    start = mid + 1;
                } else {
                    end = mid - 1;

                }
            }

        }
        //一直没找到，返回false
        return false;

    }

    public boolean search3(int[] nums, int target) {
        List<Integer> res = Arrays.stream(nums).boxed().collect(Collectors.toList());
        while (res.size() > 1 && res.get(res.size() - 1) == res.get(0)) {
            res.remove(res.size() - 1);
        }
        nums = res.stream().mapToInt(v -> v).toArray();

        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            int midValue = nums[mid];
            if (midValue >= nums[0] == target >= nums[0]) {
                if (midValue < target) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            } else if (target >= nums[0]) {
                right = mid - 1;
            } else if (target < nums[0]) {
                left = mid + 1;
            }
        }

        if (left == right && nums[left] == target) {
            return true;
        }
        return false;

    }


}
