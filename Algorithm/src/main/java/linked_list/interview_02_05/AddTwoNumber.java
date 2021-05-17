package linked_list.interview_02_05;

import linked_list.ListNode;

/**
 * @author : dev
 * @version :
 * @Date :  2021/5/14 20:45
 * @Desc : 字节：14次；面试题：链表求和：https://leetcode-cn.com/problems/sum-lists-lcci/
 * <p>
 * 示例：
 * <p>
 * 示例：
 * <p>
 * 输入：(6 -> 1 -> 7) + (2 -> 9 -> 5)，即617 + 295
 * 输出：9 -> 1 -> 2，即912
 *
 * 题解：https://leetcode-cn.com/problems/sum-lists-lcci/solution/clian-biao-mo-ni-shou-gong-qiu-he-jian-dan-yi-dong/
 */
public class AddTwoNumber {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(-1);
        ListNode p1 = l1;
        ListNode p2 = l2;
        ListNode p = dummy;
        int carry = 0;

        while (p1 != null || p2 != null || carry != 0) {
            int sum = 0;
            if (p1 != null) {
                sum += p1.val;
                p1 = p1.next;
            }
            if (p2 != null) {
                sum += p2.val;
                p2 = p2.next;
            }

            // 加上上一位的进位
            sum += carry;
            // 得到当前位 数字
            ListNode temp = new ListNode(sum % 10);
            // 得到当前为 对下一位的进位
            carry = sum / 10;
            // 当前位连接上去
            p.next = temp;
            p = p.next;
        }
        return dummy.next;
    }


}
