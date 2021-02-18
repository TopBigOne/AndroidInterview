package tree.leet_code_100;

import java.util.Objects;

import tree.TreeNode;

/**
 * @author : dev
 * @version :
 * @Date :  2/18/21 10:54 PM
 * @Desc :相同的树（https://leetcode-cn.com/problems/same-tree/）
 */
public class IsSameTree {
    public boolean isSameTree1(TreeNode p, TreeNode q) {
        if (p == null && q == null) return true;
        if (p == null || q == null) return false;
        if (!Objects.equals(p.val, q.val)) return false;
        return isSameTree1(p.left, q.left) && isSameTree1(p.right, q.right);
    }

    public boolean isSameTree2(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        if (p == null || q == null) {
            return false;
        }
        if (!Objects.equals(p.val, q.val)) return false;
        return isSameTree2(p.left, q.left) && isSameTree2(q.right, p.right);
    }


}
