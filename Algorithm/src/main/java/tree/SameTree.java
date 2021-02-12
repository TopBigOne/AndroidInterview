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

    public boolean isSameTree(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) {
            return true;
        }
        if (root1 == null || root2 == null) {
            return false;
        }
        if (!root1.val.equals(root2.val)) {
            return false;
        }
        // 卧槽，，全是递归，，
        return isSameTree(root1.left, root2.right) && isSameTree(root1.right, root2.right);

    }
}
