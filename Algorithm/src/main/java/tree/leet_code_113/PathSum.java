package tree.leet_code_113;

import tree.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @author : dev
 * @version :
 * @Date :  2021/4/14 11:34
 * @Desc :  字节半年 9次：路径总和：https://leetcode-cn.com/problems/path-sum-ii/solution/
 * 题解：https://leetcode-cn.com/problems/path-sum-ii/solution/hui-su-suan-fa-shen-du-you-xian-bian-li-zhuang-tai/
 */
public class PathSum {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Deque<Integer> path = new ArrayDeque<>();
        pathSum(root, sum, path, res);
        return res;
    }

    private void pathSum(TreeNode root, int sum, Deque<Integer> path, List<List<Integer>> res) {
        // 递归终止条件，1：遇到空节点，
        if (root == null) {
            return;
        }
        sum -= root.val;
        path.add(root.val);
        // 递归终止条件，2：遇到叶子节点，sum 恰好为0，说明从根节点到叶子节点的路径是一个符合要求的解
        if (sum == 0 && root.left == null && root.right == null) {
            // path 全局只有一份，必须做拷贝
            res.add(new ArrayList<>(path));
            // 注意，这里return必须重置
            path.removeLast();
            return;
        }
        pathSum(root.left, sum, path, res);
        pathSum(root.right, sum, path, res);
        path.removeLast();

    }


}
