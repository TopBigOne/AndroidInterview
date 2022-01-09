package linked_list.leet_code_142;

import linked_list.ListNode;

/**
 * @author :  dev
 * @version :
 * @Date :   2022/1/9 14:09
 * @Url :https://leetcode-cn.com/problems/linked-list-cycle-ii/
 * @Level :  easy  medium hard
 * @Desc :
 * @Counter :
 * @Answer : https://www.cnblogs.com/hiddenfox/p/3408931.html
 */
public class DetectCycle2 {
    public ListNode detectCycle(ListNode head) {
        // 1: base corner
        if (head == null) return null;
        // 2:core logic
        ListNode slow = head;
        ListNode fast = head;
        do {
            // 说明不存在环
            if (fast == null || fast.next == null) {
                return null;
            }
            slow = slow.next;
            fast = fast.next.next;
            // 第一次相遇
        } while (fast != slow);

        // slow 从头开始走
        slow = head;
        // 二者相遇在y点，则退出
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }

        return slow;
    }

}
