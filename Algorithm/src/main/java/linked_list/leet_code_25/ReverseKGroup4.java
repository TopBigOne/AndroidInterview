package linked_list.leet_code_25;

import java.util.List;

import linked_list.ListNode;

/**
 * @author : dev
 * @version :
 * @Date :  7/1/21 1:02 AM
 * @Desc : K个一组反转链表：字节：36次：https://leetcode-cn.com/problems/reverse-nodes-in-k-group/
 */
public class ReverseKGroup4 {

    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy;
        ListNode end = dummy;
        while (end.next != null) {
            // 找到第 k 个节点
            for (int i = 0; i < k && end != null; i++) {
                end = end.next;
            }
            if (end == null) {
                break;
            }
            ListNode start = pre.next;
            ListNode temp = end.next;
            // help GC;
            end.next = null;
            pre.next = reverse(start);
            start.next = temp;
            pre = start;
            end = pre;
        }

        return dummy.next;

    }

    private ListNode reverseKGroup2(ListNode head, int k) {
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
            ListNode start = pre.next;
            ListNode temp = end.next;
            // help GC;
            end.next = null;
            pre.next = reverse(start);
            start.next = temp;

            pre = start;
            end = pre;
        }

        return dummy.next;
    }


    private ListNode reverse(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode curr = reverse(head.next);
        head.next.next = head;
        head.next = null;
        return curr;
    }

    public ListNode reverseKGroup3(ListNode head, int k) {
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
            ListNode start = pre.next;
            ListNode temp = end.next;
            end.next = null;
            pre.next = reverse(start);
            start.next = temp;

            pre = start;
            end = pre;
        }

        return dummy.next;
    }

    public ListNode reverseKGroup4(ListNode head, int k) {
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

            ListNode start = pre.next;
            ListNode temp = end.next;
            end.next = null;

            pre.next = reverse(start);
            start.next = temp;

            pre = start;
            end = pre;
        }
        return dummy.next;
    }


}
