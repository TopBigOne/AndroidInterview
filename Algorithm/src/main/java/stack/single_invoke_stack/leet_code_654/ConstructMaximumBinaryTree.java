package stack.single_invoke_stack.leet_code_654;

import tree.TreeNode;

/**
 * @author :  dev
 * @version :
 * @Date :   2021/9/23 23:37
 * @Url :  https://leetcode-cn.com/problems/maximum-binary-tree/
 * @Level :    medium
 * @Desc :
 * @Counter :  3
 * @Answer :  https://leetcode-cn.com/problems/maximum-binary-tree/solution/zui-da-er-cha-shu-by-leetcode/
 */
public class ConstructMaximumBinaryTree {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return help(nums, 0, nums.length);
    }

    private TreeNode help(int[] nums, int l, int r) {
        if (l == r) {
            return null;
        }
        int maxIndex = max(nums, l, r);
        TreeNode root = new TreeNode(nums[maxIndex]);
        root.left = help(nums, l, maxIndex);
        root.right = help(nums, maxIndex + 1, r);
        return root;
    }

    public int max(int[] nums, int l, int r) {
        int maxIndex = l;
        for (int i = l; i < r; i++) {
            if (nums[maxIndex] < nums[i]) {
                maxIndex = i;
            }
        }
        return maxIndex;
    }
}
