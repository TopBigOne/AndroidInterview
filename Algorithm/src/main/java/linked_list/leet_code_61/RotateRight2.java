package linked_list.leet_code_61;

import linked_list.ListNode;

/**
 * @author : dev
 * @version :
 * @Date :  2022/8/21 15:42
 * @Desc :  61. 旋转链表 https://leetcode.cn/problems/rotate-list/
 * 题解：https://www.youtube.com/watch?v=CABz3Nd64KQ
 */
public class RotateRight2 {

    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode index = head;
        int len = 1;
        while (index.next != null) {
            index = index.next;
            len++;
        }
        index.next = head;
        int realCount = len - k % len;
        for (int i = 1; i < realCount; i++) {
            head = head.next;

        }
        ListNode res = head.next;
        // 断开
        head.next = null;
        return res;
    }

    public ListNode rotateRight2(ListNode head, int k) {
        if (head == null || head.next == null) {
            return head;
        }

        int len = 1;
        ListNode index = head;
        while (index.next != null) {
            index = index.next;
            len++;
        }
        index.next = head;

        int realCount = len - k % len;
        for (int i = 1; i < realCount; i++) {
            head = head.next;
        }

        ListNode res = head.next;
        head.next = null;
        return res;


    }
}
