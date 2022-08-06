package linked_list.leet_code_114;

import tree.TreeNode;

/**
 * @author : dev
 * @version :
 * @Date :  8/1/21 11:45 PM
 * @Desc : leet code 114 : 二叉树展开为链表 难度:中等: https://leetcode-cn.com/problems/flatten-binary-tree-to-linked-list/
 * 字节：7 次；
 * 题解：https://leetcode-cn.com/problems/flatten-binary-tree-to-linked-list/solution/xiang-xi-tong-su-de-si-lu-fen-xi-duo-jie-fa-by--26/
 */
public class Flatten {
    public void flatten(TreeNode root) {
        while (root != null) {
            //左子树为 null，直接考虑下一个节点
            if (root.left == null) {
                root = root.right;
                continue;
            }

            // 找左子树最右边的节点
            TreeNode pre = root.left;
            while (pre.right != null) {
                pre = pre.right;
            }
            //将原来的右子树接到左子树的最右边节点
            pre.right = root.right;
            // 将左子树插入到右子树的地方
            root.right = root.left;
            root.left = null;
            // 考虑下一个节点
            root = root.right;
        }

    }

    public void flatten2(TreeNode root) {
        while (root != null) {
            // 左子树为 null,直接考虑下一个节点
            if (root.left == null) {
                root = root.right;
                continue;
            }

            // 找打左子树最右边的节点
            TreeNode pre = root.left;
            while (pre.right != null) {
                pre = pre.right;
            }

            // 将原来的右子树接到左子树额最右边节点
            pre.right = root.right;
            // 将左子树插入到右子树的地方
            root.right = root.left;
            root.left = null;
            // 考虑下一个节点
            root = root.right;

        }
    }

    public void flatten3(TreeNode root) {
        while (root != null) {
            //1: 左子树为空，直接考虑下一个节点
            if (root.left == null) {
                root = root.right;
                continue;
            }

            // 找到左子树最右边的节点
            TreeNode pre = root.right;
            while (pre.right != null) {
                pre = pre.right;
            }

            pre.right = root.right;
            root.right = root.left;
            //  help GC;
            root.left = null;
            // 考虑下一个节点
            root = root.right;

        }
    }

    public void flatten4(TreeNode root) {
        while (root != null) {
            if (root.left == null) {
                root = root.right;
                continue;
            }

            // 左子树中，最右边的那个节点
            TreeNode pre = root.left;
            while (pre.right != null) {
                pre = pre.right;
            }

            pre.right = root.right;
            root.right = root.left;
            root.left = null;

            root = root.right;
        }

    }

}
