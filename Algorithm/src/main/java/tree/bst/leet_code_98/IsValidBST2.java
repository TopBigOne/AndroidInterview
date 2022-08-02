package tree.bst.leet_code_98;

import tree.TreeNode;

/**
 * @author : dev
 * @version :
 * @Date :  2022/6/19 22:46
 * @Desc : BST 树
 * 题解：https://leetcode.cn/problems/validate-binary-search-tree/solution/zhong-xu-bian-li-qing-song-na-xia-bi-xu-miao-dong-/
 */
public class IsValidBST2 {
    long preVal = Long.MIN_VALUE;

    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }

        if (!isValidBST(root.left)) {
            return false;
        }
        if (root.val <= preVal) {
            return false;
        }
        preVal = root.val;

        return isValidBST(root.right);

    }
}
