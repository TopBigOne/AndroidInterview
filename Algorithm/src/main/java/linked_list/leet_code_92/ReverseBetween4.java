package linked_list.leet_code_92;

import linked_list.ListNode;

/**
 * @author :  dev
 * @version :
 * @Date :   2022/2/1 19:22
 * @Url : https://leetcode-cn.com/problems/reverse-linked-list-ii/
 * @Level :    medium
 * @Desc :
 * @Counter :
 * @Answer :
 */
public class ReverseBetween4 {

    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (m == 1) {
            return reverseN(head, n);
        }

        head.next = reverseBetween(head.next, m - 1, n - 1);
        return head;
    }

    // 后驱节点
    ListNode successor = null;

    private ListNode reverseN(ListNode head, int n) {
        if (n == 1) {
            successor = head.next;
            return head;
        }
        ListNode last = reverseN(head.next, n - 1);
        head.next.next = head;
        head.next = successor;
        return last;
    }
}
