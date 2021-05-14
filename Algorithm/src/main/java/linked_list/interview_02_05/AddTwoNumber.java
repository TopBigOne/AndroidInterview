package linked_list.interview_02_05;

import linked_list.ListNode;

/**
 * @author : dev
 * @version :
 * @Date :  2021/5/14 20:45
 * @Desc : 字节：14次；面试题：链表求和：https://leetcode-cn.com/problems/sum-lists-lcci/
 * <p>
 * 示例：
 * <p>
 * 示例：
 * <p>
 * 输入：(6 -> 1 -> 7) + (2 -> 9 -> 5)，即617 + 295
 * 输出：9 -> 1 -> 2，即912
 */
public class AddTwoNumber {
    /**
     * 先相加再反转
     *
     * @param l1
     * @param l2
     * @return
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        l1= doReverse(l1);
        l2= doReverse(l2);

        ListNode dummy = new ListNode(-1);
        ListNode curr = dummy;
        ListNode p1 = l1;
        ListNode p2 = l2;

        int carry = 0;
        while (p1 != null || p2 != null) {
            int x = p1 == null ? 0 : p1.val;
            int y = p2 == null ? 0 : p2.val;
            int sum = carry + x + y;
            carry = sum / 10;
            curr.next = new ListNode(sum % 10);
            curr = curr.next;
            if (p1 != null) {
                p1 = p1.next;
            }
            if (p2 != null) {
                p2 = p2.next;
            }

        }
        if (carry > 0) {
            curr.next = new ListNode(carry);
        }

        return doReverse(dummy.next);

    }

    private ListNode doReverse(ListNode head) {
        ListNode pre = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode temp = curr.next;
            curr.next = pre;
            pre = curr;
            curr = temp;
        }
        return pre;
    }

}
