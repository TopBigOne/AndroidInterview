package array.leet_code_659;

import java.util.HashMap;
import java.util.Map;

/**
 * @author :  dev
 * @version :
 * @Date :   2021/10/2 22:08
 * @Url : https://leetcode-cn.com/problems/split-array-into-consecutive-subsequences/
 * @Level :    medium
 * @Desc : 分割数组为连续子序列: 给你一个按升序排序的整数数组 num（可能包含重复数字），请你将它们分割成一个或多个长度至少为 3 的子序列，
 * 其中每个子序列都由连续整数组成。
 * @Counter :
 * @Answer :
 */
public class IsPossible {
    /**
     * 贪心算法
     *
     * @param nums data
     * @return result
     */
    public boolean isPossible(int[] nums) {
        Map<Integer, Integer> countNum = new HashMap<>();
        for (int num : nums) {
            countNum.put(num, countNum.getOrDefault(num, 0) + 1);
        }
        // 定义一个哈希表记录最长子序列
        Map<Integer, Integer> tail = new HashMap<>();
        for (int num : nums) {
            int count = countNum.getOrDefault(num, 0);
            // 当前元素已经用完，直接跳过
            if (count <= 0) {
                continue;
            }
            // 前面还有数字，可以构成以num结尾的子序列
            if (tail.getOrDefault(num - 1, 0) > 0) {
                countNum.put(num, count - 1);
                // 覆盖当前最长的子序列
                tail.put(num - 1, tail.get(num - 1) - 1);
                // 当前以num结尾的子序列加1；
                tail.put(num, tail.getOrDefault(num, 0) + 1);
            } else if (countNum.getOrDefault(num + 1, 0) > 0
                    && countNum.getOrDefault(num + 2, 0) > 0) {
                countNum.put(num, count - 1);
                countNum.put(num + 1, countNum.get(num + 1) - 1);
                countNum.put(num + 2, countNum.get(num + 2) - 1);
                // 当前以num+2 结尾的子序列+1
                tail.put(num + 2, tail.getOrDefault(num + 2, 0) + 1);
            } else {
                // 前后不能构成子序列，直接返回false；
                return false;
            }
        }
        return true;
    }

    public boolean isPossiable2(int[] nums) {
        Map<Integer, Integer> countNum = new HashMap<>();
        for (int num : nums) {
            countNum.put(num, countNum.getOrDefault(num, 0) + 1);
        }
        // 定义一个哈希表记录最长子序列
        Map<Integer, Integer> tail = new HashMap<>();
        for (int num : nums) {
            int count = countNum.getOrDefault(num, 0);
            if (count <= 0) {
                continue;
            }
            if (tail.getOrDefault(num - 1, 0) > 0) {
                countNum.put(num, count - 1);
                tail.put(num - 1, tail.get(num - 1) - 1);
                tail.put(num, tail.getOrDefault(num, 0) + 1);
            } else if (countNum.getOrDefault(num + 1, 0) > 0
                    && countNum.getOrDefault(num + 2, 0) > 0) {
                countNum.put(num, count - 1);
                countNum.put(num + 1, countNum.get(num + 1) - 1);
                countNum.put(num + 2, countNum.get(num + 2) - 1);
                // 当前num+2，结尾子序列+1
                tail.put(num + 2, tail.getOrDefault(num + 2,0) + 1);
            } else {
                return false;
            }
        }
        return true;
    }
}
