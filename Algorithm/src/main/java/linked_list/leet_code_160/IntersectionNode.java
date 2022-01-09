package linked_list.leet_code_160;

import linked_list.ListNode;

/**
 * @author : dev
 * @version :
 * @Date :  2021/5/8 18:56
 * @Desc : 字节 10次 ：相交链表 https://leetcode-cn.com/problems/intersection-of-two-linked-lists/
 * <p>
 * 题解：https://leetcode-cn.com/problems/intersection-of-two-linked-lists/solution/tu-jie-xiang-jiao-lian-biao-by-user7208t/
 * https://leetcode-cn.com/problems/intersection-of-two-linked-lists/solution/intersection-of-two-linked-lists-shuang-zhi-zhen-l/
 * <p>
 * 相似题目：
 * leetcode : 599 : 两个链表的最小索引总和： https://leetcode-cn.com/problems/minimum-index-sum-of-two-lists/
 */
public class IntersectionNode {
    public static void main(String[] args) {
        // common
        ListNode c1 = new ListNode(7);
        c1.next = new ListNode(8);
        c1.next.next = new ListNode(9);


        ListNode a1 = new ListNode(1);
        a1.next = new ListNode(2);
        a1.next.next = c1;


        ListNode b1 = new ListNode(4);
        b1.next = new ListNode(5);
        b1.next.next = new ListNode(6);
        b1.next.next.next = c1;

        IntersectionNode intersectionNode = new IntersectionNode();
        ListNode result = intersectionNode.getIntersectionNode(a1, b1);
        System.out.println("result : " + result);


    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        ListNode pA = headA;
        ListNode pB = headB;
        while (pA != pB) {
//            System.out.println("headA : "+headA);
//            System.out.println("headB : "+headB);
            System.out.println("pA:" + pA + " , pB:" + pB);
            System.out.println();
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

    public ListNode getIntersectionNode4(ListNode headA, ListNode headB) {
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

    public ListNode getIntersectionNode5(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;

        }

        ListNode pA = headA;
        ListNode pB = headB;
        while (pA != pB) {
            pA = pA == null ? headB : pA.next;
            pB = pB == null ? headA : pB.next;
        }
        return pA;
    }

    public ListNode getINtersectionNode6(ListNode headA, ListNode headB) {
        // 1: base corner
        if (headA == null || headB == null) {
            return null;
        }

        // 判断等性的指针变量
        ListNode pA = headA;
        ListNode pB = headB;
        while (pA != pB) {
            pA = pA == null ? headB : pA.next;
            pB = pB == null ? headA : pB.next;
        }
        return pA;
    }

    public ListNode getINtersectionNode7(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }

        // 判断等性的指针变量
        ListNode pA = headA;
        ListNode pB = headB;
        while (pA != pB) {
            pA = pA == null ? headB : pA.next;
            pB = pB == null ? headA : pB.next;
        }
        return pA;
    }


}
