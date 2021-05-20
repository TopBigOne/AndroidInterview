package linked_list.leet_code_445;

import linked_list.ListNode;

/**
 * @author : dev
 * @version :
 * @Date :  2021/5/20 18:02
 * @Desc :leet code 445 :medium: 两数相加：https://leetcode-cn.com/problems/add-two-numbers-ii/
 *
 *
 *
 */
public class AddTwoNumber {
    public ListNode doReverse(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode pre = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode temp = curr.next;
            curr.next = pre;
            pre = curr;
            curr = temp;
        }
        return pre;
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }

        if (l2 == null) {
            return l1;
        }
        l1 = doReverse(l1);
        l2 = doReverse(l2);

        System.out.println("反转以后------");
        System.out.println("l1: " + l1);
        System.out.println("l2: " + l2);
        System.out.println("");
        System.out.println("");

        int carry = 0;
        ListNode dummy = new ListNode(-1);
        ListNode curr = dummy;

        while (l1 != null || l2 != null) {
            int x = l1 == null ? 0 : l1.val;
            int y = l2 == null ? 0 : l2.val;
            int sum = x + y + carry;
            // 进为
            carry = sum / 10;

            sum = sum % 10;

            curr.next = new ListNode(sum);
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
            curr = curr.next;
        }

        if (carry > 0) {
            curr.next = new ListNode(carry);
        }

        System.out.println("dummy : " + dummy.next);
        System.out.println("");
        System.out.println("");
        System.out.println("");

        return doReverse(dummy.next);


    }


}
