package tree;


/**
 * @author : dev
 * @version :
 * @Date :  2/12/21 9:17 PM
 * @Desc : 如何判断两颗树 是否相等？
 */
public class SameTree {

    public static void main(String[] args) {

    }

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
}
