package linked_list.delete_duplicate_node.leet_code_83;

import linked_list.ListNode;

/**
 * @author : dev
 * @version :
 * @Date :  2022/8/3 18:18
 * @Desc :
 */
public class DeleteDuplicate3 {

    public ListNode deleteDuplicates(ListNode head) {
        ListNode curr = head;

        while (curr != null && curr.next != null) {
            if (curr.val == curr.next.val) {
                curr.next = curr.next.next;
            } else {
                curr = curr.next;
            }
        }

        return head;


    }

    public ListNode deleteDuplicates2(ListNode head) {
        ListNode curr = head;
        while (curr != null && curr.next != null) {
            if (curr.val == curr.next.val) {
                curr.next = curr.next.next;

            } else {
                curr = curr.next;
            }
        }
        return head;


    }
}
