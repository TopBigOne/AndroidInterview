package tree.leet_code_333;

import tree.TreeNode;

/**
 * @author :  dev
 * @version :
 * @Date :   2021/8/20 17:38
 * @Url :
 * @Level :    medium
 * @Desc :
 * @Counter :
 * @Answer :
 */
public class LargestBSTSubtree2 {
    private int res;
    private int preVal = Integer.MIN_VALUE;

    public int largestBSTSubtree(TreeNode root) {
        if (root == null) {
            return 0;
        }
        preVal = Integer.MIN_VALUE;
        // 判断是否为BST
        if (isBST(root)) {
            res = Math.max(res, getCount(root));
        }

        largestBSTSubtree(root.left);
        largestBSTSubtree(root.right);

        return res;
    }

    private boolean isBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        boolean leftFlag = isBST(root.left);
        if (preVal >= root.val) {
            return false;
        }
        preVal = root.val;
        boolean rightFlag = isBST(root.right);
        return leftFlag && rightFlag;

    }

    private int getCount(TreeNode root) {
        if (root == null) return 0;
        return getCount(root.left) + getCount(root.right) + 1;
    }


}
