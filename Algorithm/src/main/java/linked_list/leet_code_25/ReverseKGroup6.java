package linked_list.leet_code_25;

import linked_list.ListNode;

/**
 * @author :  dev
 * @version :
 * @Date :   2022/1/9 21:34
 * @Url : https://leetcode-cn.com/problems/reverse-nodes-in-k-group/solution/
 * @Level :   hard
 * @Desc :
 * @Counter :
 * @Answer :
 */
public class ReverseKGroup6 extends BaseOperation {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy;
        ListNode end = dummy;
        while (end.next != null) {
            for (int i = 0; i < k && end != null; i++) {
                end = end.next;
            }
            if (end == null) {
                break;
            }
            ListNode temp = end.next;
            end.next = null;
            ListNode start = pre.next;
            pre.next = reverse(start);
            start.next = temp;

            pre = start;
            end = start;
        }
        return dummy.next;
    }

    public ListNode reverseKGroup2(ListNode head, int k) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode pre = dummy;
        ListNode end = dummy;
        while (end.next != null) {
            for (int i = 0; i < k && end != null; i++) {
                end = end.next;
            }
            if (end == null) {
                break;
            }

            ListNode temp = end.next;
            end.next = null;
            ListNode start = pre.next;
            pre.next = reverse(start);
            start.next = temp;
            pre = start;
            end = start;
        }
        return dummy.next;
    }

    public ListNode reverseKGroup3(ListNode head, int k) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode dummy = new ListNode(-1);
        dummy.next = dummy;
        ListNode pre = dummy;
        ListNode end = dummy;
        while (end.next != null) {
            for (int i = 0; i < k && end != null; i++) {
                end = end.next;
            }

            if (end == null) {
                break;
            }
//            ListNode temp = end.next;
//            end.next = null;
//            ListNode start = pre.next;
//            pre.next = reverse(start);
//            start.next = temp;
//            pre = start;
//            end = start;

            ListNode temp = end.next;
            end.next = null;

            ListNode start = pre.next;
            pre.next = reverse(start);
            start.next = temp;
            pre = start;
            end = start;

        }
        return dummy.next;

    }
}
