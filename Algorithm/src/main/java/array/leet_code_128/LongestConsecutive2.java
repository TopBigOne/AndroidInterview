package array.leet_code_128;

import java.util.HashSet;

/**
 * @author : dev
 * @version :
 * @Date :  2022/8/3 19:25
 * @Desc :  128. 最长连续序列:https://leetcode.cn/problems/longest-consecutive-sequence/
 * <p>
 * 题解：https://www.youtube.com/watch?v=gLsE5iUgGBo
 */
public class LongestConsecutive2 {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        int res = 0;
        for (int num : nums) {
            int down = num - 1;
            while (set.contains(down)) {
                set.remove(down);
                down--;
            }
            int up = num + 1;
            while (set.contains(up)) {
                set.remove(up);
                up++;
            }
            res = Math.max(res, up - down - 1);
        }
        return res;
    }

    public int longestConsecutive2(int[] nums) {
        HashSet<Integer> set = new HashSet<>();

        for (int num : nums) {
            set.add(num);
        }
        int res = 0;
        for (int num : nums) {
            int down = num - 1;
            while (set.contains(down)) {
                set.remove(down);
                down--;
            }
            int up = num + 1;
            while (set.contains(up)) {
                set.remove(up);
                up++;
            }
            res = Math.max(res, up - down - 1);
        }
        return res;


    }
}
