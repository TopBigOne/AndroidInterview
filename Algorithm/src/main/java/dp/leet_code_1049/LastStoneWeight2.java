package dp.leet_code_1049;

/**
 * @author : dev
 * @version :
 * @Date :  2/7/21 11:38 PM
 * @Desc : https://leetcode-cn.com/problems/last-stone-weight-ii/
 * <p>
 * 有一堆石头，每块石头的重量都是正整数。
 * <p>
 * 每一回合，从中选出任意两块石头，然后将它们一起粉碎。假设石头的重量分别为 x 和 y，且 x <= y。那么粉碎的可能结果如下：
 * <p>
 * 如果 x == y，那么两块石头都会被完全粉碎；
 * 如果 x != y，那么重量为 x 的石头将会完全粉碎，而重量为 y 的石头新重量为 y-x。
 * 最后，最多只会剩下一块石头。返回此石头最小的可能重量。如果没有石头剩下，就返回 0。
 * <p>
 *  
 * <p>
 * 示例：
 * <p>
 * 输入：[2,7,4,1,8,1]
 * 输出：1
 * 解释：
 * 组合 2 和 4，得到 2，所以数组转化为 [2,7,1,8,1]，
 * 组合 7 和 8，得到 1，所以数组转化为 [2,1,1,1]，
 * 组合 2 和 1，得到 1，所以数组转化为 [1,1,1]，
 * 组合 1 和 1，得到 0，所以数组转化为 [1]，这就是最优值。
 * <p>
 * https://leetcode-cn.com/problems/last-stone-weight-ii/solution/dong-tai-gui-hua-jie-zui-hou-yi-kuai-shi-tou-de-zh/
 */
public class LastStoneWeight2 {

    public int lastStoneWeight1(int[] stones) {
        int sum = 0;
        for (int st : stones)
            sum += st;
        for (int i = (sum >> 1); ; i--) {
            if (helper(stones, 0, 0, i))
                return sum - 2 * i;
        }
    }

    /**
     * 太难理解了，
     *
     * @param nums
     * @param idx
     * @param sum
     * @param target
     * @return
     */
    boolean helper(int[] nums, int idx, int sum, int target) {
        if (sum == target)
            return true;
        if (sum > target)
            return false;
        if (idx == nums.length)
            return false;
        return helper(nums, idx + 1, sum + nums[idx], target) || helper(nums, idx + 1, sum, target);

    }

    public int lastStoneWeight2(int[] stones) {
        //  int n = stones.length;
        int sum = 0;
        for (int stone : stones) sum += stone;
        int m = sum >> 1;
        int[] dp = new int[m + 1];
        for (int currStone : stones) {
            for (int j = m; j >= currStone; j--) {
                dp[j] = Math.max(dp[j], dp[j - currStone] + currStone);
            }
        }
        return sum - 2 * dp[m];
    }

    public int lastStoneWeight3(int[] stones) {
        //  int n = stones.length;
        int sum = 0;
        // 石头的总重量
        for (int stone : stones) {
            sum += stone;
        }

        int target = sum >> 1;
        int[] dp = new int[target + 1];
        for (int curStone : stones) {
            for (int i = target; i >= curStone; i--) {
                // dp 惯用的手法
                dp[i] = Math.max(dp[i], dp[i - curStone] + curStone);
            }
        }
        return sum - 2 * dp[target];
    }

    public int lastStoneWeight4(int[] stones) {
        // int n = stones.length;
        int sum = 0;
        for (int stone : stones) {
            sum += stone;
        }
        int target = sum >> 1;
        int[] dp = new int[target + 1];
        for (int stone : stones) {
            for (int i = target; i >= stone; i--) {
                dp[i] = Math.max(dp[i], dp[i - stone] + stone);
            }
        }
        return sum - 2 * dp[target];

    }


    public int lastStoneWeight5(int[] stones) {
        int sum = 0;
        for (int stone : stones) {
            sum += stone;
        }
        int target = sum >> 1;
        int[] dp = new int[target + 1];
        for (int stone : stones) {
            for (int i = target; i >= stone; i--) {
                dp[i] = Math.max(dp[i], dp[i - stone] + stone);
            }
        }
        return sum - (dp[target] << 1);
    }

    public int lastStoneWeight6(int[] stones) {
        int sum = 0;
        for (int stone : stones) {
            sum += stone;
        }
        int target = sum >> 1;
        int[] dp = new int[target + 1];
        for (int stone : stones) {
            for (int i = target; i >= stone; i--) {
                dp[i] = Math.max(dp[i], dp[i - stone] + stone);
            }
        }

        return sum - (dp[target] << 1);

    }

    public int lastStoneWight7(int[] stones) {
        int sum = 0;
        for (int stone : stones) sum += stone;
        int target = sum >> 1;
        int[] dp = new int[target + 1];
        for (int stone : stones) {
            for (int i = target; i >= stone; i--) {
                dp[i] = Math.max(dp[i], dp[i - stone] + stone);
            }
        }
        return sum - (dp[target] << 1);
    }

    public int lastStoneWight8(int[] stones) {
        int sum = 0;
        for (int stone : stones) {
            sum += stone;
        }
        int target = sum >> 1;
        int[] dp = new int[target + 1];
        for (int stone : stones) {
            for (int i = target; i >= stone; i--) {
                dp[i] = Math.max(dp[i], dp[i - stone] + stone);
            }
        }
        return sum - (dp[target] << 1);
    }

    public int lastStoneWight9(int[] stones) {
        int sum = 0;
        for (int stone : stones) {
            sum += stone;
        }
        int target = sum >> 1;
        int[] dp = new int[target + 1];
        for (int stone : stones) {
            for (int i = target; i >= stone; i--) {
                dp[i] = Math.max(dp[i], dp[i - stone] + stone);
            }
        }
        return sum - (dp[target] << 1);
    }

    public int lastStoneWight10(int[] stones) {
        int sum = 0;
        for (int stone : stones) {
            sum += stone;
        }
        int target = sum >> 1;
        int[] dp = new int[target + 1];
        for (int stone : stones) {
            for (int i = target; i >= stone; i--) {
                dp[i] = Math.max(dp[i], dp[i - stone] + stone);
            }
        }

        return sum - (dp[target] << 1);
    }

    public int lastStoneWight11(int[] stones) {
        int sum = 0;
        for (int stone : stones) sum += stone;
        int target = sum >>1;
        int [] dp = new int[target+1];
        for (int stone : stones) {
            for(int i = target;i>=stone;i--){
                dp[i] = Math.max(dp[i],dp[i-stone]+stone);
             }
        }
        return sum-(dp[target]<<1);

    }


}
