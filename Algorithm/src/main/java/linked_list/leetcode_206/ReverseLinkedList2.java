package linked_list.leetcode_206;

import linked_list.ListNode;

/**
 * @author : dev
 * @version :
 * @Date :  2021/5/7 19:53
 * @Desc : 用递归反转链表
 */
public class ReverseLinkedList2 {
    public ListNode reverse(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode last = reverse(head.next);
        head.next.next = head;
        head.next = null;
        return last;

    }
}
