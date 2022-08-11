package tree.bst.leet_code_958;

import java.util.LinkedList;

import tree.TreeNode;

/**
 * @author :  dev
 * @version :
 * @Date :  2021/6/11 23:10
 * @Url : 958. 二叉树的完全性检验 : https://leetcode-cn.com/problems/check-completeness-of-a-binary-tree/
 * @Level :  medium
 * @Desc : 958. 二叉树的完全性检验
 * @Counter :  3
 * @Answer :  https://leetcode-cn.com/problems/check-completeness-of-a-binary-tree/solution/ceng-xu-bian-li-by-dian-dao-de-hu-die-681d/
 */
public class IsCompleteTree {
    /***
     * 对于一个完全二叉树，层序遍历的过程中遇到第一个空节点之后不应该再出现非空节点
     * @param root node
     * @return result
     */
    public boolean isCompleteTree(TreeNode root) {
        if (root == null) {
            return false;
        }
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        boolean isLeftNull = false;
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (isLeftNull && node != null) {
                // result
                return false;
            }
            if (node == null) {
                isLeftNull = true;
                continue;
            }
            TreeNode l = node.left;
            TreeNode r = node.right;
            queue.offer(l);
            queue.offer(r);
        }

        return true;
    }

    public boolean isCompleteTree2(TreeNode root) {
        if (root == null) {
            return false;
        }
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        boolean isHadNull = false;
        while (!queue.isEmpty()) {
            TreeNode currNode = queue.poll();

            // 已经出现了为空的子树，就不能再出现为空的
            if (currNode != null && isHadNull) {
                return false;
            }
            if (currNode == null) {
                isHadNull = true;
                continue;
            }
            queue.offer(currNode.left);
            queue.offer(currNode.right);
        }
        return true;
    }

}
