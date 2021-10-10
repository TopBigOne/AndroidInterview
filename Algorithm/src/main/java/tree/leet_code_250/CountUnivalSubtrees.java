package tree.leet_code_250;

import tree.TreeNode;

/**
 * @author : dev
 * @version :
 * @Date :  10/10/21 9:12 PM
 * @Desc :  统计同值子树  https://leetcode-cn.com/problems/count-univalue-subtrees/submissions/
 *
 *
 * 题解：https://leetcode-cn.com/problems/count-univalue-subtrees/solution/java-di-gui-by-npe_tle/
 */
public class CountUnivalSubtrees {
    private int ansCount = 0;
    private boolean isSame(TreeNode root) {
        if (root == null) {
            return true;
        }
        boolean isLeftOk = false;
        if (root.left == null || isSame(root.left) && root.val == root.left.val) {
            isLeftOk = true;
        }

        boolean isRightOk = false;
        if (root.right == null || isSame(root.right) && root.val == root.right.val) {
            isRightOk = true;
        }
        if (isLeftOk && isRightOk) {
            // 开始累加
            ansCount++;
            return true;
        }
        return false;

    }

    public int countUnivalSubtrees(TreeNode root) {
        isSame(root);
        return ansCount;
    }
}
