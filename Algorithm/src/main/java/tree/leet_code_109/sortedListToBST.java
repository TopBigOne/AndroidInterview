package tree.leet_code_109;

import linked_list.ListNode;
import tree.TreeNode;

/**
 * @author :  dev
 * @version :
 * @Date :   2021/10/1 19:46
 * @Url :  https://leetcode-cn.com/problems/convert-sorted-list-to-binary-search-tree/
 * @Level :    medium
 * @Desc :  有序链表转换二叉树  ：给定一个单链表，其中的元素按升序排序，将其转换为高度平衡的二叉搜索树。
 * <p>
 * 本题中，一个高度平衡二叉树是指一个二叉树每个节点的左右两个子树的高度差的绝对值不超过 1。
 * @Counter :
 * @Answer :  https://leetcode-cn.com/problems/convert-sorted-list-to-binary-search-tree/solution/shou-hua-tu-jie-san-chong-jie-fa-jie-zhu-shu-zu-ku/
 */
public class sortedListToBST {
    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) {
            return null;
        }
        if (head.next == null) {
            return new TreeNode(head.val);
        }
        // 快慢指针找中心点
        ListNode slow = head;
        ListNode fast = head;
        ListNode pre = null;

        while (fast != null && fast.next != null) {
            pre = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        pre.next = null;

        // 以升序链表的中间元素作为根节点root，递归的构建root 的左子树，和右子树
        TreeNode root = new TreeNode(slow.val);
        root.left = sortedListToBST(head);
        root.right = sortedListToBST(slow.next);
        return root;

    }
}
