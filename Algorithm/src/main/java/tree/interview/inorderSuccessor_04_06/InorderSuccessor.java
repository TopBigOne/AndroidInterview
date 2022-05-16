package tree.interview.inorderSuccessor_04_06;

import tree.TreeNode;

/**
 * @author : dev
 * @version :
 * @Date :  2022/5/16 16:29
 * @Desc :
 * <p>
 * https://leetcode.cn/problems/successor-lcci/
 */
public class InorderSuccessor {
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        if (root == null) {
            return null;
        }
        // 在右边找
        if (root.val <= p.val) {
            return inorderSuccessor(root.right, p);
        }
        TreeNode leftNode = inorderSuccessor(root.left, p);
        return leftNode == null ? root : leftNode;
    }


}
