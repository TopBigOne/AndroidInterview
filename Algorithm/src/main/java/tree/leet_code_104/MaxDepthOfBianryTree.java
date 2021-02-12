package tree.leet_code_104;

import tree.TreeNode;

/**
 * @author : dev
 * @version :
 * @Date :  2/12/21 3:07 PM
 * @Desc : 二叉树的最大深度（https://leetcode-cn.com/problems/maximum-depth-of-binary-tree/）
 * 考察深度优先搜索
 * <p>
 * 给定一个二叉树，找出其最大深度。
 * <p>
 * 二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。
 * <p>
 * 说明: 叶子节点是指没有子节点的节点。
 * <p>
 * 示例：
 * 给定二叉树 [3,9,20,null,null,15,7]，
 * <p>
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * 返回它的最大深度 3 。
 */
public class MaxDepthOfBianryTree {
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left != null) {
           // System.out.println("leftDepth value:" + root.left.val);
        }


        int leftDepth = maxDepth(root.left);

        if (root.right != null) {
            System.out.println("rightDepth value:" + root.right.val);
        }
        int rightDepth = maxDepth(root.right);

        return Math.max(leftDepth, rightDepth) + 1;
    }

    public int maxDepth2(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        return Math.max(left, right) + 1;
    }

}
