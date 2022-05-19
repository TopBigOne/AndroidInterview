package linked_list.leet_code_2;

import linked_list.ListNode;

/**
 * @author :  dev
 * @version :
 * @Date :   2022/3/18 11:33
 * @Url : 两数相加 字节：60 次（https://leetcode-cn.com/problems/add-two-numbers/）
 * @Level :    medium hard
 * @Desc :
 * @Counter :
 * @Answer :
 */
public class AddTwoNumber2 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode dummy = new ListNode();
        ListNode curr = dummy;

        int carry = 0;
        while (l1 != null || l2 != null) {
            int x = l1 == null ? 0 : l1.val;
            int y = l2 == null ? 0 : l2.val;
            int sum = x + y + carry;
            carry = sum / 10;
            sum %= 10;
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

        return dummy.next;


    }
}
