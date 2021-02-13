package tree;


/**
 * @author : dev
 * @version :
 * @Date :  2/12/21 9:17 PM
 * @Desc : 对树的一些操作（源自付东来的算法小抄）
 */
public class OpreationTree {

    public static void main(String[] args) {

    }

    /**
     * 如何判断两颗树 是否相等？
     *
     * @param root
     * @return
     */
    public boolean isSameTree(TreeNode root) {
        return isSameTree(root, null, null);
    }

    public boolean isSameTree(TreeNode root, TreeNode min, TreeNode max) {
        if (root == null) {
            return true;
        }

        if (min != null && root.val <= min.val) {
            return false;
        }

        if (max.val != null && root.val >= max.val) {
            return false;
        }
        // 卧槽，，全是递归，，
        return isSameTree(root.left, min, root) && isSameTree(root.right, root, max);
    }

    /**
     * 在 bst 中查找一个树是否存在
     *
     * @param root
     * @param target
     * @return
     */
    public boolean isInBST(TreeNode root, int target) {
        if (root == null) {
            return false;
        }
        // 根节点就和 target 相等
        if (root.val == target) {
            return true;
        }
        // 递归框架，从左到右，借助系统的栈；
        if (target < root.val) {
            return isInBST(root.left, target);
        }
        return isInBST(root.right, target);
    }

    /**
     * 删除 bst 的某一个节点（https://leetcode-cn.com/problems/delete-node-in-a-bst/solution/chao-xiang-xi-zhu-shi-ji-bai-9951-9896-b-2dqs/）
     *
     * @param root
     * @param key
     * @return
     */
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) {
            return null;
        }
        if (root.val == key) {
            // 情景 1： A 恰好是末端节点，两个子节点都为空，那么它就可以立即退场了。
            // 情景 2： A 只有一个非空节点，那么他要让这个孩子接替自己的位置；
            if (root.left == null) {
                return root.right;
            }
            if (root.right == null) {
                return root.left;
            }
            // 情景 3： A 有 2 个节点，为了不破坏 BST 的性质，A 必须找打左子树中最大的那个节点，或者右子树中最小的那个几点来替代自己，
            //         我们就可以按照第二种方式，去找右子树中最小的那个节点来接替 待删除节点。
            // 获取右子树最小的节点来替换 待删除的节点
            TreeNode minNode = getMin(root.right);
            //
            root.val = minNode.val;
            root.right = deleteNode(root.right, minNode.val);
        } else if (root.val > key) {
            root.left = deleteNode(root.left, key);
        } else if (root.val < key) {
            root.right = deleteNode(root.right, key);
        }

        return root;
    }

    private TreeNode getMin(TreeNode node) {
        // bst 最左的那个就是最小的
        while (node.left != null) {
            node = node.left;
        }
        return node;


    }


}
