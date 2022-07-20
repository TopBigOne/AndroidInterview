package linked_list.leet_code_141;

import linked_list.ListNode;

/**
 * @author : dev
 * @version :
 * @Date :  2022/7/20 01:43
 * @Desc :141. 环形链表 :https://leetcode.cn/problems/linked-list-cycle/
 */
public class HasCycle2 {
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            ListNode fast1 = fast;
            if (fast == slow) {
                return true;
            }
        }
        return false;

    }


}
