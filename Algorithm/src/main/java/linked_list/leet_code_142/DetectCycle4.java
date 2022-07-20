package linked_list.leet_code_142;

import linked_list.ListNode;

/**
 * @author : dev
 * @version :
 * @Date :  2022/7/20 02:19
 * @Desc :
 */
public class DetectCycle4 {
    public ListNode detectCycle(ListNode head) {
        if (head == null) {
            return null;
        }

        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                break;
            }
        }

        // do the check
        if (fast == null || fast.next == null) {
            return null;
        }


        slow = head;
        while (fast != slow) {
            fast = fast.next;
            slow = slow.next;
        }
        return slow;


    }
}
