package tree.leet_code_701;

import tree.TreeNode;

/**
 * @author : dev
 * @version :
 * @Date :  9/2/21 10:54 PM
 * @Desc : https://leetcode-cn.com/problems/insert-into-a-binary-search-tree/solution/2-de-cha-ru-by-sweetiee/
 */
public class InsertIntoBST2 {

    /**
     * 递归解法：
     * 如果 root 是空，则新建树节点作为根节点返回即可。
     * 否则比较 root.val 与目标值的大小关系：
     * 如果 root.val 大于目标值，说明目标值应当插入 root 的左子树中，问题变为了在 root.left 中插入目标值，递归调用当前函数；
     * 如果 root.val 小于目标值，说明目标值应当插入 root 的右子树中，问题变为了在 root.right 中插入目标值，递归调用当前函数。
     *
     * @param root
     * @param val
     * @return
     */
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null) {
            return new TreeNode(val);
        }
        if (val > root.val) {
            root.right = insertIntoBST(root.right, val);
        } else {
            root.left = insertIntoBST(root.left, val);
        }
        return root;
    }
}
