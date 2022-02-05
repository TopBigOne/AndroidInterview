package linked_list.leet_code_143;

import linked_list.ListNode;

/**
 * @author :  dev
 * @version :
 * @Date :   2022/2/1 18:10
 * @Url :
 * @Level :  easy  medium hard
 * @Desc :
 * @Counter :
 * @Answer :
 */
public class BaseOperation {
    /**
     * 反转链表
     *
     * @param head
     * @return
     */
    public ListNode reverseListNode(ListNode head) {
        if (head == null) {
            return head;
        }
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

    public ListNode reverseListNode2(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode last = reverseListNode2(head.next);
        head.next.next = head;
        head.next = null;
        return last;


    }
}
