package linked_list.leetcode_206;

import linked_list.ListNode;

/**
 * @author : dev
 * @version :
 * @Date :  2021/5/7 19:53
 * @Desc : 用递归反转链表
 * 没办法，字节考递归啊；
 * https://leetcode-cn.com/problems/reverse-linked-list/submissions/
 *
 * 题解：https://leetcode-cn.com/problems/reverse-linked-list/solution/dong-hua-yan-shi-206-fan-zhuan-lian-biao-by-user74/
 */
public class ReverseLinkedList2 {

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        ReverseLinkedList2 reverseLinkedList = new ReverseLinkedList2();
        ListNode result = reverseLinkedList.reverseList2(head);
        System.out.println("result : " + result);

    }

    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        // 这里cur就是最后一个节点
        ListNode cur = reverseList(head.next);
        // 如果链表是1->2->3->4->5，那么此时cur 就是5；
        head.next.next = head;
        head .next = null;
        return cur;

    }

    /**
     * 用递归反转链表
     *
     * @param head
     * @return
     */
    public ListNode reverseList2(ListNode head) {
        // 没错，这是递归终止的条件
        if (head == null || head.next == null) {
            return head;
        }
        ListNode curr = reverseList2(head.next);
        System.out.println("curr value : "+curr.val+"， head value : "+head.val);
        head.next.next = head;
        head.next =null;
        return curr;
    }


}
