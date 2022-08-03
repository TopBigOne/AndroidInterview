package linked_list.leet_code_24;

import linked_list.ListNode;

/**
 * @author : dev
 * @version :
 * @Date :  2022/8/3 22:16
 * @Desc :
 */
public class SwapPair3 {
    public ListNode swapPairs(ListNode head) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode pre = dummy;
        ListNode curr = head;
        while (curr != null && curr.next != null) {
            ListNode mark1 = curr.next;
            ListNode mark2 = curr.next.next;

            curr.next.next = curr;
            curr.next = mark2;
            pre.next = mark1;

            pre = curr;
            curr = mark2;
        }
        return dummy.next;


    }

    public ListNode swapPairs2(ListNode head) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode pre = dummy;
        ListNode curr = head;

        while (curr != null && curr.next != null) {
            ListNode mark1 = curr.next;
            ListNode mark2 = curr.next.next;

            curr.next.next = curr;
            curr.next = mark2;
            pre.next = mark1;
            pre = curr;
            curr = mark2;

        }
        return dummy.next;


    }

    public ListNode swapPairs3(ListNode head) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode pre = dummy;
        ListNode curr = head;

        while (curr != null && curr.next != null) {
            ListNode mark1 = curr.next;
            ListNode mark2 = curr.next.next;

            // 像链表翻转中的递归
            curr.next.next = curr;
            curr.next = mark2;
            pre.next = mark1;

            pre = curr;
            curr = mark2;

        }
        return dummy.next;


    }

    public ListNode swapPairs4(ListNode head) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode pre = dummy;
        ListNode curr = head;

        while (curr != null && curr.next != null) {
            ListNode mark1 = curr.next;
            ListNode mark2 = curr.next.next;

            curr.next.next = curr;
            curr.next = mark2;
            pre.next = mark1;

            pre = curr;
            curr = mark2;
        }
        return dummy.next;
    }

    public ListNode swapPairs5(ListNode head) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode pre = dummy;
        ListNode curr = head;

        while (curr != null && curr.next != null) {
            ListNode mark1 = curr.next;
            ListNode mark2 = curr.next.next;

            curr.next.next = curr;
            curr.next = mark2;
            pre.next = mark1;

            pre = curr;
            curr = mark2;

        }

        return dummy;

    }

    /**
     * 1 2 3 4 5 6
     *
     * @param head
     * @return
     */
    public ListNode swapPairs6(ListNode head) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode pre = dummy;
        ListNode curr = head;
        while (curr != null && curr.next != null) {
            ListNode mark1 = curr.next;
            ListNode mark2 = curr.next.next;

            curr.next.next = curr;
            curr.next = mark2;
            pre.next = mark1;
            pre = curr;
            curr = mark2;
        }
        return dummy.next;


    }
}
