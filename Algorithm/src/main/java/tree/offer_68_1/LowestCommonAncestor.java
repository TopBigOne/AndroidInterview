package tree.offer_68_1;

import tree.TreeNode;

/**
 * @author : dev
 * @version :
 * @Date :  2022/6/10 16:22
 * @Desc : Offer 68 - I. 二叉搜索树的最近公共祖先
 * https://leetcode.cn/problems/er-cha-sou-suo-shu-de-zui-jin-gong-gong-zu-xian-lcof/
 *
 * 题解：https://leetcode.cn/problems/er-cha-sou-suo-shu-de-zui-jin-gong-gong-zu-xian-lcof/solution/mian-shi-ti-68-i-er-cha-sou-suo-shu-de-zui-jin-g-7/
 */
public class LowestCommonAncestor {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        while (root != null) {
            int rootVal = root.val;
            if (p.val < rootVal && q.val < rootVal) {
                root = root.left;
            } else if (p.val > rootVal && q.val > rootVal) {
                root = root.right;
            } else {
                break;
            }
        }
        return root;


    }
}
