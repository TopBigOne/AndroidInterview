package linked_list.leet_code_82;

import linked_list.ListNode;

/**
 * @author : dev
 * @version :
 * @Date :  2021/5/18 20:50
 * @Desc :    leetcode 82: 删除排序链表中的重复元素II：https://leetcode-cn.com/problems/remove-duplicates-from-sorted-list-ii/
 * <p>
 * 题解：https://leetcode-cn.com/problems/remove-duplicates-from-sorted-list-ii/solution/fu-xue-ming-zhu-di-gui-die-dai-yi-pian-t-wy0h/
 */
public class DeleteDuplicate {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy;
        ListNode curr = head;
        while (curr != null) {
            // 跳过当前的重复节点，使得cur指向当前重复元素的最后一个位置
            while (curr.next != null && curr.val == curr.next.next.val) {
                curr = curr.next;
            }
            if (pre.next == curr) {
                // pre 和 curr 之间没有重复节点，pre 往后移动一位
                pre = pre.next;
            } else {
                // pre->next 指向cur的下一个位置（相当于跳过了当前的重复元素）
                // 但是pre 不移动，仍然指向已经遍历的链表结尾
                pre.next = curr.next;
            }
            curr = curr.next;
        }

        return dummy.next;


    }

    public ListNode deleteDuplicates2(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy;
        ListNode curr = head;
        while (curr != null) {
            // 跳过当前的重复节点 ，使得cur 指向当前重复元素的最后一个位置
            while (curr.next != null && curr.val == curr.next.val) {
                curr = curr.next;
            }
            if (pre.next == curr) {
                // pre 和cur 之间没有重复节点，pre后移动
                pre = pre.next;
            } else {
                // pre->next 指向cur的下一个位置（相当于跳过了当前的重复元素）
                // 但是pre不移动，仍然指向已经遍历的链表结尾
                pre.next = curr.next;
            }
            curr = curr.next;
        }
        return dummy.next;
    }

    public ListNode deleteDuplicate3(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode pre = dummy;
        ListNode curr = head;
        while (curr != null) {
            while (curr.next != null && curr.val == curr.next.val) {
                curr = curr.next;
            }

            if (pre.next == curr) {
                pre = pre.next;
            } else {
                pre.next = curr.next;
            }
            curr = curr.next;
        }

        return dummy.next;
    }


    public ListNode deleteDuplicate4(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode pre = dummy;
        ListNode curr = head;

        while (curr != null) {
            while (curr.next != null && curr.next.val == curr.val) {
                curr = curr.next;
            }
            if (pre.next == curr) {
                pre = pre.next;
            } else {
                pre.next = curr.next;
            }
            curr = curr.next;
        }

        return dummy.next;
    }
}
