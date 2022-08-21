package linked_list.leet_code_61;

import linked_list.ListNode;

/**
 * @author : dev
 * @version :
 * @Date :  5/16/21 9:26 PM
 * @Desc : leetcode 61：旋转链表：https://leetcode-cn.com/problems/rotate-list/
 * 字节：12 次；
 */
public class RotateRight {


    public ListNode rotateRight(ListNode head, int k) {
        // 边界条件
        if (head == null || head.next == null) {
            return head;
        }
        int len = 0;
        ListNode cur = head;
        while (cur != null) {
            len++;
            cur = cur.next;
        }
        // 对长度取余
        k %= len;
        if (k == 0) {
            return head;
        }
        ListNode fast = head;
        ListNode slow = head;
        // 让 fast 先向后走 k 步;
        for (int i = 0; i < k; i++) {
            fast = fast.next;
        }
        // 此时 slow 和 fast 之间的距离是 k； fast 指向第 k+1 节点；
        // 当 fast.next 为空时，fast 指向链表最后一个节点，slow 指向倒数 k+1 个节点
        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        // newHead 是倒数第 k 个节点，即表示新链表的头；
        ListNode newHead = slow.next;
        // 让倒数第 k+1 个节点和倒数第 k 个节点断开
        slow.next = null;
        // 让 最后一个节点指向原始链表的头
        fast.next = head;
        return newHead;

    }
}
