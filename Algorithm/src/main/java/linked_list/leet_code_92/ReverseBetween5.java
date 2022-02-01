package linked_list.leet_code_92;

import linked_list.ListNode;

/**
 * @author :  dev
 * @version :
 * @Date :   2022/2/1 19:38
 * @Url :
 * @Level :  easy  medium hard
 * @Desc :
 * @Counter :
 * @Answer :https://leetcode-cn.com/problems/reverse-linked-list-ii/solution/java-shuang-zhi-zhen-tou-cha-fa-by-mu-yi-cheng-zho/
 */
public class ReverseBetween5 {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;

        ListNode guard = dummy;
        ListNode point = guard.next;

        for (int i = 0; i < m - 1; i++) {
            guard = guard.next;
            point = point.next;

        }
        for (int i = 0; i < n - m; i++) {
            ListNode removedNode = point.next;
            point.next = point.next.next;

            removedNode.next = guard.next;
            guard.next = removedNode;

        }

        return dummy.next;


    }
}
