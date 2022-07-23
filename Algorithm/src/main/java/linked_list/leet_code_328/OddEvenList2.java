package linked_list.leet_code_328;

import linked_list.ListNode;

/**
 * @author : dev
 * @version :
 * @Date :  2022/7/23 05:54
 * @Desc :
 * 题解：https://leetcode.cn/problems/odd-even-linked-list/solution/328-qi-ou-lian-biao-by-chen-wei-f-tzl0/
 */
public class OddEvenList2 {
    public ListNode oddEvenList(ListNode head) {
        if (head == null) {
            return null;
        }
        // 偶数head
        ListNode evenHead = head.next;

        // 奇数
        ListNode odd = head;
        // 偶数
        ListNode even = evenHead;

        while (even != null && even.next != null) {
            // 奇数指针的下一个，等于偶数指针的下一个
            odd.next = even.next;
            // 更新奇数指针
            odd = odd.next;

            // 偶数指针的下一个等于奇数数指针的下一个
            even.next = odd.next;
            // 更新偶数指针
            even = even.next;
        }

        odd.next = evenHead;
        return head;
    }
}
