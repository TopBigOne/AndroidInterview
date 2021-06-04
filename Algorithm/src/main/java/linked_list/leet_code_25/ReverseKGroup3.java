package linked_list.leet_code_25;

import linked_list.ListNode;

/**
 * @author :  dev
 * @version :
 * @Date :  2021/6/4 11:15
 * @Url :  K个一组反转链表：字节：36次：https://leetcode-cn.com/problems/reverse-nodes-in-k-group/
 * @Level : easy medium hard
 * @Desc :
 * @Counter :
 * @Answer :
 * 视频：https://www.bilibili.com/video/BV1i44111721?from=search&seid=3623965927550448834
 */
public class ReverseKGroup3 {
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

    public ListNode reverse(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode pre = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode temp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = temp;
        }
        return pre;
    }

}
