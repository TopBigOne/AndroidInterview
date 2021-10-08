package tree.leet_code_222;

import tree.TreeNode;

/**
 * @author :  dev
 * @version :
 * @Date :   2021/10/7 13:44
 * @Url :  https://leetcode-cn.com/problems/count-complete-tree-nodes/
 * @Level :    medium
 * @Desc :  给你一棵 完全二叉树 的根节点 root ，求出该树的节点个数
 * @Counter :
 * @Answer : https://leetcode-cn.com/problems/count-complete-tree-nodes/solution/chang-gui-jie-fa-he-ji-bai-100de-javajie-fa-by-xia/
 *
 */
public class CountNodes {

    /**
     * 递归解法
     *
     * @param root
     * @return
     */
    public int countNodes(TreeNode root) {
        return root == null ? 0 : countNodes(root.left) + countNodes(root.right) + 1;
    }

    /**
     * 移位运算
     *
     * @param root
     * @return
     */
    public int countNodes2(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int left = countLevel(root.left);
        int right = countLevel(root.right);
        if (left == right) {
            return countNodes2(root.right) + (1 << left);
        }
        return countNodes2(root.left) + (1 << right);
    }

    /**
     * 计算树的层数
     * @param root
     * @return
     */
    private int countLevel(TreeNode root) {
        int level = 0;
        while (root != null) {
            level++;
            root = root.left;
        }
        return level;
    }


}
