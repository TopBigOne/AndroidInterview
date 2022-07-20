package tree.leet_code_513;

import tree.TreeNode;

/**
 * @author : dev
 * @version :
 * @Date :  2022/7/20 05:56
 * @Desc :
 */
public class FindBottomLeftValue2 {
    int maxDeep = -1;
    int leftValue = 0;

    public int findBottomLeftValue(TreeNode root) {
        leftValue = root.val;
        findLeftValue(root, 0);
        return leftValue;
    }

    private void findLeftValue(TreeNode root, int deep) {
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null) {
            if (deep > maxDeep) {
                maxDeep = deep;
                leftValue = root.val;
            }
        }
        if (root.left != null) {
            findLeftValue(root.left, deep + 1);
        }
        if (root.right != null) {
            findLeftValue(root.right, deep + 1);
        }

    }
}
