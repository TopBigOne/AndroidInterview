package tree.leet_code_572;

import tree.TreeNode;

/**
 * @author : dev
 * @version :
 * @Date :  2022/7/26 04:42
 * @Desc :  572. 另一棵树的子树 ：https://leetcode.cn/problems/subtree-of-another-tree/
 * 题解：https://leetcode.cn/problems/subtree-of-another-tree/solution/java-di-gui-ban-by-kelly2018/
 */
public class IsSubtree2 {
    /**
     * 首先判断一个树是否是另一棵树的子树
     *
     * @param s root
     * @param t subroot
     * @return
     */
    public boolean isSubtree(TreeNode s, TreeNode t) {
        if (t == null) {
            return true;
        }
        if (s == null) {
            return false;
        }
        // case 1: 在左子树中找t
        // case 2: 在右子树中找t
        // case 3: 从root 节点开始找t
        return isSubtree(s.left, t) || isSubtree(s.right, t) || isSameTree(s, t);
    }

    private boolean isSameTree(TreeNode s, TreeNode t) {
        if (s == null && t == null) {
            return true;
        }
        if (s == null || t == null) {
            return false;
        }
        if (s.val != t.val) {
            return false;
        }
        return isSameTree(s.left, t.left) && isSameTree(s.right, t.right);
    }


}
