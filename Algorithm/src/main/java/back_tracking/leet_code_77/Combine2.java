package back_tracking.leet_code_77;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @author : dev
 * @version :
 * @Url : https://leetcode-cn.com/problems/combinations/
 * @Date :  12/20/21 9:09 PM
 * @Desc :
 */
public class Combine2 {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        if (k <= 0 || n < k) {
            return res;
        }
        Deque<Integer> path = new ArrayDeque<>();
        dfs(n, k, 1, path, res);
        return res;

    }

    /**
     * @param n     边界 n，是不变的额；
     * @param k     k，范围，是不变的；
     * @param begin ，与 n 组成遍历的 起始点[begin , n],所以 begin 是逐渐变大的，且不会大于 n
     * @param path  存储每次遍历获取的 value；
     * @param res   储存 path 的值
     */
    private void dfs(int n, int k, int begin, Deque<Integer> path, List<List<Integer>> res) {
        // 递归终止的条件
        if (path.size() == k) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = begin; i <= n; i++) {
            // 向路径中添加一个数
            path.addLast(i);
            // 进行下一轮循环
            dfs(n, k, i + 1, path, res);
            // 剪枝条操作，防止添加重复的元素
            path.removeLast();

        }

    }


}
