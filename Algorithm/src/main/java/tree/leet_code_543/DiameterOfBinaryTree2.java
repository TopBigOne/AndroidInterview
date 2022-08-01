package tree.leet_code_543;


import tree.TreeNode;

/**
 * @author : dev
 * @version :
 * @Date :  7/26/21 11:47 PM
 * @Desc : 二叉树的直径（）
 * 字节跳动，出现了11次
 * 给定一棵二叉树，你需要计算它的直径长度。一棵二叉树的直径长度是任意两个结点路径长度中的最大值。这条路径可能穿过也可能不穿过根结点；
 * 示例 :
 * 给定二叉树
 * 1
 * / \
 * 2   3
 * / \
 * 4   5
 * 返回 3, 它的长度是路径 [4,2,1,3] 或者 [5,2,1,3]。
 * 注意：两结点之间的路径长度是以它们之间边的数目表示。
 * <p>
 * https://www.bilibili.com/video/BV1CK4y1Y76h?from=search&seid=4264928347235070597
 * https://leetcode-cn.com/problems/diameter-of-binary-tree/solution/543java-0msdi-gui-xiang-jie-by-ustcyyw/
 * 首先，坑定是dfs的思路
 */
public class DiameterOfBinaryTree2 {
    int result = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        depth(root);
        return result;

    }

    private int depth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftDepth = depth(root.left);
        int rightDepth = depth(root.right);
        result = Math.max(result, leftDepth + rightDepth);
        return Math.max(leftDepth, rightDepth) + 1;

    }

}
