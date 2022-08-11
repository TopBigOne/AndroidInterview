package linked_list.byte_dance;

import linked_list.BaseLinkedList;
import linked_list.ListNode;

/**
 * @author : dev
 * @version :
 * @Date :  2022/8/11 18:03
 * @Desc :给定一个奇数位升序，偶数位降序的链表，将其重新排序。
 * <p>
 * 输入: 1->8->3->6->5->4->7->2->NULL
 * 输出: 1->2->3->4->5->6->7->8->NULL
 * <p>
 * https://mp.weixin.qq.com/s/0WVa2wIAeG0nYnVndZiEXQ
 */
public class SortOddEvenList extends BaseLinkedList {
    public static void main(String[] args) {
        SortOddEvenList sortOddEvenList = new SortOddEvenList();
        ListNode head = generateListNode(1, 8, 3, 6, 5, 4, 7, 2);
        ListNode result = sortOddEvenList.sortOddEvenList(head);
        System.err.println("result :");
        printlnListNode(result);
    }

    /**
     * 1-8-3-6-5-4-7-3
     *
     * @param head
     * @return
     */
    public ListNode sortOddEvenList(ListNode head) {
        ListNode oddListNode = getOddListNode(head);
        System.err.println("step 1 :");
        printlnListNode(oddListNode);
        ListNode evenListNode = getEvenListNode(head);
        System.err.println("step 2 :");
        printlnListNode(evenListNode);

        evenListNode = reverse(evenListNode);
        System.err.println("step 3 :");
        printlnListNode(evenListNode);

        return mergeListNode(oddListNode, evenListNode);
    }


    private ListNode getEvenListNode(ListNode head) {
        // 1,3,5,7,9
        ListNode dummy = new ListNode();
        ListNode curr = dummy;
        head = head.next;
        while (head != null) {
            curr.next = new ListNode(head.val);
            if (head.next == null) {
                break;
            }
            head = head.next.next;
            curr = curr.next;
        }

        return dummy.next;
    }

    private ListNode getOddListNode(ListNode head) {
        // 1,3,5,7,9
        ListNode dummy = new ListNode();
        ListNode curr = dummy;
        while (head != null && head.next != null) {
            curr.next = new ListNode(head.val);
            head = head.next.next;
            curr = curr.next;
        }

        return dummy.next;
    }

    private ListNode reverse(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode last = reverse(head.next);
        head.next.next = head;
        head.next = null;

        return last;
    }

    private ListNode mergeListNode(ListNode h1, ListNode h2) {
        ListNode l1 = h1;
        ListNode l2 = h2;

        ListNode dummy = new ListNode();
        ListNode curr = dummy;
        int d = 0;
        while (l1 != null && l2 != null) {
            if (d == 0) {
                curr.next = l1;
                l1 = l1.next;
            } else {
                curr.next = l2;
                l2 = l2.next;
            }
            d = 1 - d;
            curr = curr.next;
        }
        curr.next = l1 == null ? l2 : l1;
        return dummy.next;
    }
}
