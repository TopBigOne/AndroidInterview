package tree.leet_code_1022;

import tree.TreeNode;
import tree.TreeNodeFactory;
import tree.util.XYLog;

/**
 * @author : dev
 * @version :
 * @Date :  2022/5/30 20:34
 * @Desc :
 * https://leetcode.cn/problems/sum-of-root-to-leaf-binary-numbers/
 */
public class SumRootToLeaf {
    public static void main(String[] args) {
        Integer[] nums = {1, 0, 1, 0, 1, 0, 1};
        TreeNode treeNode = TreeNodeFactory.build(nums);
        XYLog.d(treeNode);

        SumRootToLeaf sumRootToLeaf = new SumRootToLeaf();
        sumRootToLeaf.sumRootToLeaf(treeNode);


    }

    public int sumRootToLeaf(TreeNode root) {
        return dfs(root, 0);
    }

    private int dfs(TreeNode root, int val) {
        if (root == null) {
            return 0;
        }
//        val = (val << 1) | root.val;
        val = (val << 1) + root.val;
        System.err.println("val : "+val);
        if (root.left == null && root.right == null) {
            return val;
        }

        return dfs(root.left, val) + dfs(root.right, val);
    }
}
