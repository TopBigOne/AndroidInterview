package linked_list.leet_code_142;

import linked_list.ListNode;

/**
 * @author :  dev
 * @version :
 * @Date :   2022/1/9 14:33
 * @Url : https://leetcode-cn.com/problems/linked-list-cycle-ii/submissions/
 * @Level :    medium
 * @Desc :
 * @Counter :
 * @Answer :
 */
public class DetectCycle3 {
    public ListNode detectCycle(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode fast = head;
        ListNode slow = head;
        do {
            if (fast == null || fast.next == null) {
                return null;
            }
            fast = fast.next.next;
            slow = slow.next;
        } while (fast != slow);

        slow = head;
        while (fast != slow) {
            fast = fast.next;
            slow = slow.next;
        }

        return slow;

    }
}
