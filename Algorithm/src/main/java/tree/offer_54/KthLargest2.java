package tree.offer_54;

import tree.TreeNode;

/**
 * @author : dev
 * @version :
 * @Date :  2022/6/7 16:25
 * @Desc :Offer 54. 二叉搜索树的第k大节点
 * NOTE： 二叉搜索树的中序遍历：得到是一个从小到大排列的节点
 *
 * https://leetcode.cn/problems/er-cha-sou-suo-shu-de-di-kda-jie-dian-lcof/solution/
 */
public class KthLargest2 {

    public int kthLargest(TreeNode root, int k) {
        int res = 0;
        dfs(root, k, res);
        return res;
    }

    private void dfs(TreeNode root, int k, int res) {
        if (root == null || k == 0) {
            return;
        }
        dfs(root.right, k, res);
        // 在if 条件语句里直接做的-- 操作
        if (--k == 0) {
            res = root.val;
            return;
        }
        dfs(root.left, k, res);
    }


}
