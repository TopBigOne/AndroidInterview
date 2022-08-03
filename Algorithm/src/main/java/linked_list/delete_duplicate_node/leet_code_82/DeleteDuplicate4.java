package linked_list.delete_duplicate_node.leet_code_82;

import linked_list.ListNode;

/**
 * @author :  dev
 * @version :
 * @Date :   2022/2/3 17:16
 * @Url : https://leetcode-cn.com/problems/remove-duplicates-from-sorted-list-ii/
 * @Level :  easy  medium hard
 * @Desc : 删除链表中的重复元素
 * @Counter :
 * @Answer :
 */
public class DeleteDuplicate4 {

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(3);
        head.next.next.next.next = new ListNode(4);
        head.next.next.next.next.next = new ListNode(4);
        head.next.next.next.next.next.next = new ListNode(5);
        DeleteDuplicate4 deleteDuplicate = new DeleteDuplicate4();
        deleteDuplicate.deleteDuplicates(head);
    }

    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode pre = dummy;
        ListNode curr = head;
        while (curr != null) {
            while (curr.next != null && curr.val == curr.next.val) {
                curr = curr.next;
            }
            if (pre.next == curr) {
                pre = pre.next;
            } else {
                pre.next = curr.next;
            }
            curr = curr.next;
        }
        return dummy.next;
    }

    public ListNode deleteDuplicates2(ListNode head) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode pre = dummy;
        ListNode curr = head;
        while (curr != null) {
            while (curr.next != null && curr.val == curr.next.val) {
                curr = curr.next;
            }
            if (pre.next == curr) {
                pre = pre.next;

            } else {
                pre.next = curr.next;
            }
            curr = curr.next;
        }

        return dummy.next;

    }

    public ListNode deleteDuplicates3(ListNode head) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode pre = dummy;
        ListNode curr = head;
        while (curr != null) {
            while (curr.next != null && curr.val == curr.next.val) {
                curr = curr.next;
            }
            if (pre.next == curr) {
                pre = pre.next;
            } else {
                pre.next = curr.next;
            }
            curr = curr.next;
        }

        return dummy.next;

    }


}
