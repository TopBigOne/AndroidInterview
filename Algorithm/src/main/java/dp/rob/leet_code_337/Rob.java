package dp.rob.leet_code_337;

import tree.TreeNode;

/**
 * @author :  dev
 * @version :
 * @Date :   2021/9/17 22:02
 * @Url : https://leetcode-cn.com/problems/house-robber-iii/
 * @Level :    medium
 * @Desc :  打家劫舍 III  在上次打劫完一条街道之后和一圈房屋后，小偷又发现了一个新的可行窃的地区。
 * 这个地区只有一个入口，我们称之为“根”。 除了“根”之外，每栋房子有且只有一个“父“房子与之相连。
 * 一番侦察之后，聪明的小偷意识到“这个地方的所有房屋的排列类似于一棵二叉树”。
 * 如果两个直接相连的房子在同一天晚上被打劫，房屋将自动报警。
 * @Counter :14
 * @Answer : https://leetcode-cn.com/problems/house-robber-iii/solution/san-chong-fang-fa-jie-jue-shu-xing-dong-tai-gui-hu/
 */
public class Rob {
    public int rob(TreeNode root) {
        int[] result = robInternal(root);
        return Math.max(result[0], result[1]);

    }

    public int[] robInternal(TreeNode root) {
        if (root == null) {
            return new int[2];
        }
        int[] result = new int[2];
        int[] left = robInternal(root.left);
        int[] right = robInternal(root.right);
        result[0] = Math.max(left[0], left[1] + Math.max(left[0], left[1]));
        result[1] = left[0] + right[0] + root.val;
        return result;
    }

}
