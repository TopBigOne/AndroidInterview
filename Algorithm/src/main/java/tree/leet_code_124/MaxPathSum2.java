package tree.leet_code_124;

import tree.TreeNode;

/**
 * @author : dev
 * @version :
 * @Date :  3/26/21 1:26 AM
 * @Desc : 二叉树中，  最大路径和（https://leetcode-cn.com/problems/binary-tree-maximum-path-sum/）
 * 字节半年25 次
 * <p>
 * 解题思路：https://leetcode-cn.com/problems/binary-tree-maximum-path-sum/solution/er-cha-shu-zhong-de-zui-da-lu-jing-he-by-ikaruga/
 */
public class MaxPathSum2 {

    int max = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {

        dfs(root);
        return  max;


    }


}
