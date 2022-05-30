package tree.offer_26;

import tree.TreeNode;

/**
 * @author : dev
 * @version :
 * @Date :  2022/5/29 16:41
 * @Desc :
 *
 * https://leetcode.cn/problems/shu-de-zi-jie-gou-lcof/solution/yi-pian-wen-zhang-dai-ni-chi-tou-dui-che-uhgs/
 */
public class IsSubStructure4 {

    public boolean isSubStructure(TreeNode A, TreeNode B) {
        if (A == null || B == null) {
            return false;
        }
        return isSub(A, B) || isSubStructure(A.left, B) || isSubStructure(A.right, B);

    }

    private boolean isSub(TreeNode a, TreeNode b) {
        if (b == null) {
            return true;
        }
        if (a == null || a.val != b.val) {
            return false;
        }
        return isSub(a.left, b.left) && isSub(a.right, b.right);
    }

}
