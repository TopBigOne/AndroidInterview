package tree.offer_26;

import tree.TreeNode;

/**
 * @author :  dev
 * @version :
 * @Date :   2021/10/5 23:36
 * @Url :  https://leetcode-cn.com/problems/shu-de-zi-jie-gou-lcof/
 * @Level :    medium
 * @Desc : 树的子结构  ：  输入两棵二叉树A和B，判断B是不是A的子结构。(约定空树不是任意一个树的子结构)
 * B是A的子结构， 即 A中有出现和B相同的结构和节点值。
 * @Counter :
 * @Answer :  https://leetcode-cn.com/problems/shu-de-zi-jie-gou-lcof/solution/mian-shi-ti-26-shu-de-zi-jie-gou-xian-xu-bian-li-p/
 */
public class IsSubStructure {
    /**
     * B 树是不是A树的子树
     *
     * @param A
     * @param B
     * @return
     */
    public boolean isSubStructure(TreeNode A, TreeNode B) {
        return (A != null && B != null) && (recur(A, B)
                || isSubStructure(A.left, B)
                || isSubStructure(A.right, B)
        );
    }

    boolean recur(TreeNode A, TreeNode B) {
        if (B == null) {
            return true;
        }
        if (A == null || !A.val.equals(B.val)) {
            return false;
        }

        return recur(A.left, B.left) && recur(A.right, B.right);
    }


}
