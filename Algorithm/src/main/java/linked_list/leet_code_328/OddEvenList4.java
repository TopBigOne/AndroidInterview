package linked_list.leet_code_328;

import linked_list.ListNode;

/**
 * @author : dev
 * @version :
 * @Date :  2022/8/27 13:23
 * @Desc :
 */
public class OddEvenList4 {
    public ListNode oddEvenList(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode evenHead = head.next;

        ListNode odd = head;
        ListNode even = evenHead;
        while (even != null && even.next != null) {
            odd.next = even.next;
            odd = odd.next;


            even.next = odd.next;
            even = even.next;
        }
        odd.next = evenHead;
        return head;
    }
}
