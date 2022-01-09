package linked_list.leet_code_142;

import linked_list.ListNode;

/**
 * @author : dev
 * @version :
 * @Date :  2021/5/20 19:49
 * @Desc : leet code 142 : 环形链表2： medium;
 * https://leetcode-cn.com/problems/linked-list-cycle-ii/
 * <p>
 * 题解：https://www.cnblogs.com/hiddenfox/p/3408931.html
 * 视频：https://www.youtube.com/watch?v=UkKBPGt5Nok
 */
public class DetectCycle {
    public ListNode detectCycle(ListNode head) {
        // 边界条件
        if (head == null) {
            return null;
        }
        // 快慢指针
        ListNode fast = head;
        ListNode slow = head;
        // 每次循环，快的比慢的多跑一步，在循环体里，就呈现出一种现象，fast指针，在追slow 指针
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            // 核心判断：重点看一下，这个"==" 操作，到底在链表什么条件下会返回true呢？
            if (slow == fast) {
                // 退出这个点，就是相遇点；
                break;
            }
        }

        // 保险可见
        if (fast == null || fast.next == null) {
            return null;
        }


        fast = head;
        while (slow != fast) {
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }

}
