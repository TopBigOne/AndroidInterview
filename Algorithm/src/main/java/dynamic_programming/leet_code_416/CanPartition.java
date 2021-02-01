package dynamic_programming.leet_code_416;


import java.net.DatagramPacket;

import sun.misc.FpUtils;

/**
 * @author : dev
 * @version :
 * @Date :  2/1/21 11:38 PM
 * @Desc : 0-1 背包问题：
 */
public class CanPartition {
    /**
     * https://leetcode-cn.com/problems/partition-equal-subset-sum/solution/0-1-bei-bao-wen-ti-xiang-jie-zhen-dui-ben-ti-de-yo/
     * <p>
     * 执行用时：
     * 84 ms
     * , 在所有 Java 提交中击败了
     * 5.05%
     * 的用户
     * 内存消耗：
     * 39.2 MB
     * , 在所有 Java 提交中击败了
     * 24.95%
     * 的用户
     * <p>
     * 时间复杂度：O(NC)O(NC)：这里 NN 是数组元素的个数，CC 是数组元素的和的一半。
     * 空间复杂度：O(NC)O(NC)。
     *
     * @param nums
     * @return
     */
    public boolean canPartition1(int[] nums) {
        int len = nums.length;
        // 题目已经说非空数组，可以不做非空判断
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        // 特判：如果是奇数，就不符合要求
        if ((sum & 1) == 1) {
            return false;
        }

        int target = sum / 2;
        // 创建二维状态数组，行：物品索引，列：容量（包括 0）
        boolean[][] dp = new boolean[len][target + 1];

        // 先填表格第 0 行，第 1 个数只能让容积为它自己的背包恰好装满
        if (nums[0] <= target) {
            dp[0][nums[0]] = true;
        }
        // 再填表格后面几行
        for (int i = 1; i < len; i++) {
            for (int j = 0; j <= target; j++) {
                // 直接从上一行先把结果抄下来，然后再修正
                dp[i][j] = dp[i - 1][j];

                if (nums[i] == j) {
                    dp[i][j] = true;
                    continue;
                }
                if (nums[i] < j) {
                    dp[i][j] = dp[i - 1][j] || dp[i - 1][j - nums[i]];
                }
            }
        }
        return dp[len - 1][target];
    }

    /**
     * 执行用时：
     * 20 ms
     * , 在所有 Java 提交中击败了
     * 90.48%
     * 的用户
     * 内存消耗：
     * 38.1 MB
     * , 在所有 Java 提交中击败了
     * 63.04%
     * 的用户
     *
     * @param nums
     * @return
     */
    public boolean canPartition2(int[] nums) {
        int len = nums.length;
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if ((sum & 1) == 1) {
            return false;
        }

        int target = sum / 2;

        boolean[] dp = new boolean[target + 1];
        dp[0] = true;

        if (nums[0] <= target) {
            dp[nums[0]] = true;
        }
        for (int i = 1; i < len; i++) {
            for (int j = target; nums[i] <= j; j--) {
                if (dp[target]) {
                    return true;
                }
                dp[j] = dp[j] || dp[j - nums[i]];
            }
        }
        return dp[target];
    }

    public boolean canPartition3(int[] nums) {
        int len = nums.length;
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        // 判断奇偶
        if ((sum & 1) == 1) {
            return false;
        }
        int target = sum >> 1;
        boolean[] dp = new boolean[target + 1];
        dp[0] = true;
        if (nums[0] <= target) {
            int numsFirstValue = nums[0];
            dp[numsFirstValue] = true;
        }
        for (int i = 1; i < len; i++) {
            for (int j = target; nums[i] <= j; j--) {
                if (dp[target]) {
                    return true;
                }
                dp[j] = dp[j] || dp[j - nums[i]];
            }
        }
        return dp[target];

    }

    public boolean canPartition4(int[] nums) {
        int len = nums.length;
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        // 判断奇偶
        if ((sum & 1) == 1) {
            return false;
        }
        int target = sum >> 1;
        boolean[] dp = new boolean[target + 1];
        dp[0] = true;
        if (nums[0] <= target) {
            int numsFirstValue = nums[0];
            dp[numsFirstValue] = true;
        }
        // 开始 loop
        for (int i = 1; i < len
                ; i++) {
            // 倒序
            for (int j = target; nums[i] <= j; j--) {
                if (dp[target]) {
                    return true;
                }

                dp[j] = dp[j] || dp[j - nums[i]];
            }

        }
        return dp[target];
    }

    public boolean canPartition5(int[] nums) {
        int len = nums.length;
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if ((sum & 1) == 1) {
            return false;
        }
        int target = sum >> 1;
        boolean[] dp = new boolean[target + 1];
        dp[0] = true;
        int numsFirstValue = nums[0];
        if (numsFirstValue <= target) {
            dp[numsFirstValue] = true;
        }
        for (int i = 1; i < len; i++) {
            for (int j = target; nums[i] <= j; j--) {
                if (dp[target]) {
                    return true;
                }
                dp[j] = dp[j] || dp[j - nums[i]];
            }
        }
        return dp[target];
    }

    public boolean canPartition6(int[] nums) {
        int length = nums.length;
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if ((sum & 1) == 1) {
            return false;
        }
        int target = sum >> 1;
        boolean[] dp = new boolean[target + 1];
        dp[0] = true;
        int numsFirstValue = nums[0];
        if (numsFirstValue <= target) {
            dp[numsFirstValue] = true;
        }
        for (int i = 1; i < length; i++) {
            for (int j = target; nums[i] <= j; j--) {
                if (dp[target]) {
                    return true;
                }
                dp[j] = dp[j] || dp[j - nums[i]];
            }

        }
        return dp[target];
    }

    public boolean canPartition7(int[] nums) {
        int length = nums.length;
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if ((sum & 1) == 1) {
            return false;
        }
        int taret = sum >> 1;
        boolean[] dp = new boolean[taret + 1];
        dp[0] = true;
        int numsFirstValue = nums[0];
        if (numsFirstValue >= taret) {
            dp[numsFirstValue] = true;
        }
        for (int i = 1; i < length; i++) {
            for (int j = taret; nums[i] <= j; j--) {
                if (dp[taret]) {
                    return true;
                }
                dp[j] = dp[j] || dp[j - nums[i]];
            }
        }

        return dp[taret];
    }


    public boolean canPartition8(int[] nums) {
        int length = nums.length;
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }

        int target = sum >> 1;
        boolean[] dp = new boolean[target + 1];
        dp[0] = true;
        int numsFirstValue = nums[0];
        // 留意
        if (numsFirstValue <= target) {
            dp[numsFirstValue] = true;
        }
        for (int i = 1; i < length; i++) {
            for (int j = target; nums[i] <= j; j--) {
                if (dp[target]) {
                    return true;
                }
                dp[j] = dp[j] || dp[j - nums[i]];
            }
        }

        return dp[target];
    }


    public boolean canPartition9(int[] nums) {
        int length = nums.length;
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if ((sum & 1) == 1) {
            return false;
        }
        int target = sum >> 1;
        boolean[] dp = new boolean[target + 1];
        dp[0] = true;
        int numsFirstValue = nums[0];
        if (numsFirstValue <= target) {
            dp[numsFirstValue] = true;
        }
        for (int i = 1; i < length; i++) {
            for (int j = target; nums[i] <= j; j--) {
                if (dp[target]) {
                    return true;
                }
                dp[j] = dp[j] || dp[j - nums[i]];
            }

        }

        return dp[target];
    }


}
