package linked_list.leet_code_25;

import linked_list.ListNode;

/**
 * @author :  dev
 * @version :
 * @Date :   2022/1/9 21:22
 * @Url :
 * @Level :  easy  medium hard
 * @Desc :
 * @Counter :
 * @Answer :
 */
public class BaseOperation {
    public ListNode reverse(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode last = reverse(head.next);
        head.next.next = head;
        head.next = null;

        return last;
    }
}
