package tree.leet_code_230;

import javax.sound.midi.Soundbank;

import tree.TreeNode;

/**
 * @author : dev
 * @version :
 * @Date :  8/2/21 11:24 PM
 * @Desc :  230. 二叉搜索树中第K小的元素 : nedium https://leetcode-cn.com/problems/kth-smallest-element-in-a-bst/solution/
 * 注意，这是二叉搜索树
 * 题解：https://leetcode-cn.com/problems/kth-smallest-element-in-a-bst/solution/xiang-xi-tong-su-de-si-lu-fen-xi-duo-jie-fa-by--48/
 */
public class KthSmallest {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.right = new TreeNode(6);
        root.right = new TreeNode(6);


        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(4);
        root.left.left.left = new TreeNode(1);

        KthSmallest kthSmallest = new KthSmallest();
        int result = kthSmallest.kthSmallest(root, 3);
        System.out.println("result : " + result);
    }

    int num = 0;
    int res;
    public int kthSmallest(TreeNode root, int k) {
        inorderSmallest(root, k);
        return res;
    }

    private void inorderSmallest(TreeNode root, int k) {
        if (root == null) {
            return;
        }
        inorderSmallest(root.left, k);
        num++;

        System.out.print(root.val+"-->");
        if (num == k) {
            res = root.val;
            return;
        }
        inorderSmallest(root.right, k);
    }
}
