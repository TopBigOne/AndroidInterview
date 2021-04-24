package array.offer_03;

import java.util.*;

/**
 * @author : dev
 * @version :
 * @Date :  2021/4/24 18:11
 * @Desc : 字节出现了22次 ：剑指offer03_数组中重复的数字 https://leetcode-cn.com/problems/shu-zu-zhong-zhong-fu-de-shu-zi-lcof/
 * <p>
 * 视频： https://www.bilibili.com/video/BV14z4y1o7XH?from=search&seid=14875691609937042679
 */
public class FindRepeatNumber {
    /**
     * 这种解法可行，但是数组比较大的时候，会超出算法的时间限制；
     *
     * @param nums
     * @return
     */
    public int findRepeatNumber(int[] nums) {
        List<Integer> rawList = new ArrayList<>();
        for (int num : nums) {
            if (rawList.contains(num)) {
                return num;
            }
            rawList.add(num);
        }
        return -1;
    }

    /**
     * 使用map结合，查询时间的时间复杂度是O(n),空间复杂度是O(1)
     *
     * @param nums
     * @return
     */
    public int findRepeatNumber2(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            if (map.containsKey(num)) {
                return num;
            }
            map.put(num, num);
        }
        return -1;
    }


    /**
     * 原地置换，最牛逼的写法
     *
     * @param nums
     * @return
     */
    public int findRepeatNumber3(int[] nums) {
        int temp;
        for (int i = 0; i < nums.length; i++) {
            while (nums[i] != i) {
                if (nums[i] == nums[nums[i]]) {
                    return nums[i];
                }
                temp = nums[i];
                nums[i] = nums[temp];
                nums[temp] = temp;
            }
        }
        return -1;
    }

    /**
     * 利用HashSet
     *
     * @param nums
     * @return
     */
    public int findRepeatNumber4(int[] nums) {
        HashSet<Integer> hashSet = new HashSet<>();
        for (int num : nums) {
            int size = hashSet.size();
            if (size == 0) {
                hashSet.add(num);
                continue;
            }

            hashSet.add(num);
            int newSize = hashSet.size();
            if (newSize == size) {
                return num;
            }
        }
        return -1;
    }

    public int findRepeatNumber5(int[] nums) {
        int temp;
        for (int i = 0; i < nums.length; i++) {
            while (nums[i] != i) {
                if (nums[i] == nums[nums[nums[i]]]) {
                    return nums[i];
                }
                // 做交换
                temp = nums[i];
                nums[i] = nums[temp];
                nums[temp] = temp;

            }
        }
        return -1;
    }

    public int findRepeatNumber7(int[] nums) {
        int temp;
        for (int i = 0; i < nums.length; i++) {
            while (nums[i] != i) {
                if (nums[i] == nums[nums[i]]) {
                    return nums[i];
                }
                temp = nums[i];
                nums[i] = nums[temp];
                nums[temp] = temp;
            }
        }

        return -1;
    }

    public int findRepeatNumber8(int[] nums) {
        int temp;
        for (int i = 0; i < nums.length; i++) {
            while (nums[i] != i) {
                if (nums[i] == nums[nums[i]]) {
                    return nums[i];
                }
                temp = nums[i];
                nums[i] = nums[temp];
                nums[temp] = temp;
            }
        }
        return -1;

    }

    public int findRepeatNumber9(int[] nums) {
        int temp;
        for (int i = 0; i < nums.length; i++) {
            while (nums[i] != i) {
                if (nums[i] == nums[nums[i]]) {
                    return nums[i];
                }

                temp = nums[i];
                nums[i] = nums[temp];
                nums[temp] = temp;

            }
        }
        return -1;
    }


}
