package tree.leet_code_113;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

import tree.TreeNode;

/**
 * @author : dev
 * @version :
 * @Date :  2022/8/1 16:24
 * @Desc : 字节半年 9次：路径总和：https://leetcode-cn.com/problems/path-sum-ii/solution/
 */
public class PathSum4 {
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        Deque<Integer> path = new ArrayDeque<>();
        List<List<Integer>> res = new ArrayList<>();
        help(root, targetSum, path, res);
        return res;
    }

    private void help(TreeNode root, int targetSum, Deque<Integer> path, List<List<Integer>> res) {
        if (root == null) {
            return;
        }
        targetSum -= root.val;
        path.addLast(root.val);
        if (targetSum == 0 && root.left == null && root.right == null) {
            res.add(new ArrayList<>(path));
            path.removeLast();
            return;
        }
        help(root.left, targetSum, path, res);
        help(root.right, targetSum, path, res);
        path.removeLast();
    }
}
