package linked_list.leet_code_82;

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

    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode pre = dummy;
        ListNode curr = pre.next;

        if (head == null || head.next == null) {
            return head;
        }
        while (curr != null) {
            while (curr.next != null && curr.next.val == curr.val) {
                pre = pre.next;
            }
            if (curr == pre.next) {
                pre = pre.next;
            } else {
                pre.next = curr.next;
            }

            curr = curr.next;
        }
        return dummy.next;
    }

    public ListNode deleteDuplicates2(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode pre = dummy;
        ListNode curr = pre.next;

        while (curr != null) {
            while (curr.next != null && curr.next.val == curr.val) {
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
        if (head == null || head.next == null) {
            return head;
        }
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode pre = dummy;
        ListNode curr = pre.next;
        while (curr != null) {
            while (curr.next != null && curr.next.val == curr.val) {
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
