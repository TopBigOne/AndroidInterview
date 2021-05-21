package linked_list.leet_code_86;

import linked_list.ListNode;

/**
 * @author : dev
 * @version :
 * @Date :  2021/5/21 11:26
 * @Desc : leetcode:86  分割链表 ：字节：6次 :分割链表： https://leetcode-cn.com/problems/partition-list/
 * <p>
 * 题解：https://leetcode-cn.com/problems/partition-list/solution/liang-ge-dummyran-hou-pin-jie-by-powcai/
 */
public class Partition {
    public ListNode partition(ListNode head, int x) {
        ListNode dummy1 = new ListNode(-1);
        ListNode dummy2 = new ListNode(-1);
        ListNode p1 = dummy1;
        ListNode p2 = dummy2;

        while (head != null) {
            if (head.val < x) {
                // 放小于x的节点
                p1.next = head;
                // 右移动
                p1 = p1.next;
            } else {
                // 放大于x的节点
                p2.next = head;
                // 右移动
                p2 = p2.next;
            }
            head = head.next;
        }

        p1.next = dummy2.next;
        p2.next = null;
        return dummy1.next;
    }

    public ListNode partition2(ListNode head, int x) {
        ListNode dummy1 = new ListNode(-1);
        ListNode dummy2 = new ListNode(-1);
        ListNode p1 = dummy1;
        ListNode p2 = dummy2;
        while (head != null) {
            if (head.val < x) {
                p1.next = head;
                p1 = p1.next;
            } else {
                p2.next = head;
                p2 = p2.next;
            }
            head = head.next;
        }
        p1.next = dummy2.next;
        p2.next = null;
        return dummy1.next;
    }

    public ListNode partition3(ListNode head, int x) {
        ListNode dummy1 = new ListNode(-1);
        ListNode dummy2 = new ListNode(-1);
        ListNode p1 = dummy1;
        ListNode p2 = dummy2;

        while (head != null) {
            if (head.val < x) {
                p1.next = head;
                p1 = p1.next;
            } else {
                p2.next = head;
                p2 = p2.next;
            }
            head = head.next;
        }

        p1.next = dummy2.next;
        p2.next = null;
        return dummy1.next;
    }

    public ListNode partition4(ListNode head, int x) {
        ListNode dummy1 = new ListNode(-1);
        ListNode dummy2 = new ListNode(-1);
        ListNode p1 = dummy1;
        ListNode p2 = dummy2;
        while (head!=null){
            if(head.val<x){
                p1.next = head;
                p1 = p1.next;
            }else {
                p2.next = head;
                p2  = p2.next;
            }
            head = head.next;
        }
        p1.next = dummy2.next;
        p2.next = null;
        return dummy1.next;

    }

}
