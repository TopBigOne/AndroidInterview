package tree.leet_code_606;

import tree.TreeNode;

/**
 * @author :  dev
 * @version :
 * @Date :   2021/10/14 23:38
 * @Url :  https://leetcode-cn.com/problems/construct-string-from-binary-tree/
 * @Level :  easy
 * @Desc :
 * @Counter :
 * @Answer : https://leetcode-cn.com/problems/construct-string-from-binary-tree/solution/gen-ju-er-cha-shu-chuang-jian-zi-fu-chuan-by-leetc/
 */
public class Tree2str {
    /**
     * 递归
     * @param root
     * @return
     */
    public String tree2str(TreeNode root) {
        if (root == null)
            return "";
        if (root.left == null && root.right == null)
            return root.val + "";
        if (root.right == null)
            return root.val + "(" + tree2str(root.left) + ")";
        return root.val + "(" + tree2str(root.left) + ")(" + tree2str(root.right) + ")";
    }
}
