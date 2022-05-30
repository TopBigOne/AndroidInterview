package tree.leet_code_965;

import tree.TreeNode;
import tree.TreeNodeFactory;

/**
 * @author : dev
 * @version :
 * @Date :  2022/5/24 16:51
 * @Desc : 单值 二叉树
 */
public class IsUnivalTree {

    public static void main(String[] args) {
        Integer[] num = {2, 2, 2, 5, 2};
        TreeNode root = TreeNodeFactory.build(num);
        IsUnivalTree univalTree = new IsUnivalTree();
        boolean result = univalTree.isUnivalTree(root);
        System.out.println("result : " + result);
    }

    public boolean isUnivalTree(TreeNode root) {
        if (root == null) {
            return true;
        }
        return helper(root, root.val);
    }

    private boolean helper(TreeNode root, int rootValue) {
        if (root == null) {
            return true;
        }
        if (root.val != rootValue) {
            System.out.println("出现了不相等");
            return false;
        }
        System.out.println("走到了最后");
        return helper(root.left, rootValue) && helper(root.right, rootValue);
    }

}
