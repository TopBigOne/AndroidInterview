package tree.leet_code_222;

import tree.TreeNode;

/**
 * @author :  dev
 * @version :
 * @Date :   2021/10/7 20:45
 * @Url :https://leetcode-cn.com/problems/count-complete-tree-nodes/
 * @Level :    medium
 * @Desc :
 * @Counter :
 * @Answer :
 */
public class CountNodes2 {
    public int countNodes(TreeNode root) {
        if (root == null) return 0;
        int leftLevel = countLevel(root.left);
        int rightLevel = countLevel(root.right);
        if (leftLevel == rightLevel) {
            return countNodes(root.right) + (1 << leftLevel);
        }
        return countNodes(root.left) + (1 << rightLevel);
    }

    private int countLevel(TreeNode root) {
        int result = 0;
        while (root != null) {
            result++;
            root = root.left;
        }
        return result;
    }
}
