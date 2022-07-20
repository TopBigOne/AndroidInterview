package linked_list.leet_code_206;

import linked_list.ListNode;

/**
 * @author : dev
 * @version :
 * @Date :  2022/7/20 03:27
 * @Desc :
 */
public class ReverseLinkList3 {
    public ListNode reverseList(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode pre = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode temp = curr.next;
            curr.next = pre;
            pre = curr;
            curr = temp;
        }
        return pre;
    }
}
