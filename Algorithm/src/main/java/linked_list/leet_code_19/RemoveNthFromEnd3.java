package linked_list.leet_code_19;

import linked_list.BaseLinkedList;
import linked_list.ListNode;

/**
 * @author :  dev
 * @version :
 * @Date :   2022/2/14 10:36
 * @Url :
 * @Level :  easy  medium hard
 * @Desc :
 * @Counter :
 * @Answer :
 */
public class RemoveNthFromEnd3  extends BaseLinkedList {

    public ListNode removeNthFromEnd(ListNode head, int n) {

        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode fast = dummy;
        ListNode slow = dummy;

        for (int i = 0; i <= n; i++) {
            fast = fast.next;

        }
        while (fast!=null){
            fast = fast.next;
            slow = slow.next;
        }
        ListNode delNode = slow.next;
        slow.next = delNode.next;
        delNode.next = null;
        return  dummy.next;



    }
}
