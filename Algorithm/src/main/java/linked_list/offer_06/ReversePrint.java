package linked_list.offer_06;

import java.util.ArrayList;
import java.util.List;

import linked_list.ListNode;

/**
 * @author : dev
 * @version :
 * @Date :  2/12/22 2:44 PM
 * @Desc :
 */
public class ReversePrint {

    public int[] reversePrint(ListNode head) {
        ListNode newNode = reverse(head);
        List<Integer> list = new ArrayList<>();
        ListNode temp = newNode;
        while (temp != null) {
            list.add(temp.val);
            temp = temp.next;
        }
        return list.stream().mapToInt(v -> v).toArray();
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
}
