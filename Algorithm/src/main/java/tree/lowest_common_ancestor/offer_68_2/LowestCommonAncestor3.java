package tree.lowest_common_ancestor.offer_68_2;

import tree.TreeNode;

/**
 * @author : dev
 * @version :
 * @Date :  2022/7/3 20:33
 * @Desc :
 */
public class LowestCommonAncestor3 {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }
        if (root == p || root == q) {
            return root;
        }

        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (left == null) {
            return right;
        }
        if (right == null) {
          return   left;
        }
        return root;
    }
}
