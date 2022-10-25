package tree.dfs.leet_code_538;

import tree.TreeNode;

/**
 * @author :  dev
 * @version :
 * @Date :   2022/10/22 22:08
 * @Url : https://leetcode.cn/problems/convert-bst-to-greater-tree/description/?favorite=2cktkvj
 * @Level :    medium
 * @Desc :  538. 把二叉搜索树转换为累加树
 * @Counter :
 * @Answer :  https://leetcode.cn/problems/convert-bst-to-greater-tree/solutions/215216/yi-tao-quan-fa-shua-diao-nge-bian-li-shu-de-wen-5/?orderBy=most_votes
 */
public class ConvertBST {
    private int sum = 0;
    public TreeNode convertBST(TreeNode root) {
        dfs(root);
        return root;
    }

    /**
     * 中序遍历
     *
     * @param root
     */
    private void dfs(TreeNode root) {
        if (root == null) {
            return;
        }
        dfs(root.right);

        sum += root.val;
        root.val = sum;

        dfs(root.left);
    }

}


