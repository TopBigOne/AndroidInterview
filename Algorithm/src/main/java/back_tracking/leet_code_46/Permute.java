package back_tracking.leet_code_46;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @author : dev
 * @version :
 * @Date :  2021/5/26 21:55
 * @Desc :  46. 全排列 leet code  46: 字节：43 次  全排列：https://leetcode-cn.com/problems/permutations/
 * 回溯算法入门；
 * 题解：https://leetcode-cn.com/problems/permutations/solution/hui-su-suan-fa-python-dai-ma-java-dai-ma-by-liweiw/
 */
public class Permute {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        int len;
        if (nums == null || (len = nums.length) == 0) {
            return result;
        }

        Deque<Integer> path = new ArrayDeque<>();
        // 不能重复
        boolean[] used = new boolean[len];

        dfs(nums, len, 0, path, used, result);
        return result;
    }

    /**
     * 回溯算法
     *
     * @param nums   输入的数组
     * @param len    数组的长度
     * @param depth  当前已经选择了几个数(表示当前递归到了第几层)
     * @param path   从根节点到任意节点的列表，已经选了哪些数字
     * @param used   保存了当前的数，是否被选择；
     * @param result
     */
    private void dfs(int[] nums, int len, int depth, Deque<Integer> path, boolean[] used, List<List<Integer>> result) {
        // 数字的个数已经选择够了
        if (depth == len) {
            // 添加对 path 的 copy
            result.add(new ArrayList<>(path));
            return;

        }

        for (int i = 0; i < len; i++) {
            // 如果当前的数，已经被使用过了，就跳过...
            if (used[i]) {
                continue;
            }

            //  没有被使用过，就添加到栈的末尾
            path.addLast(nums[i]);
            // 由于 i 这个树，已经使用过了，所以就要变成 true
            used[i] = true;
            // 递归的考虑到下一层
            dfs(nums,len,depth+1,path,used,result);
            // 回溯：回退操作
            path.removeLast();
            // 回退以后，就是没有使用过
            used[i] = false;
        }

    }

}
