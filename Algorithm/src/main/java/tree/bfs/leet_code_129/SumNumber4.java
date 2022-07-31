package tree.bfs.leet_code_129;

import tree.TreeNode;

/**
 * @author : dev
 * @version :
 * @Date :  2022/7/31 20:17
 * @Desc :
 */
public class SumNumber4 {

    public int sumNumbers(TreeNode root) {
        return help(root, 0);
    }

    private int help(TreeNode root, int sum) {
        if (root == null) {
            return 0;
        }
        sum = sum * 10 + root.val;
        if (root.left == null && root.right == null) {
            return sum;
        }
        return help(root.left, sum) + help(root.right, sum);
    }
}
