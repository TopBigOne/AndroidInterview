package tree.bfs.leet_code_129;

import tree.TreeNode;

/**
 * @author :  dev
 * @version :
 * @Date :  2021/6/8 12:09
 * @Url :
 * @Level : easy medium hard
 * @Desc : leetcode :求二叉树的根节数字之和： https://leetcode-cn.com/problems/sum-root-to-leaf-numbers/submissions/
 * @Counter : 10
 * @Answer :
 * https://leetcode-cn.com/problems/sum-root-to-leaf-numbers/solution/0-ms-jiao-ke-shu-ji-jie-da-by-liuzhaoce/
 */
public class SumNumber {
    public static void main(String[] args) {
        TreeNode head = new TreeNode(4);
        head.left = new TreeNode(9);

        head.left.left = new TreeNode(5);
        head.left.right = new TreeNode(1);

        head.right = new TreeNode(0);
        SumNumber sumNumber = new SumNumber();

        int result = sumNumber.sumNumbers(head);
        System.out.println(result);


    }

    public int sumNumbers(TreeNode root) {
        return help(root, 0);
    }

    public int help(TreeNode root, int i) {
        if (root == null) {
            return 0;
        }
        int temp = i * 10 + root.val;
        if (root.left == null && root.right == null) {
            return temp;
        }
        return help(root.left, temp) + help(root.right, temp);
    }


}
