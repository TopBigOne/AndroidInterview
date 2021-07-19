package tree.leet_code_124;

import org.omg.CORBA.INTERNAL;

import tree.TreeNode;

/**
 * @author : dev
 * @version :
 * @Date :  2021/5/28 17:53
 * @Desc : 快手一面
 * 求打印出路径来
 */
public class MaxPathSum3 {
    int max = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        dfs(root);
        return max;
    }

    public int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }
        // 计算左分支的最大值，做分支如果为负数，还不如不做选择
        int leftMax = Math.max(0, dfs(root.left));
        // 计算右分支最大值
        int rightMax = Math.max(0, dfs(root.right));
        max = Math.max(max, root.val + leftMax + rightMax);
        return root.val + Math.max(leftMax, rightMax);
    }

    public int dfs2(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int leftMax = Math.max(0, dfs(root.left));
        int rightMax = Math.max(0, dfs(root.right));
        max = Math.max(max, root.val + leftMax + rightMax);
        return root.val + Math.max(leftMax, rightMax);

    }


}
