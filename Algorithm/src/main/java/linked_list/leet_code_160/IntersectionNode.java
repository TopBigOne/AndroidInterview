package linked_list.leet_code_160;

import linked_list.ListNode;

/**
 * @author : dev
 * @version :
 * @Date :  2021/5/8 18:56
 * @Desc : 字节 10次 ：相交链表 https://leetcode-cn.com/problems/intersection-of-two-linked-lists/
 * <p>
 * 题解：https://leetcode-cn.com/problems/intersection-of-two-linked-lists/solution/tu-jie-xiang-jiao-lian-biao-by-user7208t/
 * <p>
 * 相似题目：
 * leetcode : 599 : 两个链表的最小索引总和： https://leetcode-cn.com/problems/minimum-index-sum-of-two-lists/
 */
public class IntersectionNode {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        ListNode pA = headA;
        ListNode pB = headB;
        while (pA != pB) {
            pA = pA == null ? headA : pA.next;
            pB = pB == null ? headB : pB.next;
        }
        return pA;
    }

    public ListNode getIntersectionNode2(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }

        ListNode pA = headA;
        ListNode pB = headB;
        while (pA != pB) {
            pA = pA == null ? headA : pA.next;
            pB = pB == null ? headB : pB.next;
        }
        return pA;
    }

    public ListNode getIntersectionNode3(ListNode headA, ListNode headB) {
        if (headA == null || headA == null) {
            return null;
        }
        ListNode pA = headA;
        ListNode pB = headB;
        while (pA != pB) {
            pA = pA == null ? headA : pA.next;
            pB = pB == null ? headB : pB.next;

        }
        return pA;

    }
}
