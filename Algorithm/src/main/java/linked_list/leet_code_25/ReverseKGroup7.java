package linked_list.leet_code_25;

import linked_list.ListNode;

/**
 * @author : dev
 * @version :
 * @Date :  1/17/22 7:37 PM
 *  K个一组反转链表：字节：36次：https://leetcode-cn.com/problems/reverse-nodes-in-k-group/
 * @Desc : leetcode 25 : K个一组反转链表
 */
public class ReverseKGroup7 extends BaseOperation {
    public ListNode reverseKGroup(ListNode head, int k) {
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

            // 断开
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
        // 1: base
        if (head == null || head.next == null) {
            return head;
        }
        // 2:build a dummy node.
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
}
