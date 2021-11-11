package dp.leet_code_403;

import java.util.HashMap;
import java.util.Map;

/**
 * @author :  dev
 * @version :
 * @Date :   2021/11/11 23:25
 * @Url : https://leetcode-cn.com/problems/frog-jump/
 * @Level :     hard
 * @Desc : 一只青蛙想要过河。 假定河流被等分为若干个单元格，并且在每一个单元格内都有可能放有一块石子（也有可能没有）。 青蛙可以跳上石子，但是不可以跳入水中。
 * <p>
 * 给你石子的位置列表 stones（用单元格序号 升序 表示）， 请判定青蛙能否成功过河（即能否在最后一步跳至最后一块石子上）。
 * <p>
 * 开始时， 青蛙默认已站在第一块石子上，并可以假定它第一步只能跳跃一个单位（即只能从单元格 1 跳至单元格 2 ）。
 * <p>
 * 如果青蛙上一步跳跃了 k 个单位，那么它接下来的跳跃距离只能选择为 k - 1、k 或 k + 1 个单位。 另请注意，青蛙只能向前方（终点的方向）跳跃。
 * @Counter : 2
 * @Answer : https://leetcode-cn.com/problems/frog-jump/solution/gong-shui-san-xie-yi-ti-duo-jie-jiang-di-74fw/
 */
public class CanCross {
    Map<Integer, Integer> map = new HashMap<>();
    public boolean canCross(int[] ss) {
        int length = ss.length;
        for (int i = 0; i < length; i++) {
            map.put(ss[i], i);
        }
        // check first step ....
        if (!map.containsKey(1)) {
            return false;
        }
        return dfs(ss, length, 1, 1);
    }

    /**
     * @param ss     石头
     * @param length 长度
     * @param u      当前石头所在的下标
     * @param k      上一次是经过多少步 跳到当前位置的
     * @return 是否能跳到最后一块石头
     */
    private boolean dfs(int[] ss, int length, int u, int k) {
        if (u == length - 1) return true;
        for (int i = -1; i <= 1; i++) {
            // 如果原地踏步的话，直接跳过
            if (k + i == 0) continue;
            // 下一步的石头理论编号
            int next = ss[u] + k + i;
            // 如果存在下一步的石头，则跳转到下一步石头，并DFS 下去
            if (map.containsKey(next)) {
                boolean cur = dfs(ss, length, map.get(next), k + i);
                if (cur) {
                    return true;
                }
            }
        }
        return false;
    }


}
