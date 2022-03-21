package linked_list.interview_02_05;

import linked_list.ListNode;

/**
 * @author :  dev
 * @version :
 * @Date :   2022/3/18 11:20
 * @Url :
 * @Level :    medium
 * @Desc :
 * @Counter :
 * @Answer :
 */
public class AddTwoNumber4 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode p1 = l1;
        ListNode p2 = l2;
        ListNode dummy = new ListNode(-1);
        ListNode curr = dummy;
        // 进位
        int carry = 0;
        while (p1 != null || p2 != null) {
            int x = p1 == null ? 0 : p1.val;
            int y = p2 == null ? 0 : p2.val;
            int sum = x + y + carry;
            carry = sum / 10;
            curr.next = new ListNode(sum % 10);
            curr = curr.next;
            if (p1 != null) {
                p1 = p1.next;
            }
            if (p2 != null) {
                p2 = p2.next;
            }
        }

        if (carry > 0) {
            curr.next = new ListNode(carry);
        }
        return dummy.next;

    }
}
