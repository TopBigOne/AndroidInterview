package linked_list.leet_code_203;

import linked_list.ListNode;

/**
 * @author : dev
 * @version :
 * @Date :  5/17/21 10:21 PM
 * @Desc : leetcode 203 移除链表元素 ：https://leetcode-cn.com/problems/remove-linked-list-elements/
 * <p>
 * <p>
 * 题解：https://leetcode-cn.com/problems/remove-linked-list-elements/solution/203yi-chu-lian-biao-yuan-su-by-lewis-dxstabdzew/
 */
public class RemoveElements {
    public ListNode removeElements(ListNode head, int val) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;

        ListNode pre = dummy;
        while (pre.next != null) {
            if (pre.next.val == val) {
                pre.next = pre.next.next;
            } else {
                pre = pre.next;
            }
        }
        return dummy.next;
    }
    public static void main(String[] args) {
        ListNode head = new ListNode(7);
        head.next = new ListNode(7);

//        head.next.next = new ListNode(6);
//        head.next.next.next = new ListNode(3);
//        head.next.next.next.next = new ListNode(4);
//        head.next.next.next.next.next = new ListNode(5);
//        head.next.next.next.next.next.next = new ListNode(6);

        RemoveElements removeElement = new RemoveElements();
        ListNode result = removeElement.removeElements(head, 7);

        System.out.println("result : " + result);

    }

}
