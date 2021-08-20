package tree.leet_code_333;

import tree.TreeNode;

/**
 * @author :  dev
 * @version :
 * @Date :   2021/8/20 17:05
 * @Url : https://leetcode-cn.com/problems/largest-bst-subtree/submissions/
 * @Level :    medium
 * @Desc :
 * @Counter : 2次
 * @Answer : 题解：https://leetcode-cn.com/problems/largest-bst-subtree/solution/java-di-gui-by-zxy0917-7/
 */
public class LargestBSTSubtree {
    int res = 0;
    int preVal = Integer.MIN_VALUE;

    /**
     * 1：dfs 判断树中所有的子树是否为BST，如果是BST 则计算该子树的节点个数，保存在结果变量中，取最大值即可。、
     * 2： 判断当前树是否为BST ：因为BST 中序遍历为升序，所以如果当前元素小于等于上一个元素，则返回false；
     *
     * @param root 节点
     * @return 结果
     */
    public int largestBSTSubtree(TreeNode root) {
        if (root == null) {
            return 0;
        }
        preVal = Integer.MIN_VALUE;
        if (isBST(root)) {
            res = Math.max(res, getCount(root));
        }
        largestBSTSubtree(root.left);
        largestBSTSubtree(root.right);
        return res;
    }

    private int getCount(TreeNode root) {
        if (root == null) return 0;
        return getCount(root.left) + getCount(root.right) + 1;
    }

    /**
     * 利用中序遍历的特性，BST的中序遍历，得到的value 是递增的。
     *
     * @param root
     * @return
     */
    private boolean isBST(TreeNode root) {
        if (root == null) {
            return true;
        }

        boolean leftFlag = isBST(root.left);
        // 上一个值大于或者等于当前值，就说明这个tree 不是BST；
        if (preVal >= root.val) {
            return false;
        }
        preVal = root.val;
        boolean rightFlag = isBST(root.right);

        return leftFlag && rightFlag;
    }
}
