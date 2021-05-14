package linked_list.leet_code_141;

import linked_list.ListNode;

/**
 * @author : dev
 * @version :
 * @Date :  2021/5/14 11:46
 * @Desc : 141:  字节：10次：easy 环形链表：https://leetcode-cn.com/problems/linked-list-cycle/
 * 用的是快慢指针
 */
public class HasCycle {
    public boolean hasCycle(ListNode head) {
        if (head == null) {
            return false;
        }
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && head.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (slow == fast) {
                return true;
            }
        }
        return false;
    }
}
