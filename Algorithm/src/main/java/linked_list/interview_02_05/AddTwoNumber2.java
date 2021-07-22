package linked_list.interview_02_05;

import linked_list.ListNode;

/**
 * @author :  dev
 * @version :
 * @Date :   2021/7/22 13:23
 * @Url :  https://leetcode-cn.com/problems/sum-lists-lcci/
 * @Level :    medium
 * @Desc : 字节：；面试题：链表求和：
 * @Counter : 14次
 * @Answer :
 */
public class AddTwoNumber2 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        ListNode dummy = new ListNode(-1);
        ListNode pre = dummy;
        ListNode p1 = l1;
        ListNode p2 = l2;
        int carry = 0;
        while (p1 != null || p2 != null) {
            int x = p1 == null ? 0 : p1.val;
            int y = p2 == null ? 0 : p2.val;

            int sum = x + y + carry;
            carry = sum / 10;

            pre.next = new ListNode(sum % 10);
            pre = pre.next;


            if (p1 != null) {
                p1 = p1.next;
            }
            if (p2 != null) {
                p2 = p2.next;
            }


        }

        if(carry>0){
            pre.next = new ListNode(carry);
        }

        return dummy.next;


    }
}
