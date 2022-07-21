package sort.merge_sort.leet_code_148;

import linked_list.ListNode;

/**
 * @author : dev
 * @version :
 * @Date :  2022/7/21 02:44
 * @Desc :
 */
public class SortList4 {
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode middleNode = getMiddle(head);
        ListNode next = middleNode.next;
        middleNode.next = null;

        ListNode left = sortList(head);
        ListNode right = sortList(next);
        return mergeSortList(left, right);

    }

    private ListNode mergeSortList(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        if (l1.val < l2.val) {
            l1.next = mergeSortList(l1.next, l2);
            return l1;
        }
        l2.next = mergeSortList(l1, l2.next);
        return l2;
    }

    private ListNode getMiddle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }


}
