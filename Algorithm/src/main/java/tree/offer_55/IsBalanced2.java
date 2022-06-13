package tree.offer_55;

import tree.TreeNode;

/**
 * @author : dev
 * @version :
 * @Date :  2022/6/9 17:59
 * @Desc :剑指 Offer 55 - II. 平衡二叉树
 * https://leetcode.cn/problems/ping-heng-er-cha-shu-lcof/
 */
public class IsBalanced2 {

    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        boolean leftStatus = isBalanced(root.left);
        boolean rightStatus = isBalanced(root.right);
        boolean currStatus = Math.abs(depth(root.left) - depth(root.right)) <= 1;

        return currStatus && leftStatus && rightStatus;
    }

    private int depth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(depth(root.left), depth(root.right)) + 1;
    }

}
