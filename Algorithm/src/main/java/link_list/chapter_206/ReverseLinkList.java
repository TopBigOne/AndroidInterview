package link_list.chapter_206;


import java.util.List;

import link_list.ListNode;

/**
 * @author : dev
 * @version :
 * @Date :  1/25/21 5:19 PM
 * @Desc : 反转链表
 */
public class ReverseLinkList {
    public ListNode reverseList(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode cur = null;
        ListNode pre = head;
        while (pre != null) {
            ListNode t = pre.next;
            pre.next = cur;
            cur = pre;
            pre = t;
        }
        return cur;
    }

    public ListNode reverseList2(ListNode head) {
        ListNode cur = null;
        ListNode pre = head;
        while (pre != null) {
            ListNode temp = pre.next;
            pre.next = cur;
            cur = pre;
            pre = temp;
        }
        return cur;
    }

    public ListNode reverseList3(ListNode head) {
        ListNode cur = null;
        ListNode pre = head;
        while (pre != null) {
            ListNode temp = pre.next;
            pre.next = cur;
            cur = pre;
            pre = temp;
        }
        return cur;
    }

    public ListNode reverList4(ListNode head) {
        ListNode cur = null;
        ListNode pre = head;
        while (pre != null) {
            ListNode temp = pre.next;
            pre.next = cur;
            cur = pre;
            pre = temp;
        }
        return cur;
    }

    public ListNode reverseList5(ListNode head) {
        ListNode cur = null;
        ListNode pre = head;
        while (pre != null) {
            ListNode temp = pre.next;
            pre.next = cur;
            cur = pre;
            pre = temp;
        }
        return cur;
    }

    public ListNode reverseList6(ListNode head) {
        ListNode cur = null;
        ListNode pre = head;
        while (pre != null) {
            ListNode temp = pre.next;
            pre.next = cur;
            cur = pre;
            pre = temp;

        }
        return cur;
    }


    public ListNode reverseListNode7(ListNode head) {
        ListNode curr = null;
        ListNode pre = head;
        while (pre != null) {
            ListNode temp = pre.next;
            pre.next = curr;
            curr = pre;
            pre = temp;
        }

        return curr;
    }


    public ListNode reverseListNode8(ListNode head) {
        ListNode curr = null;
        ListNode pre = head;
        while (pre != null) {
            ListNode temp = pre.next;
            pre.next = curr;
            curr = pre;
            pre = temp;
        }

        return curr;
    }


}
