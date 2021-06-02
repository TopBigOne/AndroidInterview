package linked_list.interview_02_08;

import linked_list.ListNode;

/**
 * @author :  dev
 * @version :
 * @Date :  2021/6/2 10:57
 * @Url :https://leetcode-cn.com/problems/linked-list-cycle-lcci/
 * @Level :  medium
 * @Desc :  02.08 环路检测
 * @Counter :  4
 * @Answer :https://leetcode-cn.com/problems/linked-list-cycle-lcci/solution/kuai-man-zhi-zhen-zheng-ming-bi-jiao-yan-jin-by-ch/
 */
public class DetectCycle {
    /**
     * 判断俩表是否有环
     *
     * @param head
     * @return
     */
    public boolean isCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            // 1: 先做值操作；
            fast = fast.next.next;
            slow = slow.next;
            if (slow == fast) {
                return true;
            }

        }
        return false;

    }

    /**
     * ps: 总觉得这个代码，在什么地方写过....
     * @param head
     * @return
     */
    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            // 快慢指针相遇了；
            if (slow == fast) {
                break;
            }
        }
        if (fast != slow) {
            return null;
        }
        fast = head;
        while (fast != slow) {
            fast = fast.next;
            slow = slow.next;
        }
        return fast;
    }

}
