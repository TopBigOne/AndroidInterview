package array.leet_code_128;

import java.util.HashSet;

import array.leet_code_11.MaxArea;

/**
 * @author :  dev
 * @version :
 * @Date :  2021/6/16 19:43
 * @Url : https://leetcode-cn.com/problems/longest-consecutive-sequence/
 * @Level : easy medium hard
 * @Desc :  最长连续序列（没必要按照原来数组的顺序来安排）
 * @Counter : 13
 * @Answer :
 * <p>
 * 题解1；
 */
public class LongestConsecutive {
    /**
     * 解法一(会超时)
     * 首先想一下最直接的暴力破解。我们可以用一个 HashSet 把给的数组保存起来。然后再考虑数组的每个数，
     * 比如这个数是 n，然后看 n + 1 在不在 HashSet 中，然后再看 n + 2 在不在，
     * 接下来 n + 3、n + 4 直到在 HashSet 中找不到，记录当前的长度。然后继续考虑下一个数，并且更新最长的长度。
     *
     * @param nums
     * @return
     */
    public int longestConsecutive(int[] nums) {
        int max = 0;
        if (nums == null) {
            return max;
        }
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }

        for (int num : nums) {
            int count = 0;
            // 如果结合包含
            while (set.contains(num)) {
                // 数量+1；
                count++;
                // 留意这个+1 操作
                num += 1;
            }

            max = Math.max(max, count);
        }
        return max;
    }

    /**
     * 优化一下
     *
     * @param nums
     * @return
     */
    public int longestConsecutive2(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        int max = 0;
        for (int num : nums) {
            if (!set.contains(num - 1)) {
                int count = 0;
                while (set.contains(num)) {
                    count++;
                    // 主动将当前的value 加1；
                    num += 1;
                }
                max = Math.max(max, count);
            }
        }
        return max;
    }

    public int longestConsecutive3(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        // 1: 将 数组num中的所有元素，放入hashset 中
        for (int num : nums) {
            set.add(num);
        }

        // 2：连续结果最大值
        int max = 0;
        // 3: 再次遍历
        for (int num : nums) {
            // 如果set中不包含num的前一个值num-1;
            if (!set.contains(num - 1)) {
                int count = 0;
                while (set.contains(num)) {
                    count++;
                    num += 1;
                }
                max = Math.max(max, count);
            }
        }
        return max;
    }

    public int longestConsecutive4(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }

        int max = 0;
        for (int num : nums) {
            if (!set.contains(num - 1)) {
                int count = 0;
                while (set.contains(num)) {
                    count++;
                    num += 1;
                }
                max = Math.max(max, count);
            }
        }
        return max;
    }

    public int longestConsecutive5(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        int max = 0;
        for (int num : nums) {
            // 不包含前一个
            if (!set.contains(num - 1)) {
                int count = 0;
                while (set.contains(num)) {
                    count++;
                    num += 1;
                }
                max = Math.max(max, count);
            }
        }
        return max;
    }

    public int longestConsecutive6(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }

        int max = 0;
        for (int num : nums) {
            if (!set.contains(num - 1)) {
                int count = 0;
                while (set.contains(num)) {
                    count++;
                    num += 1;
                }

                max = Math.max(max, count);
            }
        }
        return max;

    }

    public int longestConsecutive7(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }

        int max = 0;
        for (int num : nums) {
            // 不包含前一个
            if (!set.contains(num - 1)) {
                int count = 0;
                while (set.contains(num)) {
                    count++;
                    num += 1;
                }
                max = Math.max(max, count);
            }

        }
        return max;


    }


}