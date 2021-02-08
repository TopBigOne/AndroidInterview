package link_list.chapter_206;


import link_list.ListNode;

/**
 * @author : dev
 * @version :
 * @Date :  1/25/21 5:19 PM
 * @Desc : 反转链表
 */
public class ReverseLinkList {
    public ListNode reverseList(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode cur = null;
        ListNode pre = head;
        while (pre != null) {
            ListNode t = pre.next;
            pre.next = cur;
            cur = pre;
            pre = t;
        }
        return cur;
    }
}
