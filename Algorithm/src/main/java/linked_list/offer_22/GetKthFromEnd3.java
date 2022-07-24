package linked_list.offer_22;

import linked_list.BaseLinkedList;
import linked_list.ListNode;

/**
 * @author : dev
 * @version :
 * @Date :  2022/7/24 03:26
 * @Desc :
 */
public class GetKthFromEnd3 extends BaseLinkedList {
    public static void main(String[] args) {
        GetKthFromEnd3 getKthFromEnd = new GetKthFromEnd3();
        ListNode head = generateListNode(1, 2, 3, 4, 5);
        ListNode result = getKthFromEnd.getKthFromEnd(head, 2);

    }

    public ListNode getKthFromEnd(ListNode head, int k) {
        ListNode fast = head;
        ListNode slow = head;

        while (k > 0) {
            fast = fast.next;
            k--;
        }
        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }
}
