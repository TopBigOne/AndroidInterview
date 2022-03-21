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
        ListNode dummy = new ListNode(-1);
        ListNode curr = dummy;
        ListNode p1 = l1;
        ListNode p2 = l2;
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

        if(carry>0){
            curr.next = new ListNode(carry);
        }

        return dummy.next;


    }
}
