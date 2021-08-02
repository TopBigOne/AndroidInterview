package tree.leet_code_230;

import tree.TreeNode;

/**
 * @author : dev
 * @version :
 * @Date :  8/3/21 12:54 AM
 * @Desc : 230. 二叉搜索树中第K小的元素 : nedium https://leetcode-cn.com/problems/kth-smallest-element-in-a-bst/solution/
 */
public class KthSmallest2 {
    int num = 0;
    int res ;
    public int kthSmallest(TreeNode root, int k) {
        if (root == null) {
            return 0;
        }
        inorderSmalalest(root, k);
        return res;
    }

    private void inorderSmalalest(TreeNode root, int k) {
        if (root == null) {
            return;
        }
        inorderSmalalest(root.left, k);
        num++;
        if (num == k) {
            res = root.val;
            return;
        }
        inorderSmalalest(root.right, k);
    }

}
