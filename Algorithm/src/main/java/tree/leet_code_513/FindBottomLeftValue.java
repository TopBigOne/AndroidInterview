package tree.leet_code_513;

import tree.TreeNode;

/**
 * @author : dev
 * @version :
 * @Date :  2022/7/17 23:45
 * @Desc : 513. 找树左下角的值
 * https://leetcode.cn/problems/find-bottom-left-tree-value/solution/dai-ma-sui-xiang-lu-dai-ni-xue-tou-er-ch-w3og/
 * https://programmercarl.com/%E4%BA%8C%E5%8F%89%E6%A0%91%E7%90%86%E8%AE%BA%E5%9F%BA%E7%A1%80.html#%E4%BA%8C%E5%8F%89%E6%A0%91%E7%9A%84%E9%81%8D%E5%8E%86%E6%96%B9%E5%BC%8F
 */
public class FindBottomLeftValue {
    private int maxDeep = -1;
    private int value = 0;

    public int findBottomLeftValue(TreeNode root) {
        //  pre_order :m-->l--->r
        //  mid_order : l--->m-->r
        // post_order : l-->r-->m
        value = root.val;
        findLeftValue(root, 0);
        return value;
    }


    /**
     * 前序遍历
     * @param root
     * @param deep
     */
    private void findLeftValue(TreeNode root, int deep) {
        if (root == null) {
            return;
        }
        //
        if (root.left == null && root.right == null) {
            if (deep > maxDeep) {
                value = root.val;
                maxDeep = deep;
            }
        }

        if (root.left != null) {
            findLeftValue(root.left, deep + 1);
        }

        if (root.right != null) {
            findLeftValue(root.right, deep + 1);
        }
    }


}
