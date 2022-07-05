package linked_list.leet_code_25;

import linked_list.ListNode;

/**
 * @author : dev
 * @version :https://leetcode.cn/problems/reverse-nodes-in-k-group/
 * @Date :  2022/6/29 00:37
 * @Desc :
 */
public class ReverseKGroup9 {

    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || head.next == null) {
            return head;
        }


        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode pre = dummy;
        ListNode end = dummy;
        while (end.next != null) {
            // 找到反转的结束节点
            for (int i = 0; i < k && end != null; i++) {
                end = end.next;
            }
            if (end == null) {
                break;
            }

            ListNode temp = end.next;
            // 断开end 的尾部
            end.next = null;

            ListNode start = pre.next;
            pre.next = reverse(start);
            start.next = temp;
            // 回归到新的状态
            pre = start;
            end = start;

        }

        return dummy.next;

    }

    /**
     * if (head == null || head.next == null) {
     * return head;
     * }
     * ListNode last = reverse(head.next);
     * head.next.next = head;
     * head.next = null;
     * <p>
     * return last;
     */
    private ListNode reverse(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }
        ListNode last = reverse(head.next);
        last.next.next = head;
        last.next = null;
        return last;
    }
}
