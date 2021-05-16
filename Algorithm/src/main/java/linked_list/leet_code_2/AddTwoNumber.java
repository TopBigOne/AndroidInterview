package linked_list.leet_code_2;

import linked_list.ListNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Currency;
import java.util.List;
import java.util.function.Predicate;

/**
 * @author : dev
 * @version :
 * @Date :  2021/3/23 18:49
 * @Desc : 两数相加 字节：60 次（https://leetcode-cn.com/problems/add-two-numbers/）
 * 链表解法（https://leetcode-cn.com/problems/add-two-numbers/solution/hua-jie-suan-fa-2-liang-shu-xiang-jia-by-guanpengc/）
 * <p>
 * https://www.youtube.com/watch?v=wDf2wcyP1iU(山景城一姐)
 * <p>
 * <p>
 * 【加法模范】秒杀所有逐位相加：https://leetcode-cn.com/problems/add-to-array-form-of-integer/solution/989-ji-zhu-zhe-ge-jia-fa-mo-ban-miao-sha-8y9r/
 * 可参考，谷歌高频面试题：809 ：情感丰富的数字
 */
public class AddTwoNumber {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode pre = new ListNode(-1);
        ListNode cur = pre;
        ListNode p1 = l1;
        ListNode p2 = l2;
        int carry = 0;

        while (p1 != null || p2 != null) {
            int x = p1 == null ? 0 : p1.val;
            int y = p2 == null ? 0 : p2.val;
            int sum = carry + x + y;
            carry = sum / 10;
            sum %= 10;
            cur.next = new ListNode(sum);

            cur = cur.next;
            if (p1 != null) {
                p1 = p1.next;
            }
            if (p2 != null) {
                p2 = p2.next;
            }
        }
        if (carry > 0) {
            cur.next = new ListNode(carry);
        }
        return pre.next;
    }


    public ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(-1);

        ListNode pre = dummy;
        ListNode p1 = l1;
        ListNode p2 = l2;
        System.out.println("before : dummy " + dummy);

        int carry = 0;
        while (p1 != null || p2 != null) {
            int x = p1 == null ? 0 : p1.val;
            int y = p2 == null ? 0 : p2.val;
            int sum = carry + x + y;
            carry = sum / 10;
            pre.next = new ListNode(sum % 10);
            // 将新节点的赋值给原来的节点；
            // pre 只保持一个节点
            System.out.println("before pre  : " + pre);
            System.out.println("before dummy: dummy " + dummy);
            pre = pre.next;
            System.out.println("after  pre  : " + pre);
            System.out.println("after dummy : dummy " + dummy);

            if (p1 != null) {
                p1 = p1.next;
            }
            if (p2 != null) {
                p2 = p2.next;
            }
        }

        // 最后还要check一下，最后一位的carry是不是大于0？
        // 大于0 的话，就表示x>y
        if (carry > 0) {
            pre.next = new ListNode(carry);
        }

        return dummy.next;


    }


    public ListNode addTwoNumbers3(ListNode l1, ListNode l2) {
        ListNode p1 = l1;
        ListNode p2 = l2;
        ListNode pre = new ListNode(-1);
        ListNode cur = pre;
        int carry = 0;
        while (p1 != null || p2 != null) {
            int x = p1 == null ? 0 : p1.val;
            int y = p2 == null ? 0 : p2.val;
            int sum = x + y + carry;
            carry = sum / 10;
            sum %= 10;
            cur.next = new ListNode(sum);
            cur = cur.next;
            if (p2 != null) {
                p2 = p2.next;
            }
            if (p1 != null) {
                p1 = p1.next;
            }
        }
        if (carry > 0) {
            cur.next = new ListNode(carry);
        }
        return pre.next;
    }

    public ListNode addTwoNumber4(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(-1);
        ListNode p1 = l1;
        ListNode p2 = l2;
        ListNode cur = dummy;

        int carry = 0;
        while (p1 != null || p2 != null) {
            int x = p1 == null ? 0 : p1.val;
            int y = p2 == null ? 0 : p2.val;

            int sum = carry + x + y;
            carry = sum / 10;
            sum %= 10;

            cur.next = new ListNode(sum);
            cur = cur.next;

            if (p1 != null) {
                p1 = p1.next;
            }

            if (p2 != null) {
                p2 = p2.next;
            }
            if (carry > 0) {
                cur.next = new ListNode(carry);
            }

        }

        return dummy.next;

    }

    public ListNode addTwoNumber5(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(-1);
        ListNode pre = dummy;
        ListNode p1 = l1;
        ListNode p2 = l2;
        int carry = 0;

        while (p1 != null || p2 != null) {
            int x = l1 == null ? 0 : l1.val;
            int y = l2 == null ? 0 : l2.val;
            int sum = carry + x + y;
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
        if (carry > 0) {
            pre.next = new ListNode(carry);
        }

        return dummy.next;

    }


}
