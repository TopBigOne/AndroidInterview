package tree.leet_code_617;

import tree.TreeNode;

/**
 * @author : dev
 * @version :
 * @Date :  9/29/21 10:41 AM
 * @Desc :
 */
public class MergeTrees2 {
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if (t1 == null || t2 == null) {
            return t1 == null ? t2 : t1;
        }
        return dfs(t1, t2);

    }

    private TreeNode dfs(TreeNode t1, TreeNode t2) {
        if (t1 == null || t2 == null) {
            return t1 == null ? t2 : t1;
        }

        t1.val += t2.val;

        t1.left = dfs(t1.left, t2.left);
        t1.right = dfs(t1.right, t2.right);
        return t1;


    }


}
