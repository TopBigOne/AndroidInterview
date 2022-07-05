package linked_list.leet_code_25;

import linked_list.ListNode;

/**
 * @author : dev
 * @version : https://leetcode.cn/problems/reverse-nodes-in-k-group/
 * @Date :  2022/7/5 11:36
 * @Desc :
 */
public class ReverseKGroup10 {

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

    private ListNode reverse(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode last = reverse(head.next);
        head.next.next = head;
        head.next = null;
        return last;
    }


}
