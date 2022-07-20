package linked_list.leet_code_19;

import linked_list.BaseLinkedList;
import linked_list.ListNode;

/**
 * @author : dev
 * @version :
 * @Date :  2022/7/20 07:15
 * @Desc :
 */
public class RemoveNthFromEnd4 extends BaseLinkedList {
    public static void main(String[] args) {
        ListNode head = generateListNode(1, 2, 3, 4, 5);
        RemoveNthFromEnd4 removeNthFromEnd = new RemoveNthFromEnd4();
        removeNthFromEnd.removeNthFromEnd(head, 2);

    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;

        ListNode fast = dummy;
        ListNode slow = dummy;
        for (int i = 0; i <= n; i++) {
            fast = fast.next;
        }

        while (fast != null) {
            slow = slow.next;
            fast = fast.next;
        }

        ListNode delNode = slow.next;
        slow.next = delNode.next;
        delNode.next = null;

        return dummy.next;
    }

    public ListNode removeNthFromEnd2(ListNode head, int n) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode fast = dummy;
        ListNode slow = dummy;
        for (int i = 0; i <= n; i++) {
            fast = fast.next;
        }
        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }
        ListNode delNode = slow.next;
        slow.next = delNode.next;
        delNode.next = null;
        return dummy.next;

    }
}
