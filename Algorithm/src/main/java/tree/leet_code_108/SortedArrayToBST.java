package tree.leet_code_108;

import tree.TreeNode;

/**
 * @author :  dev
 * @version :
 * @Date :   2021/10/1 16:49
 * @Url : https://leetcode-cn.com/problems/convert-sorted-array-to-binary-search-tree/
 * @Level :  easy
 * @Desc : 将有序数组转化为二叉搜索树
 * @Counter :  2
 * @Answer : https://leetcode-cn.com/problems/convert-sorted-array-to-binary-search-tree/solution/jian-dan-di-gui-bi-xu-miao-dong-by-sweetiee/
 * 题目拓展:  109. 有序链表转换二叉搜索树 将本题的数组换成了链表，做法完全一样，不过链表无法像数组一样直接索引到中间元素，链表找中间节点可以用快慢指针法，详见 876. 链表的中间结点。
 */
public class SortedArrayToBST {
    public TreeNode sortedArrayToBST(int[] nums) {
        return dfs(nums, 0, nums.length - 1);
    }

    private TreeNode dfs(int[] num, int low, int high) {
        if (low > high) {
            return null;
        }
        // 以升序数组的中间元素作为根节点root
        int mid = low + (high - low) / 2;
        TreeNode root = new TreeNode(num[mid]);
        root.left = dfs(num, low, mid - 1);
        root.right = dfs(num, mid + 1, high);
        return root;
    }
}
