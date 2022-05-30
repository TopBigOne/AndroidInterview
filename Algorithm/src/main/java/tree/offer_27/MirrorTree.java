package tree.offer_27;

import tree.TreeNode;

/**
 * @author : dev
 * @version :
 * @Date :  2022/5/29 17:25
 * @Desc :
 * 题解：https://leetcode.cn/problems/er-cha-shu-de-jing-xiang-lcof/solution/mian-shi-ti-27-er-cha-shu-de-jing-xiang-di-gui-fu-/
 */
public class MirrorTree {
    public TreeNode mirrorTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        // 找到这颗树的最右边的右子树
        TreeNode leftRoot = mirrorTree(root.right);
        // 找到这颗树的最左边的左子树
        TreeNode rightRoot = mirrorTree(root.left);
        root.left = leftRoot;
        root.right = rightRoot;
        return root;
    }

}
