package tree.leet_code_404;

import tree.TreeNode;

/**
 * @author :  dev
 * @version :
 * @Date :   2021/10/8 23:08
 * @Url : https://leetcode-cn.com/problems/sum-of-left-leaves/
 * @Level :  easy  medium hard
 * @Desc :
 * @Counter :
 * @Answer :  https://leetcode-cn.com/problems/sum-of-left-leaves/solution/chao-ji-rong-yi-li-jie-qi-shi-he-qiu-quan-lu-jing-/
 */
public class SumOfLeftLeaves {
    public int sumOfLeftLeaves(TreeNode root) {
        int[] sum = {0};
        getSum(root, sum, false);
        return sum[0];
    }

    private int getSum(TreeNode root, int[] sum, boolean left) {
        if (root != null) {
            if (left && root.left == null && root.right == null) {
                sum[0] += root.val;
            }
            getSum(root.left,sum,true);
            getSum(root.right,sum,false);

        }
        return 0;
    }


}
