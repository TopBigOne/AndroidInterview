package linked_list.offer_22;

import linked_list.ListNode;

/**
 * @author : dev
 * @version :
 * @Date :  2022/6/2 18:07
 * @Desc :
 */
public class GetKthFromEnd2 {


    public ListNode getKthFromEnd(ListNode head, int k) {
        ListNode fast = head;
        ListNode slow = head;
        while (k>0){
            fast = fast.next;
            k--;
        }
        while (fast!=null){
            fast = fast.next;
            slow = slow.next;

        }
        return slow.next;
    }
}
