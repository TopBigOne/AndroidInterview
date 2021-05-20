package linked_list.Leet_code_234;

import linked_list.ListNode;

/**
 * @author : dev
 * @version :
 * @Date :  2021/5/20 15:24
 * @Desc : leetcode 234 ：回文链表：https://leetcode-cn.com/problems/palindrome-linked-list/
 * <p>
 * 题解：https://leetcode-cn.com/problems/palindrom
 * e-linked-list/solution/di-gui-zhan-deng-3chong-jie-jue-fang-shi-zui-hao-d/
 */
public class Palindrome {

    public ListNode reverse(ListNode head) {
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

    /**
     * 通过找到链表的中间节点，然后把链表后半部分反转，最后再用后半部分反转的链表和前半部分一个个比较即可
     * <p>
     * 前提: 初始状态
     * 1: 先找到链表的中间节点
     * 2:  反转后半部分的链表，然后让fast重新指向链表头，接着fast和slow每次同时往后移动一步，查看节点值是否相等？
     *
     * @param head head
     * @return false;
     */
    public boolean isPalindrome(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        // 通过快慢指针找到中点
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        // fast 不为空，说明链表的长度是奇数
        if (fast != null) {
            slow = slow.next;
        }

        // 反转后半部分的链表
        slow = reverse(slow);

        fast = head;
        while (slow != null) {
            if (fast.val != slow.val) {
                return false;
            }
            fast = fast.next;
            slow = slow.next;
        }

        return true;

    }

    public boolean isPalindrome2(ListNode head) {
        // 1: 定义快慢指针 fast ,slow;
        // 2: fast 一次走两步，用慢指针找到链表的中点(注意根据fast.next 判断链表长度的奇偶性)
        // 3: 反转链表的后半部分
        // 4: 将head的值赋给fast
        // 5: 以slow 不为空 为条件，while 循环，将slow和fast的值依次取出来，做比较，发现一个不相等的，那就不是回文链表了；
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        if (fast != null) {
            slow = slow.next;
        }

        slow = reverse(slow);
        fast = head;

        while (slow != null) {
            if (slow.val != fast.val) {
                return false;
            }
            fast = fast.next;
            slow = slow.next;
        }
        return true;
    }


}
