package linked_list.leet_code_92;

import linked_list.ListNode;

/**
 * @author :  dev
 * @version :
 * @Date :   2022/2/1 19:38
 * @Url :
 * @Level :  easy  medium hard
 * @Desc :
 * @Counter :
 * @Answer :https://leetcode-cn.com/problems/reverse-linked-list-ii/solution/java-shuang-zhi-zhen-tou-cha-fa-by-mu-yi-cheng-zho/
 */
public class ReverseBetween5 {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;

        ListNode guard = dummy;
        ListNode point = guard.next;

        for (int i = 0; i < m - 1; i++) {
            guard = guard.next;
            point = point.next;

        }
        for (int i = 0; i < n - m; i++) {
            ListNode removedNode = point.next;
            point.next = point.next.next;

            removedNode.next = guard.next;
            guard.next = removedNode;

        }

        return dummy.next;

    }

    public ListNode reverseBetween2(ListNode head, int m, int n) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        // m 前一个位置
        ListNode guard = dummy;
        // m 位置
        ListNode point = guard.next;

        for (int i = 0; i < m - 1; i++) {
            guard = guard.next;
            point = point.next;
        }
        for (int i = 0; i < n - m; i++) {
            ListNode removeNode = point.next;
            point.next = point.next.next;
            removeNode.next = guard.next;
            guard.next = removeNode;
        }

        return dummy.next;

    }

    public ListNode reverseBetween3(ListNode head, int m, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy;
        ListNode curr = pre.next;
        for (int i = 0; i < m - 1; i++) {
            pre = pre.next;
            curr = curr.next;
        }

        for (int i = 0; i < n - m; i++) {
            ListNode removeNode = curr.next;
            curr.next = curr.next.next;
            removeNode.next = pre.next;
            pre.next = removeNode;
        }

        return dummy.next;

    }

    public ListNode reverseBetween4(ListNode head, int m, int n) {

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode guard = dummy;
        ListNode point = guard.next;
        for (int i = 0; i < m - 1; i++) {
            guard = guard.next;
            point = point.next;
        }

        for (int i = 0; i < n - m; i++) {
            ListNode removeNode = point.next;
            point.next = point.next.next;
            removeNode.next = guard.next;
            guard.next = removeNode;
        }

        return dummy.next;
    }

    public ListNode reverseBetween5(ListNode head, int m, int n) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode pre = dummy;
        ListNode curr = pre.next;
        for (int i = 0; i < m - 1; i++) {
            pre = pre.next;
            curr = curr.next;
        }

        for (int i = 0; i < n - m; i++) {
            ListNode removeNode = curr.next;
            curr.next = curr.next.next;
            removeNode.next = pre.next;
            pre.next = removeNode;
        }
        return dummy.next;
    }

    public ListNode reverseBetween6(ListNode head, int m, int n) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode pre = dummy;
        ListNode curr = pre.next;
        for (int i = 0; i < m - 1; i++) {
            pre = pre.next;
            curr = curr.next;
        }
        for (int i = 0; i < n - m; i++) {
            ListNode removeNode = curr.next;
            curr.next = curr.next.next;
            removeNode.next = pre.next;
            pre.next = removeNode;
        }
        return dummy.next;
    }

    public ListNode reverseBetween7(ListNode head, int m, int n) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode pre = dummy;
        ListNode curr = pre.next;
        for (int i = 0; i < m - 1; i++) {
            pre = pre.next;
            curr = curr.next;
        }
        for (int i = 0; i < n - m; i++) {
            ListNode removeNode = curr.next;
            curr.next = curr.next.next;
            removeNode.next = pre.next;
            pre.next = removeNode;
        }

        return dummy.next;
    }

    public ListNode reverseBetween8(ListNode head, int m, int n) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode pre = dummy;
        ListNode curr = pre.next;
        for (int i = 0; i < m - 1; i++) {
            pre = pre.next;
            curr = curr.next;
        }
        for (int i = 0; i < n - m; i++) {
            ListNode removeNode = curr.next;
            curr.next = curr.next.next;
            removeNode.next = pre.next;
            pre.next = removeNode;
        }
        return dummy.next;

    }

    public ListNode reverseBetween9(ListNode head, int m, int n) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode pre = dummy;
        ListNode curr = pre.next;
        for (int i = 0; i < m - 1; i++) {
            pre = pre.next;
            curr = curr.next;
        }
        for (int i = 0; i < n - m; i++) {
            // 4-5-6
            ListNode removeNode = curr.next;
            curr.next = curr.next.next;
            removeNode.next = pre.next;
            pre.next = removeNode;
        }
        return dummy.next;
    }

    public ListNode reverseBetween10(ListNode head, int m, int n) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode pre = dummy;
        ListNode curr = pre.next;
        for (int i = 0; i < m - 1; i++) {
            pre = pre.next;
            curr = curr.next;
        }
        for (int i = 0; i < n - m; i++) {
            ListNode removeNode = curr.next;
            curr.next = curr.next.next;
            removeNode.next = pre.next;
            pre.next = removeNode;
        }

        return dummy.next;


    }


}
