package linked_list.leet_code_19;

import linked_list.BaseLinkedList;
import linked_list.ListNode;

/**
 * @author :  dev
 * @version :
 * @Date :   2022/2/2 16:04
 * @Url :
 * @Level :    medium
 * @Desc :
 * @Counter :
 * @Answer :
 */
public class RemoveNthFromEnd2 extends BaseLinkedList {
    public static void main(String[] args) {
        ListNode listNode = generateListNode(1,2,3,4,5,6);
        RemoveNthFromEnd2 nthFromEnd = new RemoveNthFromEnd2();
        nthFromEnd.removeNthFromEnd(listNode,2);

    }
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode fast = dummy;
        ListNode slow = dummy;

        for (int i = 0; i <= n; i++) {
            fast = fast.next;
        }
        // 当fast等于空的时候，slow 落在了deleteNode 前面；
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
