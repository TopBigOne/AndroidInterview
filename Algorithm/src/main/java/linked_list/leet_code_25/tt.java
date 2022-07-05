package linked_list.leet_code_25;

import linked_list.ListNode;

/**
 * @author : dev
 * @version :
 * @Date :  2022/7/5 13:13
 * @Desc :
 */
public class tt {

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
            return head;
        }
        ListNode last = reverse(head.next);
        head.next.next = head;
        head.next = null;
        return last;
    }


}
