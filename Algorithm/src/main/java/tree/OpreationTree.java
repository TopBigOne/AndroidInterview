package tree;


/**
 * @author : dev
 * @version :
 * @Date :  2/12/21 9:17 PM
 * @Desc : 对树的一些操作（源自付东来的算法小抄）
 */
public class OpreationTree {

    public static void main(String[] args) {

    }

    /**
     * 如何判断两颗树 是否相等？
     *
     * @param root
     * @return
     */
    public boolean isSameTree(TreeNode root) {
        return isSameTree(root, null, null);
    }

    public boolean isSameTree(TreeNode root, TreeNode min, TreeNode max) {
        if (root == null) {
            return true;
        }

        if (min != null && root.val <= min.val) {
            return false;
        }

        if (max.val != null && root.val >= max.val) {
            return false;
        }
        // 卧槽，，全是递归，，
        return isSameTree(root.left, min, root) && isSameTree(root.right, root, max);
    }

    /**
     * 在 bst 中查找一个树是否存在
     *
     * @param root
     * @param target
     * @return
     */
    public boolean isInBST(TreeNode root, int target) {
        if (root == null) {
            return false;
        }
        // 根节点就和 target 相等
        if (root.val == target) {
            return true;
        }
        // 递归框架，从左到右，借助系统的栈；
        if (target < root.val) {
            return isInBST(root.left, target);
        }
        return isInBST(root.right, target);
    }


}
