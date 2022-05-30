package tree.offer_26;

import tree.TreeNode;

/**
 * @author : dev
 * @version :
 * @Date :  2022/5/29 14:51
 * @Desc :
 * https://leetcode.cn/problems/shu-de-zi-jie-gou-lcof/solution/yi-pian-wen-zhang-dai-ni-chi-tou-dui-che-uhgs/
 */
public class IsSubStructure3 {


    public boolean isSubStructure(TreeNode A, TreeNode B) {
        if (A == null || B == null) {
            return false;
        }
        boolean result = false;
        if (A.val == B.val) {
            // 从顶点出发
            result = isAContainB(A, B);
        }

        // 若是依旧没有得到结果;
        // case 1: 遍历A的左子树
        if (!result) {
            result = isSubStructure(A.left, B);
        }
        // case 2: 遍历A的右子树
        if (!result) {
            result = isSubStructure(A.right, B);

        }
        return result;
    }

    private boolean isAContainB(TreeNode a, TreeNode b) {
        if (b == null) {
            return true;
        }
        if (a == null || a.val != b.val) {
            return false;
        }

        // a 和b的左子树一样，a和b的右子树，也要一样
        return isAContainB(a.left, b.left) && isAContainB(a.right, b.right);
    }


}
