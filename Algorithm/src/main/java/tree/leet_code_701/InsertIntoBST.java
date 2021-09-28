package tree.leet_code_701;

import javax.swing.plaf.nimbus.NimbusLookAndFeel;

import tree.TreeNode;

/**
 * @author : dev
 * @version :
 * @Date :  9/2/21 10:38 PM
 * @Desc :  https://leetcode-cn.com/problems/insert-into-a-binary-search-tree/
 * <p>
 * leet code 530
 * leet code 501
 * leet code 700
 * <p>
 * 二叉搜索树的平均深度是 \log nlogn，最坏情况是由于有序插入数据导致二叉搜索树退化成一条链表，此时深度是 nn。因此上述两种解法的平均时间复杂度是 O(\log n)O(logn)，最坏时间复杂度是 O(n)O(n)。迭代写法的空间复杂度是 O(1)O(1)，递归写法由于递归调用时会使用方法栈，而方法栈的深度就是二叉搜索树的深度，所以最坏空间复杂度是 O(n)O(n)。
 * <p>
 * 所以说，二叉搜索树的深度是非常影响查找/插入性能的，所以说并不常用，广泛使用的是平衡搜索树。常见的平衡搜索树有 红黑树，B- 树，B+ 树（还有 ACM/OI 大佬们爱的 treap，splay，SBT）等。比如 Java 里的 TreeMap，TreeSet 和 HashMap 中链表的树化都是用红黑树实现的，又比如 InnoDB 的索引存储就是 B+ 树实现的。感兴趣的同学可以去学习下～学成归来之时，可以问候别人——能不能心里有点 B 树～
 */
public class InsertIntoBST {

    /**
     *  迭代法：
     *  如果 root 是空，则新建树节点作为根节点返回即可。
     * 否则：
     * 初始化 cur 指向 root。
     * 比较 cur.val 与目标值的大小关系：
     * 如果 cur.val 大于目标值，说明目标值应当插入 cur 的左子树中，如果 cur.left 为 null，表明这是目标值可以插入的位置，直接插入并返回即可；否则 cur 指向 cur.left，重复步骤 2；
     * 如果 cur.val 小于目标值，说明目标值应当插入 cur 的右子树中。如果 cur.right 为 null，表明这是目标值可以插入的位置，直接插入并返回即可；否则 cur 指向 cur.right，重复步骤 2。
     *
     * @param root
     * @param val
     * @return
     */
    public TreeNode insertIntoBST(TreeNode root, int val) {
        TreeNode node = new TreeNode(val);
        if (root == null) {
            return node;
        }
        TreeNode curr = root;
        while (true) {
            // 往左边放
            if (curr.val > val) {
                if (curr.left == null) {
                    curr.left = node;
                    break;
                }
                curr = curr.left;

            } else {
                // 往右边放
                if (curr.right == null) {
                    curr.right = node;
                    break;
                }
                curr = curr.right;
            }
        }
        return root;

    }
}
