package linked_list.interview_02_02;

import linked_list.ListNode;

/**
 * @author : dev
 * @version :
 * @Date :  5/17/21 10:07 PM
 * @Desc : 字节：3 次：（简单） 返回倒数第 k 个节点 https://leetcode-cn.com/problems/kth-node-from-end-of-list-lcci/
 * <p>
 * 实现一种算法，找出单向链表中倒数第 k 个节点。返回该节点的值。
 * <p>
 * 注意：本题相对原题稍作改动实现一种算法，找出单向链表中倒数第 k 个节点。返回该节点的值。
 * <p>
 * 注意：本题相对原题稍作改动
 * 示例：
 * <p>
 * 输入： 1->2->3->4->5 和 k = 2
 * 输出： 4
 */
public class kthToLast {

    public int kthToLast(ListNode head, int k) {
        ListNode fast = head;
        ListNode slow = head;
        for (int i = 0; i < k; i++) {
            fast = fast.next;
        }
        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }
        return slow.val;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        kthToLast kthToLast = new kthToLast();
        int result = kthToLast.kthToLast(head, 2);
        System.out.println("result : "+result);


    }
}
