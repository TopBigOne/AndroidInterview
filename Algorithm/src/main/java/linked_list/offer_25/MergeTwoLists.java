package linked_list.offer_25;

import linked_list.ListNode;

/**
 * @author : dev
 * @version :
 * @Date :  2022/6/3 20:25
 * @Desc :
 */
public class MergeTwoLists {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        ListNode dummy = new ListNode(-1);
        ListNode curr = dummy;

        while (l1 != null && l2 != null) {
            int v1 = l1.val;
            int v2 = l2.val;
            if (v1 < v2) {
                curr.next = new ListNode(v1);
                l1 = l1.next;
            } else {
                curr.next = new ListNode(v2);
                l2 = l2.next;
            }
            curr = curr.next;
        }

        curr.next = l1 == null ? l2 : l1;
        return dummy.next;

    }
}
