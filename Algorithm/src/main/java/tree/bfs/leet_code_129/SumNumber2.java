package tree.bfs.leet_code_129;

import tree.TreeNode;
import tree.TreeNodeFactory;
import tree.util.XYLog;

/**
 * @author : dev
 * @version :
 * @Date :  7/11/21 12:28 AM
 * @Desc :
 * 题解：
 * <p>
 * https://leetcode-cn.com/problems/sum-root-to-leaf-numbers/solution/0-ms-jiao-ke-shu-ji-jie-da-by-liuzhaoce/
 */
public class SumNumber2 {

    public static void main(String[] args) {
        TreeNode root = TreeNodeFactory.build("4,9,6,5,1");
        XYLog.d(root);

        SumNumber2  sumNumber2 = new SumNumber2();
        sumNumber2.help(root,0);

    }
    public int sumNumber(TreeNode root) {
        return help(root, 0);
    }

    private int help(TreeNode root, int i) {
        // corner base.
        if (root == null) {
            return 0;
        }
        // 通过计算 root 节点，得到的 value
        int temp = i * 10 + root.val;
        if (root.left == null && root.right == null) {
            return temp;
        }

        // 计算左子树和右子树的累加的结果
        //  help(root.left, temp)  想表达的是： newTemp = temp*10+ root.val
        return help(root.left, temp) + help(root.right, temp);

    }
}
