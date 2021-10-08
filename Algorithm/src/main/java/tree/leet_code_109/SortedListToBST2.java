package tree.leet_code_109;

import linked_list.ListNode;
import tree.TreeNode;

/**
 * @author :  dev
 * @version :
 * @Date :   2021/10/2 13:11
 * @Url :  https://leetcode-cn.com/problems/convert-sorted-list-to-binary-search-tree/
 * @Level :    medium
 * @Desc : 有序链表转换： ：给定一个单链表，其中的元素按升序排序，将其转换为高度平衡的二叉搜索树。
 * @Counter :
 * @Answer :  https://leetcode-cn.com/problems/convert-sorted-list-to-binary-search-tree/solution/shou-hua-tu-jie-san-chong-jie-fa-jie-zhu-shu-zu-ku/
 */
public class SortedListToBST2 {

    public static void main(String[] args) {
        SortedListToBST2 sortedListToBST = new SortedListToBST2();
        ListNode head = new ListNode(-10);
        head.next = new ListNode(-3);
        head.next.next = new ListNode(0);
        head.next.next.next = new ListNode(5);
        head.next.next.next.next = new ListNode(9);
        TreeNode treeNode = sortedListToBST.sortedListToBST(head);


    }

    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) {
            return null;
        }
        if (head.next == null) {
            return new TreeNode(head.val);
        }
        ListNode slow = head;
        ListNode fast = head;
        ListNode pre = null;
        // 快慢指针找中点
        while (fast != null && fast.next != null) {
            pre = slow;
            fast = fast.next.next;
            slow = slow.next;

        }
        pre.next = null;
        // 以升序链表的中间元素作为根节点root，递归的构建root的左子树和右子树

        int slowValue = slow.val;
        System.out.println("slowValue : "+slowValue);
        TreeNode root = new TreeNode(slow.val);
        root.left = sortedListToBST(head);
        root.right = sortedListToBST(slow.next);
        return root;

    }

}
