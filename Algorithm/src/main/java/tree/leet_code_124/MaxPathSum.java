package tree.leet_code_124;

import tree.TreeNode;

/**
 * @author : dev
 * @version :
 * @Date :  3/26/21 1:26 AM
 * @Desc : 二叉树中，  最大路径和（https://leetcode-cn.com/problems/binary-tree-maximum-path-sum/）
 * 字节半年25 次
 * <p>
 * 解题思路：https://leetcode-cn.com/problems/binary-tree-maximum-path-sum/solution/er-cha-shu-zhong-de-zui-da-lu-jing-he-by-ikaruga/
 */
public class MaxPathSum {
    int max = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        if (root == null) {
            return 0;
        }
        dfs(root);
        return max;

    }

    /**
     * 返回经过的单边分支最大和，即：Math.max(root,root+left,root+right);
     * @param root
     * @return
     */
    private int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }
        // 获取左边的最大值，左边分支如果为负数，还不如不选择；
        int leftMax = Math.max(0, dfs(root.left));

        // 计算右边分支最大值，右边分支如果为辅助
        int rightMax = Math.max(0, dfs(root.right));

        // left->root->right 作为路径与已经算过历史最大值比较
        max = Math.max(max, root.val + leftMax + rightMax);

        // 返回经root 的单边最大分支给当前 root 的父节点 计算使用
        return root.val + Math.max(leftMax, rightMax);

    }
}
